/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

public static void main(String[] args) {
Scanner userInput = new Scanner(System.in);
String in = userInput.nextLine();
String str = produceAnswer(in);
//getting the input 
boolean chioce = false;
while (!chioce) {
String x = userInput.nextLine();
str = produceAnswer(x);
System.out.println(str);
if (x.indexOf("quit") != -1) {
	chioce = true;
userInput.close();
}
}
// TODO: Read the input from the user and call produceAnswer with an equation

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

public static String produceAnswera(String input) {


int space = input.indexOf(" ");
String str = "";
String dtr = "";
if (Character.isWhitespace(input.charAt(space + 2))) {
String operator = input.substring(space + 1, space + 2);
str = (input.substring(space + 3));
if (str.indexOf("/") != -1) {
int frac = str.indexOf("/");
// String operator = i.substring(space+1, space + 2);
dtr = (input.substring(0, space));
if (dtr.indexOf("_") != -1) {
int dashx = dtr.indexOf("_");
String wholeNumberx = dtr.substring(0, dashx);
String numx = dtr.substring(dashx + 1, frac);
String denomx = dtr.substring(frac + 1);
double wholex = Double.parseDouble(wholeNumberx);
double numeratorx = Double.parseDouble(numx);
double denominatorx = Double.parseDouble(denomx);
double firstFraction = (wholex * denominatorx + numeratorx) / denominatorx;
if (str.indexOf("_") != -1) {
int dash = str.indexOf("_");
String wholeNumber = str.substring(0, dash);
String num = str.substring(dash + 1, frac);
String denom = str.substring(frac + 1);
double whole = Double.parseDouble(wholeNumber);
double numerator = Double.parseDouble(num);
double denominator = Double.parseDouble(denom);
double secondFraction = (whole * denominator + numerator) / denominator;



}


} 
}

// "1/2 + 3/4"

// TODO: Implement this function to produce the solution to the input
}
return str;

}

public static String produceAnswer(String in) {

String firstn;
String secondn;
String result;

if (in.indexOf('*') != -1) {
// if it is multiply
firstn = in.substring(0, in.indexOf('*'));
secondn = in.substring(in.indexOf('*') + 1);
firstn = Frac2(firstn);
secondn = Frac2(secondn);

String firstNum = firstn.substring(0, firstn.indexOf('/'));
String firstDenom = firstn.substring(firstn.indexOf('/') + 1);

String secondNum = secondn.substring(0, secondn.indexOf('/'));
String secondDenom = secondn.substring(secondn.indexOf('/') + 1);
result = "" + Integer.parseInt(firstNum) * Integer.parseInt(secondNum) + '/'
+ Integer.parseInt(firstDenom) * Integer.parseInt(secondDenom);
} else if (in.indexOf('+') != -1) {
// if it is addition
firstn = in.substring(0, in.indexOf('+'));
secondn = in.substring(in.indexOf('+') + 1);
firstn = Frac2(firstn);
secondn = Frac2(secondn);
String firstNum = firstn.substring(0, firstn.indexOf('/'));
String firstDenom = firstn.substring(firstn.indexOf('/') + 1);

String secondNum = secondn.substring(0, secondn.indexOf('/'));
String secondDenom = secondn.substring(secondn.indexOf('/') + 1);
result = ""
+ (Integer.parseInt(firstNum) * Integer.parseInt(secondDenom)
+ Integer.parseInt(secondNum) * Integer.parseInt(firstDenom))
+ '/' + Integer.parseInt(firstDenom) * Integer.parseInt(secondDenom);
} else if (in.indexOf(" / ") != -1) {
// purely division
firstn = in.substring(0, in.indexOf(" / "));
secondn = in.substring(in.indexOf(" / ") + 2);
firstn = Frac2(firstn);
secondn = Frac2(secondn);

String firstNum = firstn.substring(0, firstn.indexOf('/'));
String firstDenom = firstn.substring(firstn.indexOf('/') + 1);

String secondNum = secondn.substring(0, secondn.indexOf('/'));
String secondDenom = secondn.substring(secondn.indexOf('/') + 1);
result = "" + Integer.parseInt(firstNum) * Integer.parseInt(secondDenom) + '/'
+ Integer.parseInt(firstDenom) * Integer.parseInt(secondNum);
} else if (in.substring(1).indexOf('-') != -1) {
// subtraction
firstn = in.substring(0, in.substring(1).indexOf('-') + 1);
secondn = in.substring(in.substring(1).indexOf('-') + 2);
firstn = Frac2(firstn);
secondn = Frac2(secondn);
String firstNum = firstn.substring(0, firstn.indexOf('/'));
String firstDenom = firstn.substring(firstn.indexOf('/') + 1);

String secondNum = secondn.substring(0, secondn.indexOf('/'));
String secondDenom = secondn.substring(secondn.indexOf('/') + 1);
result = ""
+ (Integer.parseInt(firstNum) * Integer.parseInt(secondDenom)
- Integer.parseInt(secondNum) * Integer.parseInt(firstDenom))
+ '/' + Integer.parseInt(firstDenom) * Integer.parseInt(secondDenom);
} else {
result = "null";
}

result = Frac1(result);
return result;
}

public static String Frac2(String in) {
in = in.replaceAll(" ", "");
if (in.indexOf('/') == -1)
return in + "/1";
else if (in.indexOf('_') == -1)
return in;
else {
boolean Negative = false;
if (in.charAt(0) == '-') {
Negative = true;
in = in.substring(1);
}
int fst = in.indexOf('_');
int scd = in.indexOf('/');
int whole = Integer.parseInt(in.substring(0, fst));
int num = Integer.parseInt(in.substring(fst + 1, scd));
int dnm = Integer.parseInt(in.substring(scd + 1));
String result = whole * dnm + num + "/" + dnm;
if (Negative) {
result = "-" + result;
}
return result;
}
}

public static String simplify(String in) {
int ind = in.indexOf('/');
int num = Integer.parseInt(in.substring(0, ind));
int dnm = Integer.parseInt(in.substring(ind + 1));
for (int i = 2; i < dnm; i++) {
if (num % i == 0 && dnm % i == 0) {
num /= i;
dnm /= i;
i--;
}

}
if(num==0 || dnm ==0) {
	return 0+"";
}
else {
	return num + "/" + dnm;
}
}
public static String Frac1(String in) {
// given it does not have '_'
pp(in);
if (in.indexOf('/') == -1)
return in;
else {
in = simplify(in);
int ind = in.indexOf('/');
int num = Integer.parseInt(in.substring(0, ind));
int dnm = Integer.parseInt(in.substring(ind + 1));

boolean isNegative = false;

if (num < dnm) {
return in;
} else if (num % dnm == 0) {
return "" + num / dnm;
} else {
if (num < 0) {
isNegative = !isNegative;
num = 0 - num;
}
if (dnm < 0) {
isNegative = !isNegative;
dnm = 0 - dnm;
}
String result = num / dnm + "_" + num % dnm + "/" + dnm;
if (isNegative)
result = '-' + result;
return result;
}
}
}

public static void pp(String a) {
System.out.println(a);
}

// TODO: Fill in the space below with any helper methods that you think you will
// need

}

