package com.snlabs.aarogyatelangana.account.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class AccountUtils {
	
	public static void main(String[] args){
		System.out.println("hhhhhhhhh:" + (new Random().nextInt(9999-1000)+1000));
		String str = "/resources/download_concepts_template.xls";
		String fileName =  str.substring(str.lastIndexOf("/")+1,str.lastIndexOf("."));
		System.out.println(fileName);
	}
	public String md5(String input) {
		String md5 = null;
		if (null == input)
			return null;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(input.getBytes(), 0, input.length());
			md5 = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}
	
}
