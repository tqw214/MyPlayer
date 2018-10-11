package com.viger.myplayer;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test01 {

    public void md5(String message) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.reset();
        digest.update(message.getBytes());
        byte[] bytes = digest.digest();

    }

}
