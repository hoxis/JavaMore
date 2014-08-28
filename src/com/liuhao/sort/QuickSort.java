package com.liuhao.sort;

import java.util.Arrays;

/**
 * 快速排序的Java实现
 * @author liuhao
 *
 */
public class QuickSort {

	/**
	 * 对序列data，从start到end进行一趟处理
	 * @param data
	 * @param start
	 * @param end
	 */
	private static int subSort(DataWrap[] data, int start, int end){

		//将start处的元素值作为基准
		DataWrap tmp = data[start];
		
		while(start < end){
			
			//从尾部开始找小于基准的元素索引，直到找到满足这样条件的索引
			while( start < end && data[end].compareTo(tmp) >= 0){
				end--;
			}
			//用找到的小于基准的元素值覆盖start处的元素值，start处的元素值已经备份在tmp中
			data[start] = data[end];
			
			//从首部开始找大于基准的元素索引
			while(start < end && data[start].compareTo(tmp) <= 0){
				start++;
			}
			//用找到的大于基准的元素值覆盖end处的元素值，end处的元素值已经覆盖在之前的start处
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
