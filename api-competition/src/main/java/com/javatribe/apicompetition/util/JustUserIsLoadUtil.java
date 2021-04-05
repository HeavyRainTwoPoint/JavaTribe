package com.javatribe.apicompetition.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class JustUserIsLoadUtil {

    public static boolean userIsLoad(HttpServletRequest request){
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)){
            return false;
        }else {
            return true;
        }
    }

}
