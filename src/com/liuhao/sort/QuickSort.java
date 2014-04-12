package com.liuhao.sort;

public class QuickSort {

	private int getMiddle(int[] a, int left, int right) {

		int temp = a[left]; // 数组的第一个数作为基准

		while (left < right) {
			while (left < right && a[right] >= temp) {
				right--;
			}
			//比基准小的数据移到左端
			a[left] = a[right];

			while (left < right && a[left] <= temp) {
				left++;
			}
			//比基准大的数据移到右端
			a[right] = a[left];
		}
		
		a[left] = temp;

		return left;
	}

	private void quick(int[] a, int left, int right) {
		if (left < right) {
			
			//将数组a进行分割
			int middle = getMiddle(a, left, right);
			
			//对左端数组进行快速排序
			quick(a, left, middle - 1);
			
			//对右端数组进行快速排序
			quick(a, middle + 1, right);
		}
	}

	public int[] quickSort(int[] a) {

		if (a.length > 0) {
			quick(a, 0, a.length - 1);
		}

		return a;
	}
}
