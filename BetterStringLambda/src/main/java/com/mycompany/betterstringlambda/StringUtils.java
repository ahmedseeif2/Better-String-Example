/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.betterstringlambda;

import java.util.function.BiPredicate;

/**
 *
 * @author alamia
 */
public class StringUtils {
    public static String betterString(String s1, String s2, BiPredicate<String, String> Bi) {
        if (Bi.test(s1, s2)) {
            return s1;
        }
            return s2;
    }
}
