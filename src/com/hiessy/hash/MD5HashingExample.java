package com.hiessy.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashingExample {

	public static void main(String[] args) throws Exception {

		char[] word = new char[9];


			System.out.println(checkWord(word, -1));
	}

	private static String getHash(String word) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(word.getBytes());

		byte byteData[] = md.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		return sb.toString();

	}

	
	public static char[] checkWord(char[] word, int index) throws NoSuchAlgorithmException{
		index++;
		
		for (; index < 9; )
			for (char i = 33; i < 126; i++) {
				word[index] = i;
				String hashword = getHash(String.valueOf(word));
				System.out.println("Comparing " + String.valueOf(word) + ", with hash: " +hashword + ", to hash: dc40b85276a1f4d7cb35f154236aa1b2" );
				if((hashword).equals("dc40b85276a1f4d7cb35f154236aa1b2")){ // a401b442cf25b81f08621586e5bfe9eeto  //dc40b85276a1f4d7cb35f154236aa1b2
					System.out.println("The word is****************************************************************: " + String.valueOf(word));
					System.exit(0);
				}
					
				checkWord(word,index);
			}
		
		return word;
	}
}
