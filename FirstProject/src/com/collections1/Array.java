package com.collections1;

import java.util.Collection;

import com.collections.ArrayList;
import com.collections.List;

public class Array {
	
	public static void main(String[] args) {
		int[] numbrs = {1,2,3, 4, 7};
		
		int length = numbrs.length;
		
		for(int i = 0; i < length; i++) {
			System.out.println(numbrs[i]);
		}
	}
}
