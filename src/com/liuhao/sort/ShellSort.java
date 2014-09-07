package com.liuhao.sort;

import java.util.Arrays;

public class ShellSort {

	public static void shellSort(DataWrap[] data){
		
		int arrayLength = data.length;
		
		int h = 1;//保存可变增量
		
		//按h * 3 + 1得到增量序列的最大值
		while(h <= arrayLength/3){
			h = h * 3 + 1;
		}
		
		while(h > 0){
			System.out.println("====h的值：" + h + "====");
			
			for(int i = h; i < arrayLength; i++){
				DataWrap tmp = data[i];
				
				if(data[i].compareTo(data[i - h]) < 0){
					int j = i - h;
					
					//整体后移h位
					for(; j >= 0 && data[j].compareTo(tmp) > 0; j-=h){
						data[j+h] = data[j];
					}
					
					data[j+h] = tmp;
				}
				
				System.out.println(Arrays.toString(data));
			}
			
			h = (h-1) / 3;
		}
	}
	
	public static void main(String[] args) {
		DataWrap[] data = {
				new DataWrap(9, "")
				,new DataWrap(-16, "")
				,new DataWrap(21, "")
				,new DataWrap(23, "*")
				,new DataWrap(-30, "")
				,new DataWrap(-49, "")
				,new DataWrap(21, "")
				,new DataWrap(30, "")
				,new DataWrap(3, "")
				,new DataWrap(67, "")
				,new DataWrap(35, "")
				,new DataWrap(5, "")
		};
		
		System.out.println("排序之前：" + Arrays.toString(data));
		shellSort(data);
		System.out.println("排序之后：" + Arrays.toString(data));
	}
	
}
