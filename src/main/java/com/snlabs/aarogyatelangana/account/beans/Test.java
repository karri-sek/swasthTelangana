package com.snlabs.aarogyatelangana.account.beans;


/**
 * @author nbattula
 *
 */
public class Test {
	/*Find three closest elements from given three sorted arrays
	 * http://www.geeksforgeeks.org/find-three-closest-elements-from-given-three-sorted-arrays/ */
	public static void main(String[] args) throws Exception {
		int[]a =  {20, 24, 100};
		int[]b = {2, 19, 22, 79, 800};
		int[]c = {10, 12, 23, 24, 119};
		
		int max = 999;
		int min = 0;
		int diff = 999;
		int i = 0; int j = 0; int k = 0;
		int aIndex = 0, bIndex = 0, cIndex = 0;
		
		while (i < a.length && j < b.length && k < c.length) {
			max = Math.max(Math.max(a[i], b[j]), c[k]);
			min = Math.min(Math.min(a[i], b[j]), c[k]);
			
			if(max - min < diff){
				aIndex = i;
				bIndex = j;
				cIndex = k;
				diff = max - min;
			}
			
			if(diff == 0) break;
			
			if(a[i] == min) i++;
			else if (b[j] == min) j++;
			else k++;
		}
		
		System.out.println(a[aIndex] +" : "+b[bIndex] +" : "+c[cIndex]);
	}
	
	
}
