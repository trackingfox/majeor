package Hacker_rank;

/**
 * 
 * 
 * 
 */


import java.util.Scanner;

public class PalindromeIndex {

	static int palindromeIndex(String s) {
		int palindromeIndex = -1;
		int len = s.length();

		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - i - 1)) {

				if (i + 1 < len) {
					boolean isRightStringValidPalindrome = isValidPalindrome(s.substring(i + 1, len - i));
					if (isRightStringValidPalindrome)
						return i;
					return len - i - 1;
				}

			}
		}

		return palindromeIndex;

	}

	public static boolean isValidPalindrome(String str) {
		int len = str.length();

		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1)) {
				return false;
			}
		}

		return true;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			String s = in.next();
			int result = palindromeIndex(s);
			System.out.println(result);

		}
		in.close();
	}

}