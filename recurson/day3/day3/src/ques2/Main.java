package ques2;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		int []arr= {1,2,3,4,5,6};
		int N=arr.length-1;
		
		print(N-1,arr);
	}
public static void reverse(int N ,int[]arr) {
	if(N<0) {
		
		return;
	}
	System.out.println(arr[N]);
	reverse(N-1,arr);
}


public static void print(int N ,int[]arr) {
	if(N<0) {
		
		return;
	}
	//System.out.println(arr[N]);
	print(N-1,arr);
	System.out.println(arr[N]);
}
}
