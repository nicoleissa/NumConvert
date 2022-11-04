/*Part3.java: Number system conversion application that uses methods and loops  

Name: Nicole Issagholian

Date: 10/15/2021
*/

import java.util.Scanner;

public class Part3
{
	public static void main (String[] args)
	{
		//creates a scanner object
		Scanner data = new Scanner(System.in);

		//asks for name of number system to convert from
		System.out.print("Enter the name of the number system to convert from: bin, or dec, or oct or hex: ");

		String nameConvertFrom = data.next();


		//asks for number
		System.out.print("Enter number as a String: ");

		String numberString = data.next();


		//asks for name of number system to convert to
		System.out.print("Enter the name of the number system you want to convert to: bin, or dec, or oct or hex: ");

		String nameConvertTo = data.next();

		//calls hexToOthers method
		hexToOthers(numberString, nameConvertFrom, nameConvertTo);

		//calls decToOthers method
		decToOthers(numberString, nameConvertFrom, nameConvertTo);

		//calls octToOthers method
		octToOthers(numberString, nameConvertFrom, nameConvertTo);		

		//calls binToOthers method
		binToOthers(numberString, nameConvertFrom, nameConvertTo);
	}	

	//method that converts hexadecimal to decimal, octal, and binary using if statements; does not return anything
	public static void hexToOthers(String numberString, String nameConvertFrom, String nameConvertTo)
	{
		if (nameConvertFrom.equals("hex") && nameConvertTo.equals("dec"))
		{
			char hexValues[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
			int size = numberString.length(); 
			int numHexToDec = 0;

			for (int i=0; i<size; i++) 
			{
				char charHex = numberString.charAt(i);
				numHexToDec = numHexToDec * 16 + charNum(charHex);
			}
			System.out.println("The result is: " + numHexToDec);
		}

		if (nameConvertFrom.equals("hex") && nameConvertTo.equals("oct"))
		{
			//convert hexadecimal to decimal
			char hexValues[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
			int size = numberString.length(); 
			int numDecimal = 0;

			for (int i=0; i<size; i++) 
			{
				char charHex = numberString.charAt(i);
				numDecimal = numDecimal * 16 + charNum(charHex);
			}

			//convert decimal to octal
			int remainder;
			String numHexToOct = "";
			char octValues[] = {'0', '1', '2', '3', '4', '5', '6', '7'};


			while (numDecimal > 0)
			{
				remainder = numDecimal % 8;
				numHexToOct = octValues[remainder] + numHexToOct;
				numDecimal /= 8;
			}
			System.out.println("The result is: " + numHexToOct);
		}

		if (nameConvertFrom.equals("hex") && nameConvertTo.equals("bin"))
		{
			//convert hexadecimal to decimal
			char hexValues[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
			int size = numberString.length(); 
			int numDecimal = 0;

			for (int i=0; i<size; i++) 
			{
				char charHex = numberString.charAt(i);
				numDecimal = numDecimal * 16 + charNum(charHex);
			}

			//convert decimal to binary
			int remainder;
			String numDecToBin = "";
			
			while (numDecimal > 0)
			{
				remainder = numDecimal % 2;
				if (remainder == 0)
					numDecToBin = '0' + numDecToBin;
				else 
					numDecToBin = '1' + numDecToBin;
				numDecimal = numDecimal / 2;
			}
			System.out.println("The result is: " + numDecToBin);
		}
	}

	//method that converts decimal to hexadecimal, octal, and binary using if statements; does not return anything
	public static void decToOthers(String numberString, String nameConvertFrom, String nameConvertTo)
	{
		if (nameConvertFrom.equals("dec") && nameConvertTo.equals("hex"))
		{
			int numInput = Integer.parseInt(numberString);
			char hexValues[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
			String numDecToHex = "";
			int remainder;

			while (numInput > 0)
			{
				remainder = numInput % 16;
				numDecToHex = hexValues[remainder] + numDecToHex;				
				numInput /= 16; 	
			}
			System.out.println("The result is: " + numDecToHex); 
		}

		if (nameConvertFrom.equals("dec") && nameConvertTo.equals("oct"))
		{
			int numInput = Integer.parseInt(numberString);
			int remainder;
			String numDecToOct = "";
			char octValues[] = {'0', '1', '2', '3', '4', '5', '6', '7'};

			while (numInput > 0)
			{
				remainder = numInput % 8;
				numDecToOct = octValues[remainder] + numDecToOct;
				numInput /= 8;
				
			}
			System.out.println("The result is: " + numDecToOct);
		}

		if (nameConvertFrom.equals("dec") && nameConvertTo.equals("bin"))
		{
			int numInput = Integer.parseInt(numberString);
			int remainder;
			String numDecToBin = "";
			
			while (numInput > 0)
			{
				remainder = numInput % 2;
				if (remainder == 0)
					numDecToBin = '0' + numDecToBin;
				else 
					numDecToBin = '1' + numDecToBin;
				numInput /= 2;
			}
			System.out.println("The result is: " + numDecToBin);
		}
	}

	//method that converts octal to decimal, hexadecimal, and binary using if statements; does not return anything
	public static void octToOthers(String numberString, String nameConvertFrom, String nameConvertTo)
	{
		if (nameConvertFrom.equals("oct") && nameConvertTo.equals("dec"))
		{
			int numInput = Integer.parseInt(numberString);
			int size = numberString.length(); 

			int remainder;
			int numOctToDec = 0;

			while (numInput > 0)
			{
				for (int i=0; i<size; i++)
				{
					remainder = numInput % 10;
					numOctToDec += remainder * Math.pow(8, i);
					numInput /= 10;
				}
			}
			System.out.println("The result is: " + numOctToDec);
		}

		if (nameConvertFrom.equals("oct") && nameConvertTo.equals("hex"))
		{
			//convert octal to decimal first
			int numInput = Integer.parseInt(numberString);
			int size = numberString.length(); 
			char hexValues[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

			int remainder;
			int numOctToDec = 0;

			while (numInput > 0)
			{
				for (int i=0; i<size; i++)
				{
					remainder = numInput % 10;
					numOctToDec += remainder * Math.pow(8, i);
					numInput /= 10;
				}
			}

			//convert decimal to hexadecimal
			String numOctToHex = "";
		
			while (numOctToDec > 0)
			{
				remainder = numOctToDec % 16;
				numOctToHex = hexValues[remainder] + numOctToHex;				
				numOctToDec /= 16; 	
			}
			System.out.println("The result is: " + numOctToHex); 
		}

		if (nameConvertFrom.equals("oct") && nameConvertTo.equals("bin"))
		{
			//convert octal to decimal first
			int numInput = Integer.parseInt(numberString);
			int size = numberString.length(); 

			int remainder;
			int numOctToDec = 0;

			while (numInput > 0)
			{
				for (int i=0; i<size; i++)
				{
					remainder = numInput % 10;
					numOctToDec += remainder * Math.pow(8, i);
					numInput /= 10;
				}
			}
			
			//convert decimal to binary
			int remainder2;
			String numOctToBin = "";
			
			while (numOctToDec > 0)
			{
				remainder2 = numOctToDec % 2;
				if (remainder2 == 0)
					numOctToBin = '0' + numOctToBin;
				else 
					numOctToBin = '1' + numOctToBin;
				numOctToDec /= 2;
			}
			System.out.println("The result is: " + numOctToBin);
		}
	}

	//method that converts binary to decimal, hexadecimal, and octal using if statements; does not return anything
	public static void binToOthers(String numberString, String nameConvertFrom, String nameConvertTo)
	{
		if (nameConvertFrom.equals("bin") && nameConvertTo.equals("dec"))
		{
			long numInput = Long.parseLong(numberString);
			int size = numberString.length(); 
			long remainder;
			int numBinToDec = 0;

			while (numInput > 0)
			{
				for (int i=0; i<size; i++)
				{
					remainder = numInput % 10;
					numBinToDec += remainder * Math.pow(2, i);
					numInput /= 10;
				}
			}
			System.out.println("The result is: " + numBinToDec);
		}

		if (nameConvertFrom.equals("bin") && nameConvertTo.equals("hex"))
		{
			//bin to dec
			long numInput = Long.parseLong(numberString);
			int size = numberString.length(); 
			long remainder;
			int numBinToDec = 0;

			while (numInput > 0)
			{
				for (int i=0; i<size; i++)
				{
					remainder = numInput % 10;
					numBinToDec += remainder * Math.pow(2, i);
					numInput /= 10;
				}
			}

			//dec to hex
			char hexValues[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
			String numBinToHex = "";
			int remainder2;

			while (numBinToDec > 0)
			{
				remainder2 = numBinToDec % 16;
				numBinToHex = hexValues[remainder2] + numBinToHex;				
				numBinToDec /= 16; 	
			}		
			System.out.println("The result is: " + numBinToHex); 
		}

		if (nameConvertFrom.equals("bin") && nameConvertTo.equals("oct"))
		{
			//convert binary to decimal first
			long numInput = Long.parseLong(numberString);
			int size = numberString.length(); 
			long remainder;
			int numBinToDec = 0;

			while (numInput > 0)
			{
				for (int i=0; i<size; i++)
				{
					remainder = numInput % 10;
					numBinToDec += remainder * Math.pow(2, i);
					numInput /= 10;
				}
			}
			
			//convert decimal to octal
			int remainder2;
			String numBinToOct = "";
			char octValues[] = {'0', '1', '2', '3', '4', '5', '6', '7'};

			while (numBinToDec > 0)
			{
				remainder2 = numBinToDec % 8;
				numBinToOct = octValues[remainder2] + numBinToOct;
				numBinToDec /= 8;
				
			}
			System.out.println("The result is: " + numBinToOct);
		}
	}

	//method that converts numbers over 9 to its respective equivalent letter in hexadecimal
	//if the value is between 0 and 9, the number in hexadecimal will remain as that number
	//if the value is over 9, it will be converted to a character from A to F; 10=A, 11=B, 12=C, 13=D, 14=E, 15=F 
	public static int charNum(char charHex)
	{
		if (charHex >= '0' && charHex <= '9')
			return (int)charHex - '0';
		else
			return (int)charHex - 'A' + 10;
	}
}
