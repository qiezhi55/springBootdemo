package com.example.demo.interceptor;

/**
 * Created by lj on 2017/6/2.
 */

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class CSRFTokenUtil {

    public static String generate(HttpServletRequest request) {

        return UUID.randomUUID().toString();
    }

}