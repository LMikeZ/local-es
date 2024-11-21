package com.example.lizan.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
public class URLEscapeUtils {
    public static String escape(String url) {
        try {
            return URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return url;
        }
    }
    public static String unescape(String url) {
        try {
            return URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return url;
        }
    }

    public static void main(String[] args) {
        String str = "http://10.17.3.99:8080/Thingworx/Things/TS.ELEC.PepolyMain1035.RT/Properties/%2A?Accept=application%2Fjson&Content-Type=application%2Fjson";
        System.out.println(unescape(str));
        String str2 = "http://10.17.3.99:8080/Thingworx/Things/TS.ELEC.PepolyMain1035.RT/Properties/*?Accept=application/json&Content-Type=application/json";
        System.out.println(escape(str2));

    }
}
