/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner userInput = new Scanner(System.in);
		System.out.println("please enter your math equation");
		String input = userInput.nextLine();
		System.out.println(produceAnswer(input));
		boolean jump = false;
		while (!jump) {
			System.out.println("please enter your math equation");
			String input1 = userInput.nextLine();
			jump = input1.equals("quit");
			if (!jump)
				System.out.println(produceAnswer(input1));

		}
		userInput.close();

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		int spacePos = input.indexOf(" ");
		String num1 = input.substring(0, spacePos);
		String num2 = input.substring(spacePos + 3, input.length());
		
		String whole = "";
		String numerator = "";
		String denominator = "";
		
		int underscorePos = num2.indexOf("_");
		int dividePos = num2.indexOf("/");
		whole = num2.substring(0, underscorePos);
		numerator = num2.substring(underscorePos + 1, dividePos);
		denominator = num2.substring(dividePos + 1, num2.length());
		
		
		String result = "whole" + whole + " numeartor" + numerator + " denominator" + denominator;
		return result;
	}
//	public static String produceAnswer(String input1) {
//		int num = input1.indexOf(" ");
//		String fraction1 = input1.substring(0, num);
//		String fraction2 = input1.substring(num + 3, input1.length());
//		int num1 = input1.length();
//
//		String operator = input1.substring(num + 1, num + 2);
//		int sign = input1.indexOf('_');
//		int sign1 = input1.indexOf('/');
//		if (sign != -1) {
//			String whole = input1.substring(num + 3, sign);
//			String numerator = input1.substring(sign, sign1);
//			String denominator = input1.substring(sign1, num1);
//
//		}
//		if (sign == -1 && sign1 == -1) {
//			/*
//			 * String whole = input1.substring(num1, sign); int numerator = 1; int
//			 * denominator = 0;
//			 */
//			System.out.println(fraction1);
//			System.out.println(fraction2);
//
//		}
//		if (sign1 > -1) {
//			int whole = 0;
//			String denominator = input1.substring(sign1, num1);
//			String numerator = input1.substring(num1, sign1);
//
//		}
//		//System.out.println("whole", whole, " numerator:" + numerator + "denominator:" + denominator);
//
//		// return (input1.substring(num + 3, input1.length()));
//		// TODO: Implement this function to produce the solution to the input
//
//		 return "denominator: " + denominator;
//	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
