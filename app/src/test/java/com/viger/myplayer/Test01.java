package com.viger.myplayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 测试类test
 */

public class Test01 {

    public void md5(String message) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.reset();
        digest.update(message.getBytes());
        byte[] bytes = digest.digest();
    }

    private void test() throws IOException {
        File srcDir = new File("java");
        File destDir = new File("text");
        File[] list = srcDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isFile() && name.endsWith(".java");
            }
        });
        System.out.print(Arrays.toString(list));
        //
        for(File file : list) {
            FileInputStream input = new FileInputStream(file);
            OutputStream out = new FileOutputStream(new File(destDir, file.getName()));
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length=input.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
            out.close();
            input.close();
        }
    }

    //获取传递的泛型类型
    public Class getBaseProtocol() {
        Class c = this.getClass();
        Type type = c.getGenericSuperclass();
        ParameterizedType ptype = (ParameterizedType)type;
        Type[] types = ptype.getActualTypeArguments();
        Class clazz  = (Class) types[0];
        return clazz;
    }

    public void test001() {
        System.out.print("this is a test function");
    }

    //okhttp3
    public void okHttp() throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().
                readTimeout(5, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url("").get().build();
        Call call = client.newCall(request);
        Response response = call.execute();
        response.body().string();
    }

}