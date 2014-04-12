package com.liuhao.sort;

/**
 * @author liuhao
 * ������
 */
public class HeapSort {

	/*
	 * ���룺����a���ѵĳ���heapLen���Լ���Ҫ�����Ľڵ�i
	 * 
	 * ���ܣ�����
	 */
	void adjustHeap(int[] a, int heapLen, int i) {
		int left = LeftChild(i);
		int right = RightChild(i);
		int largest = i;
		int temp = 0;

		while (left < heapLen || right < heapLen) {

			// ����if�����Եó����ڵ�������ӽڵ��У���ֵ�������ĸ�������largestָ����
			if (left < heapLen && a[largest] < a[left]) {
				largest = left;
			}

			if (right < heapLen && a[largest] < a[right]) {
				largest = right;
			}

			if (i != largest) { // ������ֵ���Ǹ��ڵ�
				temp = a[largest]; // �������ڵ�����ֵ���ӽڵ�
				a[largest] = a[i];
				a[i] = temp;

				i = largest; // �µĸ��ڵ���ӽڵ�
				left = LeftChild(i);
				right = RightChild(i);
			}

			else {
				break;
			}
		}
	}

	/*
	 * ���룺����a���ѵĴ�СheapLen
	 * 
	 * ���ܣ�����
	*/
	void buildHeap(int a[], int heapLen) {
		int i = 0;
		int begin = heapLen / 2 - 1; // ���һ����Ҷ�ӽڵ�
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
