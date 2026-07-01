
/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
*/

import java.io.*;

class App3 {
	
        public static void main(String args[]) throws IOException {
			
        	System.out.println("This program gives you number of your words in your text.");
			System.out.println("Please enter your text: ");
			
			char c;
			int count = 0;
			for (;;) {
				
				c = (char) System.in.read();
				
				if (c == '*') {
					break;
				}
				
				if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
					count++;
					while ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
						c = (char) System.in.read();
					}
				}
				
			}	
			
			System.out.println(count);
			
        }
}