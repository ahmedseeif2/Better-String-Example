/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.betterstringlambda;

/**
 *
 * @author alamia
 */
public class MainClass {
    public static void main(String[] args){
        
       String string1 = "Ahmed  is tall";
       String string2 = "Ali is a short guy";
       String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
       String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);
       System.out.println(longer);
       System.out.println(first);
    }
    
}
