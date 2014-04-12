package com.liuhao.sort;

/**
 * 简单选择排序
 * @author liuhao
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 */
public class SelectionSort {

	public int[] selectionSort(int[] a){
		
		int pos = 0;
		
		for(int i=0; i<a.length; i++){
			int j = i+1;
			pos = i;
			int temp = a[i];
			
			//找出最小值，及其所在位置
			for(; j<a.length; j++){
				if(a[j] < temp){
					temp = a[j];
					pos = j;
				}
			}
			
			//最小的与当前的进行交换
			a[pos] = a[i];
			a[i] =temp;
		}
		
		return a;
	}
}
