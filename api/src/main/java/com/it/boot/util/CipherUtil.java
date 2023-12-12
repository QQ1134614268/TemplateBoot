package com.it.boot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;

/**
 * 使用AES对文件进行加密和解密
 */
public class CipherUtil {


    public static String getResult(String inputStr) {
        String KEY_MD5 = "MD5";
        System.out.println("=======加密前的数据:" + inputStr);
        BigInteger bigInteger = null;

        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("MD5加密后:" + bigInteger.toString(16));
        return bigInteger.toString(16);
    }

    public static String getShaStrJava(String inputStr) throws NoSuchAlgorithmException {
        String KEY_SHA = "SHA";
        BigInteger sha;
        System.out.println("=======加密前的数据:" + inputStr);
        byte[] inputData = inputStr.getBytes();
        MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
        messageDigest.update(inputData);
        sha = new BigInteger(messageDigest.digest());
        System.out.println("SHA加密后:" + sha.toString(32));
        return sha.toString(32);
    }

    /**
     * 利用java原生的摘要实现SHA256加密 @param str 加密后的报文 @return
     */
    public static String getSHA256StrJava(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            encodeStr = BinUtil.byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    /**
     * 使用AES对文件进行加密和解密
     */
    private static final String type = "AES";

    /**
     * 把文件srcFile加密后存储为destFile
     *
     * @param srcFile    加密前的文件
     * @param destFile   加密后的文件
     * @param privateKey 密钥
     */
    public void encrypt(String srcFile, String destFile, String privateKey) throws GeneralSecurityException, IOException {
        Key key = getKey(privateKey);
        Cipher cipher = Cipher.getInstance(type + "/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        try (FileInputStream fis = new FileInputStream(srcFile);
             FileOutputStream fos = new FileOutputStream(mkdirFiles(destFile))) {
            crypt(fis, fos, cipher);
        }
    }

    /**
     * 把文件srcFile解密后存储为destFile
     *
     * @param srcFile    解密前的文件
     * @param destFile   解密后的文件
     * @param privateKey 密钥
     */
    public void decrypt(String srcFile, String destFile, String privateKey) throws GeneralSecurityException, IOException {
        Key key = getKey(privateKey);
        Cipher cipher = Cipher.getInstance(type + "/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);

        try (FileInputStream fis = new FileInputStream(srcFile);
             FileOutputStream fos = new FileOutputStream(mkdirFiles(destFile))) {

            crypt(fis, fos, cipher);
        }
    }

    /**
     * 根据filePath创建相应的目录
     *
     * @param filePath 要创建的文件路经
     * @return file 文件
     */
    private File mkdirFiles(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();

        return file;
    }

    /**
     * 生成指定字符串的密钥
     *
     * @param secret 要生成密钥的字符串
     * @return secretKey 生成后的密钥
     */
    private static Key getKey(String secret) throws GeneralSecurityException {
        KeyGenerator key = KeyGenerator.getInstance(type);
        key.init(128, new SecureRandom(secret.getBytes()));
        return key.generateKey();
    }

    /**
     * 加密解密流
     *
     * @param in     加密解密前的流
     * @param out    加密解密后的流
     * @param cipher 加密解密
     */
    private static void crypt(InputStream in, OutputStream out, Cipher cipher)
            throws IOException, GeneralSecurityException {
        int blockSize = cipher.getBlockSize() * 1000;
        int outputSize = cipher.getOutputSize(blockSize);

        byte[] inBytes = new byte[blockSize];
        byte[] outBytes = new byte[outputSize];

        int inLength = 0;
        boolean more = true;
        while (more) {
            inLength = in.read(inBytes);
            if (inLength == blockSize) {
                int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
                out.write(outBytes, 0, outLength);
            } else {
                more = false;
            }
        }
        if (inLength > 0)
            outBytes = cipher.doFinal(inBytes, 0, inLength);
        else
            outBytes = cipher.doFinal();
        out.write(outBytes);
    }

}

class AES {
    private static final Logger logger = LoggerFactory.getLogger(AES.class);
    private static final String defaultCharset = "UTF-8";
    private static final String KEY_AES = "AES";

    /**
     * 加密
     *
     * @param data 需要加密的内容
     * @param key  加密密码
     */
    public static String encrypt(String data, String key) {
        return doAES(data, key, Cipher.ENCRYPT_MODE);
    }

    /**
     * 解密
     *
     * @param data 待解密内容
     * @param key  解密密钥
     */
    public static String decrypt(String data, String key) {
        return doAES(data, key, Cipher.DECRYPT_MODE);
    }

    /**
     * 加解密
     *
     * @param data 待处理数据
     * @param mode 加解密mode
     */
    private static String doAES(String data, String key, int mode) {
        try {
            if (StringUtil.isBlank(data) || StringUtil.isBlank(key)) {
                return null;
            }
            // 判断是加密还是解密
            boolean encrypt = mode == Cipher.ENCRYPT_MODE;
            byte[] content;
            // true 加密内容 false 解密内容
            if (encrypt) {
                content = data.getBytes(defaultCharset);
            } else {
                content = BinUtil.parseHexStr2Byte(data);
            }
            // 1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_AES);
            // 2.初始化密钥生成器 生成一个128位的随机源,根据传入的字节数组
            keyGenerator.init(128, new SecureRandom(key.getBytes()));
            // 3.产生原始对称密钥
            SecretKey secretKey = keyGenerator.generateKey();
            // 4.获得原始对称密钥的字节数组
            byte[] enCodeFormat = secretKey.getEncoded();
            // 5.根据字节数组生成AES密钥
            SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, KEY_AES);
            // 6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance(KEY_AES);// 创建密码器
            // 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(mode, keySpec);// 初始化
            byte[] result = cipher.doFinal(content);
            if (encrypt) {
                // 将二进制转换成16进制
                return BinUtil.parseByte2HexStr(result);
            } else {
                return new String(result, defaultCharset);
            }
        } catch (Exception e) {
            logger.error("AES 密文处理异常", e);
        }
        return null;
    }
}