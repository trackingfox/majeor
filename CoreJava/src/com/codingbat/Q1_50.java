package com.codingbat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class Q1_50 {

	/*
	 * The parameter weekday is true if it is a weekday, and the parameter vacation
	 * is true if we are on vacation. We sleep in if it is not a weekday or we're on
	 * vacation. Return true if we sleep in.
	 * 
	 * 
	 * sleepIn(false, false) → true sleepIn(true, false) → false sleepIn(false,true)
	 * → true
	 */
	public boolean sleepIn(boolean weekday, boolean vacation) {

		if (!weekday || vacation)
			return true;
		else
			return false;
	}

	@Test
	public void sleepIntest() {
		Assert.assertEquals(sleepIn(true, false), false);
		Assert.assertEquals(sleepIn(false, false), true);
		Assert.assertEquals(sleepIn(true, true), true);
		Assert.assertEquals(sleepIn(false, true), true);
	}

	/*
	 * 
	 * We have two monkeys, a and b, and the parameters aSmile and bSmile indicate
	 * if each is smiling. We are in trouble if they are both smiling or if neither
	 * of them is smiling. Return true if we are in trouble.
	 * 
	 * 
	 * monkeyTrouble(true, true) → true monkeyTrouble(false, false) → true
	 * monkeyTrouble(true, false) → false
	 */
	public boolean monkeyTrouble1(boolean aSmile, boolean bSmile) {

		if (aSmile != true && bSmile != true) {
			return true;
		} else if (aSmile == true && bSmile == true) {
			return true;
		} else
			return false;

	}

	public boolean monkeyTrouble2(boolean aSmile, boolean bSmile) {

		if ((!aSmile && !bSmile) || (aSmile && bSmile)) {
			return true;
		} else
			return false;
	}

	public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {

		return (!aSmile && !bSmile) || (aSmile && bSmile) ? true : false;
	}

	@Test
	public void monkeyTroubleTest() {
		Assert.assertEquals(monkeyTrouble(true, false), false);
		Assert.assertEquals(monkeyTrouble(true, true), true);
		Assert.assertEquals(monkeyTrouble(false, false), true);
		Assert.assertEquals(monkeyTrouble(false, true), false);
	}

	/*
	 * 
	 * Given an int n, return true if it is within 10 of 100 or 200. Note:
	 * Math.abs(num) computes the absolute value of a number.
	 * 
	 * 
	 * nearHundred(93) → true nearHundred(90) → true nearHundred(89) → false
	 */

	public boolean nearHundred(int n) {
		return ((Math.abs(100 - n) <= 10) || (Math.abs(200 - n) <= 10));
	}

	// public boolean nearHundred(int n)

	@Test
	public void nearHundred() {
		Assert.assertEquals(nearHundred(93), true);
		Assert.assertEquals(nearHundred(193), true);
		Assert.assertEquals(nearHundred(193), true);
		Assert.assertEquals(nearHundred(183), false);

	}

	/*
	 * Given 2 int values, return true if one is negative and one is positive.
	 * Except if the parameter "negative" is true, then return true only if both are
	 * negative.
	 * 
	 * 
	 * posNeg(1, -1, false) → true posNeg(-1, 1, false) → true posNeg(-4, -5, true)
	 * → true
	 * 
	 */

	public boolean posNeg(int a, int b, boolean negative) {
		if (negative) {
			return (a < 0 && b < 0);
		} else {
			return ((a < 0 && b > 0) || (a > 0 && b < 0));
		}
	}

	@Test
	public void posNeg() {
		Assert.assertEquals(posNeg(1, -1, false), true);
		Assert.assertEquals(posNeg(-1, 1, false), true);
		Assert.assertEquals(posNeg(-4, -5, true), true);
		Assert.assertEquals(posNeg(1, -1, false), true);

	}

	/*
	 * Given a string, return a new string where "not " has been added to the front.
	 * However, if the string already begins with "not", return the string
	 * unchanged. Note: use .equals() to compare 2 strings.
	 * 
	 * 
	 * notString("candy") → "not candy" notString("x") → "not x"
	 * notString("not bad") → "not bad"
	 */

	public String notString(String str) {
		if (str.length() >= 3 && str.substring(0, 3).equals("not")) {
			return str;
		}

		return "not " + str;
	}

	@Test
	public void notString() {
		Assert.assertEquals(notString("candy"), "not candy");
		Assert.assertEquals(notString("x"), "not x");
		Assert.assertEquals(notString("not bad"), "not bad");
		Assert.assertEquals(notString("not bad"), "not bad");

	}

	/*
	 * Given a non-empty string and an int n, return a new string where the char at
	 * index n has been removed. The value of n will be a valid index of a char in
	 * the original string (i.e. n will be in the range 0..str.length()-1
	 * inclusive).
	 * 
	 * 
	 * missingChar("kitten", 1) → "ktten" missingChar("kitten", 0) → "itten"
	 * missingChar("kitten", 4) → "kittn"
	 * 
	 * 
	 */
	public String missingChar(String str, int n) {
		String front = str.substring(0, n);

		String rear = str.substring(n + 1, str.length());

		return front + rear;
	}

	@Test
	public void missingChar() {
		Assert.assertEquals(missingChar("kitten", 1), "ktten");
		Assert.assertEquals(missingChar("kitten", 0), "itten");
		Assert.assertEquals(missingChar("kitten", 4), "kittn");
		Assert.assertEquals(missingChar("kitten", 5), "kitte");

	}

	/*
	 * Given a string, return a new string where the first and last chars have been
	 * exchanged.
	 * 
	 * 
	 * frontBack("code") → "eodc" frontBack("a") → "a" frontBack("ab") → "ba"
	 */
	public String frontBack(String str) {
		if (str.length() <= 1)
			return str;

		String mid = str.substring(1, str.length() - 1);

		// last + mid + first
		return str.charAt(str.length() - 1) + mid + str.charAt(0);
	}

	@Test
	public void frontBack() {
		Assert.assertEquals(frontBack("code"), "eodc");
		Assert.assertEquals(frontBack("a"), "a");
		Assert.assertEquals(frontBack("ab"), "ba");
		Assert.assertEquals(frontBack("ab"), "ba");

	}

	/*
	 * Given a string, we'll say that the front is the first 3 chars of the string.
	 * If the string length is less than 3, the front is whatever is there. Return a
	 * new string which is 3 copies of the front.
	 * 
	 * 
	 * front3("Java") → "JavJavJav" front3("Chocolate") → "ChoChoCho" front3("abc")→
	 * "abcabcabc"
	 */

	public String front3(String str) {
		String front;

		if (str.length() >= 3) {
			front = str.substring(0, 3);
		} else {
			front = str;
		}

		return front + front + front;
	}

	@Test
	public void front3() {
		Assert.assertEquals(front3("Java"), "JavJavJav");
		Assert.assertEquals(front3("Chocolate"), "ChoChoCho");
		Assert.assertEquals(front3("abc"), "abcabcabc");
		Assert.assertEquals(front3("abc"), "abcabcabc");

	}

	/*
	 * Given a string, take the last char and return a new string with the last char
	 * added at the front and back, so "cat" yields "tcatt". The original string
	 * will be length 1 or more.
	 * 
	 * 
	 * backAround("cat") → "tcatt" backAround("Hello") → "oHelloo" backAround("a") →
	 * "aaa"
	 */

	public String backAround(String str) {
		// Get the last char
		String last = str.substring(str.length() - 1);
		return last + str + last;
	}

	@Test
	public void backAround() {
		Assert.assertEquals(backAround("cat"), "tcatt");
		Assert.assertEquals(backAround("Hello"), "oHello");
		Assert.assertEquals(backAround("a"), "aaa");

	}

	/*
	 * Return true if the given non-negative number is a multiple of 3 or a multiple
	 * of 5. Use the % "mod" operator -- see Introduction to Mod
	 * 
	 * 
	 * or35(3) → true or35(10) → true or35(8) → false
	 */
	public boolean or35(int n) {
		return (n % 3 == 0) || (n % 5 == 0);
	}

	@Test
	public void or35() {
		Assert.assertEquals(or35(3), true);
		Assert.assertEquals(or35(10), true);
		Assert.assertEquals(or35(8), false);

	}

	/*
	 * Given a string, take the first 2 chars and return the string with the 2 chars
	 * added at both the front and back, so "kitten" yields"kikittenki". If the
	 * string length is less than 2, use whatever chars are there.
	 * 
	 * 
	 * front22("kitten") → "kikittenki" front22("Ha") → "HaHaHa" front22("abc") →
	 * "ababcab"
	 */
	public String front22(String str) {
		// First figure the number of chars to take
		int take = 2;
		if (take > str.length()) {
			take = str.length();
		}

		String front = str.substring(0, take);
		return front + str + front;
	}

	/*
	 * Given a string, return true if the string starts with "hi" and false
	 * otherwise.
	 * 
	 * 
	 * startHi("hi there") → true startHi("hi") → true startHi("hello hi") → false
	 */
	public boolean startHi(String str) {
		// First test if the string is not at least length 2
		// (so the substring() below does not go past the end).
		if (str.length() < 2)
			return false;

		// Pull out the string of the first two chars
		String firstTwo = str.substring(0, 2);

		// Test if it is equal to "hi"
		if (firstTwo.equals("hi")) {
			return true;
		} else {
			return false;
		}
		// This last part can be shortened to: return(firstTwo.equals("hi"));
	}

	/*
	 * Given two temperatures, return true if one is less than 0 and the other is
	 * greater than 100.
	 * 
	 * 
	 * icyHot(120, -1) → true icyHot(-1, 120) → true icyHot(2, 120) → false
	 */

	public boolean icyHot(int temp1, int temp2) {
		if ((temp1 < 0 && temp2 > 100) || (temp1 > 100 && temp2 < 0)) {
			return true;
		} else {
			return false;
		}
		// Could be written as: return ((temp1 < 0 && ...));
	}

	/*
	 * Given 2 int values, return true if either of them is in the range 10..20
	 * inclusive.
	 * 
	 * 
	 * in1020(12, 99) → true in1020(21, 12) → true in1020(8, 99) → false
	 * 
	 */
	public boolean in1020(int a, int b) {
		return ((a >= 10 && a <= 20) || (b >= 10 && b <= 20));
	}

	/*
	 * We'll say that a number is "teen" if it is in the range 13..19 inclusive.
	 * Given 3 int values, return true if 1 or more of them are teen.
	 * 
	 * 
	 * hasTeen(13, 20, 10) → true hasTeen(20, 19, 10) → true hasTeen(20, 10, 13) →
	 * true
	 */

	public boolean hasTeen(int a, int b, int c) {
		// Here it is written as one big expression,
		// vs. a series of if-statements.
		return (a >= 13 && a <= 19) || (b >= 13 && b <= 19) || (c >= 13 && c <= 19);
	}

	/*
	 * Given a string, if the string "del" appears starting at index 1, return a
	 * string where that "del" has been deleted. Otherwise, return the string
	 * unchanged.
	 * 
	 * 
	 * delDel("adelbc") → "abc" delDel("adelHello") → "aHello" delDel("adedbc") →
	 * "adedbc"
	 */

	public String delDel(String str) {
		if (str.length() >= 4 && str.substring(1, 4).equals("del")) {

			return str.substring(0, 1) + str.substring(4);
		}

		return str;

	}

	/*
	 * Return true if the given string contains between 1 and 3 'e' chars.
	 * 
	 * 
	 * stringE("Hello") → true stringE("Heelle") → true stringE("Heelele") → false
	 */
	public boolean stringE(String str) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'e')
				count++;
			// alternately: str.substring(i, i+1).equals("e")
		}

		return (count >= 1 && count <= 3);
	}

	public boolean stringE1(String str) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i + 1).equals("e"))
				count++;
			// alternately: str.substring(i, i+1).equals("e")
		}

		return (count >= 1 && count <= 3);
	}

	/*
	 * Given a string, return a new string where the last 3 chars are now in upper
	 * case. If the string has less than 3 chars, uppercase whatever is there. Note
	 * that str.toUpperCase() returns the uppercase version of a string.
	 * 
	 * 
	 * endUp("Hello") → "HeLLO" endUp("hi there") → "hi thERE" endUp("hi") → "HI"
	 */

	public String endUp(String str) {
		if (str.length() <= 3)
			return str.toUpperCase();
		int cut = str.length() - 3;
		String front = str.substring(0, cut);
		String back = str.substring(cut); // this takes from cut to the end

		return front + back.toUpperCase();
	}

	/*
	 * Given a string, return true if the string starts with "hi" and false
	 * otherwise.
	 * 
	 * 
	 * startHi("hi there") → true startHi("hi") → true startHi("hello hi") → false
	 */

	public boolean startHello(String str) {
		// First test if the string is not at least length 2
		// (so the substring() below does not go past the end).
		if (str.length() < 2)
			return false;

		// Pull out the string of the first two chars
		String firstTwo = str.substring(0, 2);

		// Test if it is equal to "hi"
		if (firstTwo.equals("hi")) {
			return true;
		} else {
			return false;
		}
		// This last part can be shortened to: return(firstTwo.equals("hi"));
	}

	/*
	 * Given a string and a non-negative int n, we'll say that the front of the
	 * string is the first 3 chars, or whatever is there if the string is less than
	 * length 3. Return n copies of the front;
	 * 
	 * 
	 * frontTimes("Chocolate", 2) → "ChoCho" frontTimes("Chocolate", 3) →
	 * "ChoChoCho" frontTimes("Abc", 3) → "AbcAbcAbc"
	 * 
	 */
	
	

}
