package com.liuhao.sort;

/**
 * @author liuhao
 * 堆排序
 */
public class HeapSort {

	/*
	 * 输入：数组a，堆的长度heapLen，以及需要调整的节点i
	 * 
	 * 功能：调堆
	 */
	void adjustHeap(int[] a, int heapLen, int i) {
		int left = LeftChild(i);
		int right = RightChild(i);
		int largest = i;
		int temp = 0;

		while (left < heapLen || right < heapLen) {

			// 两个if语句可以得出父节点和左右子节点中，数值最大的是哪个，并用largest指向它
			if (left < heapLen && a[largest] < a[left]) {
				largest = left;
			}

			if (right < heapLen && a[largest] < a[right]) {
				largest = right;
			}

			if (i != largest) { // 如果最大值不是父节点
				temp = a[largest]; // 交换父节点和最大值的子节点
				a[largest] = a[i];
				a[i] = temp;

				i = largest; // 新的父节点和子节点
				left = LeftChild(i);
				right = RightChild(i);
			}

			else {
				break;
			}
		}
	}

	/*
	 * 输入：数组a，堆的大小heapLen
	 * 
	 * 功能：键堆
	*/
	void buildHeap(int a[], int heapLen) {
		int i = 0;
		int begin = heapLen / 2 - 1; // 最后一个非叶子节点
		for (i = begin; i >= 0; i--) {
			adjustHeap(a, heapLen, i);
		}
	}
	
	public int[] heapSort(int[] a){
		int heapLen = a.length;
		int temp;
		
		buildHeap(a, heapLen);
		
		while (heapLen > 1){
			temp = a[heapLen-1];
			a[heapLen-1] = a[0];
			a[0] = temp;
			heapLen--;
			adjustHeap(a, heapLen, 0);
		}
		
		return a;
	}

	private int RightChild(int i) {
		return (i << 1) + 1;
	}

	private int LeftChild(int i) {
		return (i << 1) + 2;
	}

}
