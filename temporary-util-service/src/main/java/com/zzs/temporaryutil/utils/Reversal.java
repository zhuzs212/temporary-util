package com.zzs.temporaryutil.utils;

public class Reversal {
    public static void main(String[] args) {
        String str = "Hello World";
        String reversal = reversal1(str);
        System.out.println(reversal);


        str = "Hello";
        reversal = reversal2(str);
        System.out.println(reversal);
    }

    public static String reversal1(String str){
        StringBuffer buffer = new StringBuffer(str);
        String reverseStr = buffer.reverse().toString();
        return reverseStr;
    }

    public static String reversal2(String str){
        return str.chars().mapToObj(c->(char)c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
    }
}
