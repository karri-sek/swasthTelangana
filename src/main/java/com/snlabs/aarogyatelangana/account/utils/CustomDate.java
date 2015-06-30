package com.snlabs.aarogyatelangana.account.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDate {


    public static String MONTH;
    public static String YEAR;
    public static String DATE;
    public CustomDate(String date) {
      CustomDate.DATE = date.substring(date.lastIndexOf("-")+1);
      CustomDate.MONTH = date.substring(date.indexOf("-")+1,date.lastIndexOf("-"));
      CustomDate.YEAR = date.substring(0,date.indexOf("-"));
    }

	public static void main(String[] args) {
		String s = "THIS";
		String[] v = s.split(" ");
		for(String s1:v){
			System.out.println(" V: "+s1);
		}

        File f  = new File("D:\\folder\test.txt");
        try{
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMMM-dd");
            CustomDate dateObject = new CustomDate(sdf.format(date));
           System.out.print(" >>>> "+dateObject.DATE);
            System.out.print(" >>>> "+dateObject.MONTH);
            System.out.print(" >>>> "+dateObject.YEAR);

            if(!f.exists()){
                System.out.print("Created Successfully");
            }else{
                System.out.print(" Failed on creation");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

	}

}
