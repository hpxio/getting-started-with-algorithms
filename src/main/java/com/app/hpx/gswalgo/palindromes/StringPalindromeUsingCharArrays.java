package com.app.hpx.gswalgo.palindromes;

import java.util.Arrays;

/**
 * Palindrome (n) a word, phrase, or sequence that
 * reads the same backwards as forwards,
 * e.g. madam or nurses run.
 */
public class StringPalindromeUsingCharArrays {

    private static void isPalindrome(String input) {
        isPalindromeSolutionA(input);
        isPalindromeSolutionB(input);
    }

    public static void main(String[] args) {
        /* Getting input from commaind line */
        if (1 == args.length) {
            isPalindrome(args[0].trim());
        } else {
            String defaultTest = "yay";
            System.out.println("Using Default test : " + defaultTest);
            isPalindrome(defaultTest);
        }
    }

    /***
     * OPTION - 1 (worst)
     * Time-Complexity: O(n)
     * Space-Complexity: O(n)
     * 
     * Inputs: pass:"madam", pass:"nun", pass:"abcdcba", fail:"total"
     * edge-case:"nurses run", pass:"abccba", pass:"3339091909333"
     * 
     * @param s String to test
     */
    private static void isPalindromeSolutionA(String s) {
        int len = s.length();
        int ctr = len - 1;

        /* making checks case insensitive */
        char[] inArr = s.toLowerCase().toCharArray();
        char[] outArr = new char[len];

        for (int i = 0; i <= ctr; i++) {
            outArr[i] = inArr[ctr - i];
        }

        printArray(outArr);
        boolean result = Arrays.equals(inArr, outArr);

        System.out.printf("Result : %b for input : %s\n", result, s);
    }

    /**
     * OPTION - 2 (good)
     * Time-Complexity: O(n)
     * Space-Complexity: O(n)
     * 
     * Inputs: pass:"madam", pass:"nun", pass:"abcdcba", fail:"total"
     * edge-case:"nurses run", pass:"abccba", pass:"333 9091 90933 3"
     * 
     * @param s String to test
     */
    private static void isPalindromeSolutionB(String s) {

        String orig = s;

        /* remove white-spces to check palindrome in sentences/phrases */
        s = s.replace(" ", "");

        boolean result = true;
        int len = s.length() - 1;

        int left = 0;
        int right = len;

        char[] inArr = s.toLowerCase().toCharArray();

        while (left < right) {
            if (inArr[left++] != inArr[right--]) {
                result = false;
            }
        }

        printArray(inArr);
        System.out.printf("Result : %b for input : %s\n", result, orig);
    }

    private static void printArray(char[] a) {
        for (char c : a) {
            System.out.print(c);
        }
        System.out.println();
    }
}
