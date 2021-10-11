package cn.moquan.util;

import org.junit.Test;

public class FuzzyMatchUtil {
    
    public static String fuzzyString(String targetString){
        
        StringBuilder result = new StringBuilder("%");

        for (int i = 0; i < targetString.length(); i++) {
            result.append(targetString.charAt(i));
            result.append("%");
        }

        return result.toString();
    }

}
