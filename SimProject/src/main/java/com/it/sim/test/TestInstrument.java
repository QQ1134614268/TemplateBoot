package com.it.sim.test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.security.ProtectionDomain;

/**
 * todo instrument 包
 * 使用 Instrumentation，使得开发者可以构建一个独立于应用程序的代理程序（Agent），用来监测和协助运行在 JVM 上的程序，甚至能够替换和修改某些类的定义。
 * 有了这样的功能，开发者就可以实现更为灵活的运行时虚拟机监控和 Java 类操作了，
 * 这样的特性实际上提供了 一种虚拟机级别支持的 AOP 实现方式，
 *      使得开发者无需对 JDK 做任何升级和改动，就可以实现某些 AOP 的功能了。
 *      如果我们想要无侵入式的修改一个方法，大多数人想到的可能是 AOP 技术，
 *      Instrument 有异曲同工之处，它可以对方法进行增强，甚至替换整个类。
 */
public class TestInstrument {
    @Test
    public void testBreak() {

    }
}

class TransClass {
    public int getNumber() {
        return 1;
    }
}

class TransFromMain {
    public static void main(String[] args) {
        TransClass transClass = new TransClass();
        transClass.getNumber();
    }
}

class ArgentMain {
    public static void premain(String agentArgs, Instrumentation inst) throws ClassNotFoundException, UnmodifiableClassException, InterruptedException {
        //  ClassDefinition def = new ClassDefinition(com.sean.source.TransClass.class,new Transformer().getBytesFromFile(Transformer.TRANSFORM_CLASS_NAME));
        //        inst.redefineClasses(new ClassDefinition[] { def });
        //        System.out.println("success");
        inst.addTransformer(new Transformer());
        //  inst.retransformClasses(com.sean.source.TransClass.class);
    }
}


class AgentMain {
    public static void premain(String agentArgs, Instrumentation inst) throws ClassNotFoundException, UnmodifiableClassException, InterruptedException {
        inst.addTransformer(new Transformer());
        //  inst.retransformClasses(com.sean.source.TransClass.class);
    }
}


class Transformer implements ClassFileTransformer {
    public static final String TRANSFORM_CLASS_NAME = "com/sean/source/TransClass.class";

    public byte[] getBytesFromFile(String fileName) {
        System.out.println("className:" + fileName);
        try {
            // precondition

            File file = new File(fileName);
            InputStream is = new FileInputStream(file);
            long length = file.length();
            byte[] bytes = new byte[(int) length];
            // Read in the bytes
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }

            if (offset < bytes.length) {
                throw new IOException("Could not completely read file " + fileName);
            }
            is.close();
            return bytes;
        } catch (Exception e) {
            System.out.println("error occurs in _ClassTransformer!" + e.getClass().getName());
            return null;
        }
    }


    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (className.contains("com/sean/source/TransClass")) {
            return getBytesFromFile(TRANSFORM_CLASS_NAME);
        }
        return null;
    }

    public static void main(String[] args) {
        Transformer t = new Transformer();
        byte[] classfileBuffer = t.getBytesFromFile(TRANSFORM_CLASS_NAME);
    }
}