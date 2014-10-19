/*
 * Program Description: Routine that converts the string to a long, without using the built in functions.
 * Author:  Jigar S. Rudani
 * Version: 1.0
 */
public class StringToLong {
	public static void main(String [] args){
	String inputStr = "9223372036854775807";
	//String inputStr = "A123";
		try {
		long convertedLongValue = stringToLong(inputStr);
		System.out.println("Input String is: " + inputStr);
		// Just to check whether the conversion is proper I have use the built-in function
		if (convertedLongValue == Long.parseLong(inputStr))
			System.out.println("Successful conversion " + convertedLongValue);
		else
			System.out.println("Failed to convert");
		} catch (NumberFormatException e) {
			System.out.println("Failed to convert");
			System.out.println("There might be error in the input or value is out of range");
			System.out.println("The characters in the string must all be decimal digits, except that the first "
								+ "character may be an ASCII minus sign '-' (\u002D') to indicate a negative value");
			System.out.println("The range for long is 2^64 bits i.e -9223372036854775808 to 9223372036854775807");
		} catch (Exception e) {
			System.out.println("Failed to convert");
			System.out.println("There might be error in the input or value is out of range");
			System.out.println("The characters in the string must all be decimal digits, except that the first "
								+ "character may be an ASCII minus sign '-' (\u002D') to indicate a negative value");
			System.out.println("The range for long is 2^64 bits i.e -9223372036854775808 to 9223372036854775807");
		}
	}
	static long stringToLong(String s) {
		char [] inputCharArr = s.toCharArray();
		long result = 0;
		long placeValue = 1;
		long digit = 0;
		boolean isNegative = false;
		try {
			for (int index = (inputCharArr.length - 1);index >= 0;index--) {
				if (inputCharArr[index] != '-') {
					digit = (inputCharArr[index] - '0');
					result += (digit * placeValue);
					placeValue *= 10;
				} else {
					isNegative = true;
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Failed to convert");
			System.out.println("There might be error in the input or value is out of range");
			System.out.println("The characters in the string must all be decimal digits, except that the first "
								+ "character may be an ASCII minus sign '-' (\u002D') to indicate a negative value");
			System.out.println("The range for long is 2^64 bits i.e -9223372036854775808 to 9223372036854775807");
		} catch (Exception e) {
			System.out.println("Failed to convert");
			System.out.println("There might be error in the input or value is out of range");
			System.out.println("The characters in the string must all be decimal digits, except that the first "
								+ "character may be an ASCII minus sign '-' (\u002D') to indicate a negative value");
			System.out.println("The range for long is 2^64 bits i.e -9223372036854775808 to 9223372036854775807");
		}
		if (isNegative)
			return -result;
		else
			return result;
	}
}