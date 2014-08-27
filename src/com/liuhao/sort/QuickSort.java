package com.liuhao.sort;

import java.util.Arrays;

/**
 * 快速排序的Java实现
 * @author liuhao
 *
 */
public class QuickSort {

	/**
	 * @param data
	 * @param start
	 * @param end
	 */
	private static int subSort(DataWrap[] data, int start, int end){

		DataWrap tmp = data[start];
		while(start < end){
			while( start < end && data[end].compareTo(tmp) >= 0){
				end--;
			}
			data[start] = data[end];
			
			while(start < end && data[start].compareTo(tmp) <= 0){
				start++;
			}
			data[end] = data[start];
		}
		
		data[end] = tmp;
		
		System.out.println(Arrays.toString(data));
		
		return start;
	}
	
	/**
	 * 递归进行快速排序
	 * @param data
	 * @param start
	 * @param end
	 */
	public static void quickSort(DataWrap[] data, int start, int end){
		if(start < end){
			int key = subSort(data, start, end);
			quickSort(data, start, key-1);
			quickSort(data, key+1, end);
		}
	}
	
	public static void main(String[] args) {
		DataWrap[] data = {
				new DataWrap(21, "")
				,new DataWrap(30, "")
				,new DataWrap(49, "")
				,new DataWrap(30, "*")
				,new DataWrap(16, "")
				,new DataWrap(9, "")
		};
		
		System.out.println("排序之前：" + Arrays.toString(data));
		quickSort(data, 0, data.length-1);
		System.out.println("排序之后：" + Arrays.toString(data));
	}
	
}
