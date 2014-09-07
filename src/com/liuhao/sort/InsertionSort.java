package com.liuhao.sort;

import java.util.Arrays;

/**
 * 直接插入排序的Java实现
 * @author liuhao
 *
 */
public class InsertionSort {

	public static void insertSort(DataWrap[] data){
		int arrayLength = data.length;
		
		for(int i=1; i<arrayLength; i++){
			
			DataWrap tmp = data[i];//当整体后移时，保证当前的data[i]不会丢失
			
			//i处的值已经比它之前的所有值都大，表明已有序，无需插入
			if(data[i].compareTo(data[i-1]) < 0){
				int j=i-1;
				
				//从当前（i指向）索引的前一个（j指向）开始，与当前索引值进行比较
				//若大于，则将data[j]后移至data[j+1]处，直至到小于的状态（即合适的插入位置）
				for(; j>=0 && tmp.compareTo(data[j]) < 0; j--){
					// i处的值小于j处的值
					data[j+1] = data[j];
				}
				
				//将之前保存的tmp值插入
				data[j+1] = tmp;
			}
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
				,new DataWrap(9, "")
		};
		
		System.out.println("排序之前：" + Arrays.toString(data));
		insertSort(data);
		System.out.println("排序之后：" + Arrays.toString(data));
	}
	
}
