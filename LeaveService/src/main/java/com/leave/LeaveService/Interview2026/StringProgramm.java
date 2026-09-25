package com.leave.LeaveService.Interview2026;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringProgramm {

    public static void reverseString1(String str)
    {
        String rev=IntStream.range(0,str.length()).mapToObj(i->str.charAt(str.length()-1-i)).map(String::valueOf).collect(Collectors.joining());
        System.out.println("Reverse: "+rev);
    }

    public static void reverseString2(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());
    }

    public static void checkPendrom(String str)
    {
       boolean true1= IntStream.range(0,str.length()).allMatch(i->str.charAt(i)==str.charAt(str.length()-1-i));
        System.out.println("true:"+true);
       if(true1)
       {
           System.out.println("Pailendrom");
       }else
       {
           System.out.println("Not pailendrom");
       }
        System.out.println("Camcer [");

    }

    public static void longestSubString()
    {
        String str="aabbcdeeff";
        String longest="T";
        String tmp="";
        int start=0;
        Set<Character> charSet = new HashSet<>();
        for(int i=0;i<=str.length()-1;i++)
        {
            while(charSet.contains(str.charAt(i)))
            {
                charSet.remove(str.charAt(i));
                tmp=tmp+str.substring(start,i);
                start++;
                if(tmp.length()>longest.length())
                {
                    longest=tmp;
                }
            }
            charSet.add(str.charAt(i));
        }
        System.out.println(longest);
    }

    

    public static void main(String[] args) {
        String str="Hello";
        reverseString1(str);
        reverseString2(str);
        checkPendrom("madam");
        longestSubString();

    }
}
