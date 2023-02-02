package com.it.boot.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 对文件或文件夹进行压缩和解压
 */
public class ZipUtil {

    /**
     * 对目录srcFile下的所有文件目录进行先压缩后加密,然后保存为destfile
     *
     * @param srcFile  要操作的文件或文件夹
     * @param destfile 压缩加密后存放的文件
     * @param keyfile  密钥
     */
    public void encryptZip(String srcFile, String destfile, String keyStr) throws Exception {
        File temp = new File(UUID.randomUUID().toString() + ".zip");
        temp.deleteOnExit();
        // 先压缩文件
        new ZipUtil().zip(srcFile, temp.getAbsolutePath());
        // 对文件加密
        new CipherUtil().encrypt(temp.getAbsolutePath(), destfile, keyStr);
        temp.delete();
    }

    /**
     * 对文件srcfile进行先解密后解压缩,然后解压缩到目录destfile下
     *
     * @param srcfile   要解密和解压缩的文件名
     * @param destfile  解压缩后的目录
     * @param publicKey 密钥
     */
    public void decryptUnzip(String srcfile, String destfile, String keyStr) throws Exception {
        File temp = new File(UUID.randomUUID().toString() + ".zip");
        temp.deleteOnExit();
        // 先对文件解密
        new CipherUtil().decrypt(srcfile, temp.getAbsolutePath(), keyStr);
        // 解压缩
        new ZipUtil().unZip(temp.getAbsolutePath(), destfile);
        temp.delete();
    }

//	/** 得到当前系统的分隔符 */
//	private static String separator = System.getProperty("file.separator");

    /**
     * 添加到压缩文件中
     *
     * @param out
     * @param f
     * @param base
     * @throws Exception
     */
    private void directoryZip(ZipOutputStream out, File f, String base) throws Exception {
        // 如果传入的是目录
        if (f.isDirectory()) {
            File[] fl = f.listFiles();
            // 创建压缩的子目录
            out.putNextEntry(new ZipEntry(base + "/"));
            if (base.length() == 0) {
                base = "";
            } else {
                base = base + "/";
            }
            for (int i = 0; i < fl.length; i++) {
                directoryZip(out, fl[i], base + fl[i].getName());
            }
        } else {
            // 把压缩文件加入rar中
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            byte[] bb = new byte[10240];
            int aa = 0;
            while ((aa = in.read(bb)) != -1) {
                out.write(bb, 0, aa);
            }
            in.close();
        }
    }

    /**
     * 压缩文件
     *
     * @param zos
     * @param file
     * @throws Exception
     */
    private void fileZip(ZipOutputStream zos, File file) throws Exception {
        if (file.isFile()) {
            zos.putNextEntry(new ZipEntry(file.getName()));
            FileInputStream fis = new FileInputStream(file);
            byte[] bb = new byte[10240];
            int aa = 0;
            while ((aa = fis.read(bb)) != -1) {
                zos.write(bb, 0, aa);
            }
            fis.close();
            System.out.println(file.getName());
        } else {
            directoryZip(zos, file, "");
        }
    }

    /**
     * 解压缩文件
     *
     * @param zis
     * @param file
     * @throws Exception
     */
    private void fileUnZip(ZipInputStream zis, File file) throws Exception {
        ZipEntry zip = zis.getNextEntry();
        if (zip == null)
            return;
        String name = zip.getName();
        File f = new File(file.getAbsolutePath() + "/" + name);
        if (zip.isDirectory()) {
            f.mkdirs();
        } else {
            f.createNewFile();
            FileOutputStream fos = new FileOutputStream(f);
            byte b[] = new byte[10240];
            int aa = 0;
            while ((aa = zis.read(b)) != -1) {
                fos.write(b, 0, aa);
            }
            fos.close();
        }
        fileUnZip(zis, file);
    }

    /**
     * 根据filePath创建相应的目录
     *
     * @param filePath
     * @return
     * @throws IOException
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
     * 对zipBeforeFile目录下的文件压缩，保存为指定的文件zipAfterFile
     *
     * @param zipBeforeFile 压缩之前的文件
     * @param zipAfterFile  压缩之后的文件
     */
    public void zip(String zipBeforeFile, String zipAfterFile) {
        try {

            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(mkdirFiles(zipAfterFile)));
            fileZip(zos, new File(zipBeforeFile));
            zos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解压缩文件unZipBeforeFile保存在unZipAfterFile目录下
     *
     * @param unZipBeforeFile 解压之前的文件
     * @param unZipAfterFile  解压之后的文件
     */
    public void unZip(String unZipBeforeFile, String unZipAfterFile) {
        try {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(unZipBeforeFile));
            File f = new File(unZipAfterFile);
            f.mkdirs();
            fileUnZip(zis, f);
            zis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}