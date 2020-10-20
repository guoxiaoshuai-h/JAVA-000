package com.jvm.learn;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Author xiaoshuai.guo
 * @Date 2020-10-19 10:39
 */
public class HelloClassLoader extends ClassLoader {

    private byte[] findClassByte(String path) {
        byte[] bytes = null;
        FileInputStream in = null;
        try {
            in = new FileInputStream(new File(path));
            bytes = new byte[in.available()];
            in.read(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return transfromBytes(bytes);
    }

    private byte[] transfromBytes(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return bytes;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = findClassByte("src/main/Hello.xlass");
        return defineClass(name,bytes,0,bytes.length);
    }

    public static void main(String[] args) {
        try {
            Class<?> helloClass = new HelloClassLoader().findClass("Hello");
            Method hello = helloClass.getDeclaredMethod("hello");
            hello.invoke(helloClass.newInstance());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
