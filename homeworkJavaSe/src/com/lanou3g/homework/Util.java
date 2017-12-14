package com.lanou3g.homework;

import net.sf.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class Util {
    public static void weatherUtil(String city) throws IOException {
        URL url = new URL("http://api.map.baidu.com/telematics/v3/weather?location="+ city + "&output=json&ak=6tYzTvGZSOpYB5Oc2YGGOKt8");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] buff = new byte[1024 * 8];
        StringBuffer buffer = new StringBuffer();
        int len = 0;
        while ((len = inputStream.read(buff)) != -1) {
            buffer.append(new String(buff, 0, len));
        }
        JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
        Weather weather = (Weather)JSONObject.toBean(jsonObject, Weather.class);
        System.out.println(weather.getResults());
        inputStream.close();
    }

    public static void phoneNoUtil(String phoneNumber) throws IOException {
        URL url = new URL("http://api.k780.com/?app=phone.get&phone=" + phoneNumber + "&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] buff = new byte[1024*8];
        StringBuffer buffer = new StringBuffer();
        int len = 0;
        while ((len = inputStream.read(buff)) != -1) {
            buffer.append(new String(buff, 0, len));
        }
        JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
        PhoneNo phoneNo = (PhoneNo) JSONObject.toBean(jsonObject,PhoneNo.class);
        System.out.println(phoneNo.getResult());
        inputStream.close();
    }
}

