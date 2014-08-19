package com.liuhao.sort;

import java.util.Arrays;

//定义一个数据包装类
class DataWrap implements Comparable<DataWrap>{

	int data;
	String flag;
	
	public DataWrap(int data, String flag) {
		this.data = data;
		this.flag = flag;
	}

	public String toString(){
		return data + flag;
	}

	@Override
	public int compareTo(DataWrap dw) {
		return this.data > dw.data ? 
				1 : (this.data == dw.data ? 0 : -1);
	}
	
}

public class SelectSort {

	public static void selectSort(DataWrap[] data){
		System.out.println("开始排序");
		int arrayLength = data.length;
		
		//依次进行n-1次比较，第i趟比较将第i大的值选出放在i位置上
		for(int i=0; i<arrayLength-1; i++){
			//minIndex用于保留本趟中最小值的索引
			int minIndex = i;
			for(int j=1+1; j<arrayLength; j++){
				
				//i上的数据>j上的数据
				if(data[minIndex].compareTo(data[j]) > 0){
					minIndex = j;
				}
			}
			
			if(minIndex != i){
				DataWrap tmp = data[i];
				data[i] = data[minIndex];
				data[minIndex] = tmp;
			}
			
			System.out.println("第" + (i+1) + "趟排序后：" + Arrays.toString(data));
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
		
		selectSort(data);
		
		System.out.println("排序之后：" + Arrays.toString(data));
	}
	
}
