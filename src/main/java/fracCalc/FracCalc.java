/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		boolean jump = false;
		while (!jump) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("please enter your math equation");
			String input = userInput.nextLine();
			
			System.out.println(produceAnswer(input));

			if (input.indexOf("quit") != -1) {
				jump = true;
				userInput.close();

		}
		
		}
	}

	public static String produceAnswer(String input) {
		int spacePos = input.indexOf(" ");
		String num1 = input.substring(0, spacePos);
		String num2 = input.substring(spacePos + 2, input.length());
		String dividing=input.substring(spacePos, spacePos+2);
		String operator = input.substring(spacePos, spacePos + 2);
		String whole2 = "";
		String numerator2 = "";
		String denominator2 = "";
		String whole1 = "";
		String numerator1 = "";
		String denominator1 = "";
		double answer = 0;
		double new_numerator2=0;
		double new_numerator1 = 0;
		double finalnumerator1=0;
		double finalnumerator2=0;
		String ans1="";
		double new_deminator=0;
		String op="";
		int wnum =0;

		int underscorePos = num2.indexOf("_");
		int dividePos = num2.indexOf("/");
		// both friction and whole number
		if (underscorePos > -1 && dividePos > -1) {
			whole2 = num2.substring(0, underscorePos);
			numerator2 = num2.substring(underscorePos + 1, dividePos);
			denominator2 = num2.substring(dividePos + 1, num2.length());
		}
		// only friction
		if (underscorePos == -1 && dividePos > -1) {
			whole2 = "0";
			numerator2 = num2.substring(dividePos - 1, dividePos);
			denominator2 = num2.substring(dividePos + 1, num2.length());
		}
		// only whole number
		if (underscorePos <= -1 && dividePos <= -1) {
			whole2 = num2.substring(0, num2.length());
			numerator2 = "0";
			denominator2 = "1";
		}
		// part 1
		int underscorePos1 = num1.indexOf("_");
		int dividePos1 = num1.indexOf("/");
		// both friction and whole number
		if (underscorePos1 > -1 && dividePos1 > -1) {
			whole1 = num2.substring(0, underscorePos);
			numerator1 = num2.substring(underscorePos1 + 1, dividePos1);
			denominator1 = num2.substring(dividePos1 + 1, num1.length());
		}
		// only friction
		if (underscorePos1 == -1 && dividePos1 > -1) {
			whole1 = "0";
			numerator1 = num1.substring(dividePos1 - 1, dividePos1);
			denominator1 = num1.substring(dividePos1 + 1, num1.length());
		}
		// only whole number
		if (underscorePos1 <= -1 && dividePos1 <= -1) {
			whole1 = num1.substring(0, num1.length());
			numerator1 = "0";
			denominator1 = "1";
		}
		double whole2_double = Double.parseDouble(whole2);
		double numerator2_double = Double.parseDouble(numerator2);
		double denominator2_double = Double.parseDouble(denominator2);
		double whole1_double = Double.parseDouble(whole1);
		double numerator1_double = Double.parseDouble(numerator1);
		double denominator1_double = Double.parseDouble(denominator1);
		// convert int number into double
		// convert dividePos into Strin
		 
		
		if (input.indexOf("+") !=-1) {
			
		    if (underscorePos1 ==-1 && dividePos1 ==-1 && underscorePos ==-1 && dividePos ==-1) {
				
				answer = whole2_double + whole1_double;
				ans1= answer+"";
			 }
		    else {
				 new_deminator = denominator2_double * denominator1_double;
				
				
				finalnumerator1= numerator1_double*denominator2_double;
			
				finalnumerator2=denominator1_double*numerator2_double;
				answer = finalnumerator1 + finalnumerator2;
				ans1 = answer+"/"+new_deminator;
				
				
			 }
		}
	     if (input.indexOf("-") !=-1) {
			
			if (underscorePos1 ==-1 && dividePos1 ==-1 && underscorePos ==-1 && dividePos ==-1) {
				
				if (whole2_double > whole1_double){
					
					answer = whole2_double - whole1_double;
					ans1= "-" + answer+"";
				}
				else {
				answer = whole1_double - whole2_double;
				ans1="" + answer;
					
				}
			}
			else {
				   new_deminator = denominator2_double * denominator1_double;
					
					
					finalnumerator1= numerator1_double*denominator2_double;
				
					finalnumerator2=denominator1_double*numerator2_double;
					answer = finalnumerator1 - finalnumerator2;
					ans1 = answer+"/"+new_deminator;
			}
	     }
	     
		if (input.indexOf("*") !=-1) {	
			if (underscorePos1 ==-1 && dividePos1 ==-1 && underscorePos ==-1 && dividePos ==-1) {
				
				answer = whole2_double * whole1_double;
				ans1= answer+"";
			 }
		    else {
				 new_deminator = denominator2_double * denominator1_double;
				
				
				finalnumerator1= numerator1_double*numerator2_double;
				answer = finalnumerator1;
				ans1 = answer+"/"+new_deminator;
			 }
		}
		//the / can always be found, change input
		if (dividing.indexOf("/") !=-1) {
			if (underscorePos1 ==-1 && dividePos1 ==-1 && underscorePos ==-1 && dividePos ==-1) {
				
				answer = whole2_double / whole1_double;
				ans1= answer+"";
			 }
		    else {
				 new_deminator = denominator2_double * numerator2_double;
				
				
				finalnumerator1= numerator1_double*denominator1_double;
				answer = finalnumerator1;
				for(int i=0; i< new_deminator; i++)
					if (i % answer==0){
						wnum +=1; 
						new_deminator -=answer;
						
					}
				if (wnum!=0) {
					ans1 = wnum+ "_"+new_deminator+"/"+answer;
				}
				else {
				   ans1 = new_deminator+"/"+answer;	
				}
				
			 }
		}
	    //return ans1;

	
	
	
		return ans1;
}
}