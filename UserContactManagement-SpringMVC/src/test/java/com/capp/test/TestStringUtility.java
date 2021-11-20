package com.capp.test;

import com.capp.util.StringUtility;

public class TestStringUtility {

	public static void main(String[] args) {
		
		Object[] arr=new Object[] {2,5,4,6};
		String str=StringUtility.arrayToCommaSeperatedString(arr);
		System.out.println(str);
	}

}
