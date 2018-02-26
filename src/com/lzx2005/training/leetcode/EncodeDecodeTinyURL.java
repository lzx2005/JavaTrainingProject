package com.lzx2005.training.leetcode;

import java.util.HashMap;

/**
 * Created by Lizhengxian on 2018/2/24.
 */
public class EncodeDecodeTinyURL {

    private static HashMap<String,String> map = new HashMap();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        Long currentTimeMillis = System.currentTimeMillis();
        map.put(String.valueOf(currentTimeMillis),longUrl);
        return "http://tinyurl.com/"+currentTimeMillis;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String substring = shortUrl.substring(19, shortUrl.length());
        return map.get(substring);
    }

    public static void main(String[] args) {

        EncodeDecodeTinyURL encodeDecodeTinyURL = new EncodeDecodeTinyURL();

        String encode = encodeDecodeTinyURL.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(encode);
        String decode = encodeDecodeTinyURL.decode(encode);
        System.out.println(decode);
    }
}
