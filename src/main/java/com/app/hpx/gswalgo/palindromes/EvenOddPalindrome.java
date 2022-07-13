package com.app.hpx.gswalgo.palindromes;

import java.util.Arrays;

/**
 * Q: Check if a given string is Even-Odd Palindrome or not. (GFG)
 * An Even-Odd Palindrome string is defined to be a string whose
 * characters at even indices form a Palindrome while the characters
 * at odd indices also form a Palindrome separately.
 * 
 * Example:
 * Input: str=”abzzab”
 * Output:YES
 * Explanation:
 * String formed by characters at odd indices: bzb, which is a Palindrome.
 * String formed by characters at even indices: aza, which is a Palindrome.
 */
public class EvenOddPalindrome {
    public static void main(String[] args) {
        /* Getting input from commaind line */
        if (1 == args.length) {
            isPalindrome(args[0]);
        } else {
            String defaultTest = "abzzba";
            System.out.println("Using Default test : " + defaultTest);
            isPalindrome(defaultTest);
        }
    }

    private static void isPalindrome(String input) {
        isPalindromeSolutionA(input);
    }

    /**
     * OPTION - A (worst)
     * Time-Complexity: O(n) [ 3n + 3n + n = 7n => n ]
     * Space-Complexity: O(n) [ 3n + 3n + n = 7n => n ]
     * 
     * Inputs: pass:abzzba, fail:lol
     * 
     * @param input String to test
     */
    private static void isPalindromeSolutionA(String input) {
        String s = input.trim().replace(" ", "");
        char[] inArr = s.toLowerCase().toCharArray();

        int ctr = 0;
        int len = s.length();
        int evenCtr = 1; // index-positioned
        int oddCtr = 0; // index-positioned

        char[] evenArr = new char[len / 2];
        char[] oddArr = new char[len / 2];

        for (int i = evenCtr; i < len; i += 2) {
            evenArr[ctr++] = inArr[i];
        }

        ctr = 0;

        for (int i = oddCtr; i < len; i += 2) {
            oddArr[ctr++] = inArr[i];
        }

        System.out.print("Even Array -> ");
        printArray(evenArr);

        System.out.print("Odd Array -> ");
        printArray(oddArr);

        isPalindromeSolution(evenArr);
        isPalindromeSolution(oddArr);
    }

    private static void isPalindromeSolution(char[] s) {
        boolean result = true;
        int len = s.length - 1;

        int left = 0;
        int right = len;

        while (left < right) {
            if (s[left++] != s[right--]) {
                result = false;
            }
        }

        System.out.printf("Result : %b for input : %s\n", result, Arrays.toString(s));
    }

    private static void printArray(char[] a) {
        for (char c : a) {
            System.out.print(c);
        }
        System.out.println();
    }
}
