package com.liuhao.sort;

import java.util.Arrays;

public class BinaryInsertSort {

	public static void binaryInsertSort(DataWrap[] data){
		int arrayLength = data.length;
		
		for(int i=1; i<arrayLength; i++){
			DataWrap tmp = data[i];
			
			int low = 0;
			int high = i-1;
			
			// 不断折半，寻找合适的插入位置
			while(low <= high){
				int mid = (low + high) / 2;
				
				if(tmp.compareTo(data[mid]) > 0){
					low = mid + 1;
				}
				else{
					high = mid - 1;
				}
			}
			
			// 依次后移
			for(int j=i; j>low ; j--){
				data[j] = data[j-1];
			}
			
			data[low] = tmp;
			System.out.println(Arrays.toString(data));
		}
	}
	
	public static void main(String[] args) {
		DataWrap[] data = { 
				new DataWrap(21, "")
				,new DataWrap(30, "")
				,new DataWrap(49, "")
				,new DataWrap(30, "*")
				,new DataWrap(16, "")
				,new DataWrap(9, "") };

		System.out.println("排序之前：" + Arrays.toString(data));

		binaryInsertSort(data);
		
		System.out.println("排序之后：" + Arrays.toString(data));
	}
	
}
