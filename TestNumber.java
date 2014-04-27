package com.alibaba.china.gene.dal.spu.dao.impl;

public class TestNumber {
    
    private static final int C0 = '0';
    private static final int C9 = '9';
    private static final int CD = '.';
    private static final int CP = '+';
    private static final int CM = '-';
    private static final int CS = ' ';
    
    public static void main(String[] args) {
        try {
            String i="-1111199999222222222";
            String j="-1111199999222222222";
            
            System.out.println(isValidInteger(i));
            System.out.println(isValidIntegerNew(j));
            
        }  catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private static boolean isValidInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private static boolean isValidIntegerNew(String value) {
        final int l = value.length();
        if(l > 0) {
            int i = 1, c = value.charAt(0);
            if(c == CP || c == CM || (c >= C0 && c <= C9)) {
                for (; i < l; i++) {
                    c = value.charAt(i);
                    if (c < C0 || c > C9)
                        return false;
                }
                return true;
            }
        }
        return false;
    }
}
