package com.viger.myplayer;

import java.io.File;
import java.io.FilenameFilter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

//测试类
public class Test01 {

    public void md5(String message) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.reset();
        digest.update(message.getBytes());
        byte[] bytes = digest.digest();

    }

    private void test() {
        File srcDir = new File("java");
        File[] list = srcDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isFile() && name.endsWith(".java");
            }
        });
        System.out.print(Arrays.toString(list));
        //


    }

}
