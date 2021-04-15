package com.javatribe.apicompetition.util;

import java.util.regex.Pattern;

public class MatcherRegexUtil {

    public static boolean standardSessionsNum(String theYear){
        Pattern pattern = Pattern.compile("^第.*?届$");
        return pattern.matcher(theYear).matches();
    }

}
