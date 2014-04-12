package com.liuhao.sort;

public class ShellSort {

	public int[] shellSort(int[] a){
		int j;
		
		for(int gap=a.length/2; gap>0; gap/=2){
			for(int i=gap; i<a.length; i++){
				int temp = a[i];
				for(j=i; j>=gap && a[j-gap]>temp; j-=gap){
					a[j] = a[j-gap];
				}
				a[j] = temp;
			}
		}

		return a;
	}
	
}
