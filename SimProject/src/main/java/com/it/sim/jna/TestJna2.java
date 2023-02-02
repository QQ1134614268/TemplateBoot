package com.it.sim.jna;

import com.sun.jna.*;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import java.util.Arrays;
import java.util.List;

public class TestJna2 {
    // jna复杂对象映射
    public interface CLibrary extends Library {
        CLibrary INSTANCE = Native.load(Platform.isWindows() ? "D:\\test.dll" : "/root/test.so", CLibrary.class);

        // int function1(int aa, float b, long c)
        int function(int aa, float b, long c);

        // void function1(char * data, const unsigned char* data2)
        void function(char[] data, char[] data2); // 或者 void function1(byte[] data, byte[] data2)

        // long function(int * a, float * b)
        void function(IntByReference aRef, FloatByReference bRef);

        // void function(int * pInt, int ** ppInt, void pVoid, void ** ppVoid)
        void function(IntByReference pInt, PointerByReference ppInt, Pointer pVoid, PointerByReference ppVoid);

        // 结构体, 输入 输出


        // @Structure.FieldOrder("aInt,aRef,data,ppInt")
        class TestStructure extends Structure {
            public int aInt;
            public IntByReference aRef;
            public byte[] data;
            public PointerByReference ppInt;
            @Override
            protected List<String> getFieldOrder() {
                return Arrays.asList("aInt","aRef","data","ppInt");
            }
        }
        void function(TestStructure structure);

    }

    public static void main(String[] args) {

        int r = CLibrary.INSTANCE.function(1, 1f, 1L);
        System.out.println(r);

        CLibrary.INSTANCE.function(new char[1], new char[2]);

        //new IntByReference(); //构建对象 使用默认初始值（具体多少我也不知道）
        CLibrary.INSTANCE.function(new IntByReference(), new FloatByReference());

        CLibrary.INSTANCE.function(new IntByReference(), new FloatByReference());

        // IntByReference pInt = new IntByReference(0);
        // PointerByReference ppInt = new PointerByReference(Pointer.NULL); //指向指针的指针，初始化为NULL
        // Pointer pVoid = Pointer.NULL; //创建一个指向NULL的指针
        // PointerByReference ppVoid = new PointerByReference(Pointer.NULL);
        CLibrary.INSTANCE.function(new IntByReference(), new PointerByReference(Pointer.NULL), Pointer.NULL, new PointerByReference(Pointer.NULL));
        // 调用：function(pInt, ppInt, pVoid, ppVoid);
        // （1）PointerByReference是指向指针的指针，遇到指针的指针都可以使用它来模拟，那么如何获取到它指向的指针呢？
        //      Pointer p = ppVoid.getValue(); //获取指针
        // （2）如何获取指针的指针呢？
        //      Pointer p1 = ….;
        //      PointerByReference pp1 = new PointerByReference(p1);
        //      PointerByReference ppp1 = new PointerByReference(pp1.getPointer());

    }
}