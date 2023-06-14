package com.day2;
import java.util.*;
public class LSeach_r {

	public static void main(String[]arrgs) {
		int arr[]= {1,2,3,4,5,5,5,5,7,88123214,1212,321,5};
		int n=arr.length;
	List<Integer>list=new ArrayList<>();
		System.out.println(search(arr,n,0,5,list));
	}
	public static List<Integer> search(int arr[],int n,int index,int k,List<Integer>list) {
		if(index==n)return list;
		if(arr[index]==k) list.add(index);
		return search(arr,n,index+1,k,list);
	}
}
