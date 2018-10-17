package com.viger.myplayer;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//测试类
public class Test01 {

    public void md5(String message) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.reset();
        digest.update(message.getBytes());
        byte[] bytes = digest.digest();

    }

    private void test() {

    }

}
