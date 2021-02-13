package com.vcgdev.common.utils;

import java.util.Random;

public class CodeGenerator {
    
    private static final char[] CHARS = {'0','1', '2', '3', '4', '5', '6', '7', '8',  
        '9','A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',  
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    private static final Random random = new Random(); 

    private CodeGenerator() {

    }

    public static String generate(int length) {
        StringBuilder retStr = new StringBuilder();
        for (int i = 0; i < length; i++) { 
            retStr.append(CHARS[random.nextInt(CHARS.length)]);  
        }  
        return retStr.toString();
    }
}
