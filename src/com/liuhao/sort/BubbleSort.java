package com.liuhao.sort;

public class BubbleSort {

	public int[] bubbleSort(int[] a) {

		int temp = 0;

		for (int flag = 0; flag < a.length-1; flag++) {

			for (int i = a.length-1; i > flag; i--) {

				if (a[i - 1] > a[i]) {
					temp = a[i];
					a[i] = a[i - 1];
					a[i - 1] = temp;
				}
			}
		}

		return a;
	}

}
