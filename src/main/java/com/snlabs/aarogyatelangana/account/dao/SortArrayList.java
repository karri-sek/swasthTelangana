package com.snlabs.aarogyatelangana.account.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortArrayList {
	
	public static List<Integer> arrayList = new ArrayList<Integer>();
  public static void main(String[] args){
	  arrayList.add(2);
		  arrayList.add(23);
			  arrayList.add(6);
			 Collections.sort(arrayList);
			 System.out.println(" arraList "+arrayList);
			 System.out.println(" hello "+arrayList.get(arrayList.size()-1));
  }
}
