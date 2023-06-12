package com.day2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int []arr= {1,2,3,4,4,5,8,5,6,7,9,10};
	int n=arr.length;
	System.out.println(checksort(arr, n,0));
	}
	public static boolean checksort(int []arr ,int n ,int index) {
		if(index==n-1) return true;
		return arr[index]<=arr[index+1]&&checksort(arr,n,index+1);
	}

}
