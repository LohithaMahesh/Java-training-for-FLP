package com;

import java.util.Arrays;

public class A{
	public static void main(String args[]){
	Object [] myObjects = {
			 new integer(12),
			 new String(”foo”),
			 new integer(5),
		     new Boolean(true)
			 };
			 Arrays.sort(myObjects);
			 for( int i=0; i<myObjects.length; i++) {
			 System.out.print(myObjects[i].toString());
			 System.out.print(" ");
			 }
	}
}





