package com.liuhao.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void bubbleSort(DataWrap[] data) {
		System.out.println("开始排序");
		int arrayLength = data.length;

		for (int i = 0; i < arrayLength - 1; i++) {
			boolean flag = false; //记录某趟是否发生元素交换
			for (int j = 0; j < arrayLength - 1 - i; j++) {
				// 处的元素值大于j+1处的，j处data要往后沉
				if(data[j].compareTo(data[j+1]) > 0){
					DataWrap tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
					flag = true;
				}
			}
			
			System.out.println(Arrays.toString(data));
			
			//如果某趟没有发生交换，说明序列已经有序，就不需要进行之后的比较了
			if(!flag){
				break;
			}
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
		
		bubbleSort(data);
		
		System.out.println("排序之后：" + Arrays.toString(data));
	}
}
