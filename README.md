SolutionForZillowSDECodingTest
==============================
Question 1) Given a string, write a routine that converts the string to a long,
without using the built in functions that would do this. Describe what (if any) limitations the code has. 

Limitations:
The StringToLong() did not declare what kind of numeral it support, for example Chinese numeral 
looks like this :”一千五百四十三”;

The StringToLong() did not throw any Exception. And the Test() did not catch any Exception.
Actually there will be many kinds of Exceptions.
For example:
	RuntimeException: s == null;
	NumberFormatException: s contains illegal character or the 	beginning of s is 0;
	IllegalArgumentException: s.length < 1 or s is out of range for 	long in java. 
	The signed long has a minimum value of -263 and a 	maximum value of 263-1;
