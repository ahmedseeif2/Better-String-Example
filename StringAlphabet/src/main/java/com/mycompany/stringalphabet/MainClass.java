/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stringalphabet;

/**
 *
 * @author alamia
 */
public class MainClass {
    


	// Function to check String for only Alphabets
	public static boolean isStringOnlyAlphabet(String str)
	{
		return ((str != null)
				&& (!str.equals(""))
				&& (str.chars().allMatch(Character::isLetter)));
	}

	
	public static void main(String[] args)
	{

		// Checking for True case
		System.out.println("Test Case 1:");

		String str1 = "AhlyforEgypt";
		System.out.println("Input: " + str1);
		System.out.println("Output: " + isStringOnlyAlphabet(str1));

		System.out.println("\nTest Case 2:");

		String str2 = "Ahly2Egypt";
		System.out.println("Input: " + str2);
		System.out.println("Output: " + isStringOnlyAlphabet(str2));

		System.out.println("\nTest Case 3:");

		String str3 = null;
		System.out.println("Input: " + str3);
		System.out.println("Output: " + isStringOnlyAlphabet(str3));

		System.out.println("\nTest Case 4:");

		String str4 = "";
		System.out.println("Input: " + str4);
		System.out.println("Output: " + isStringOnlyAlphabet(str4));
	}
}

    

