package com.liuhao.sort;

public class QuickSort {

	private int getMiddle(int[] a, int left, int right) {

		int temp = a[left]; // ����ĵ�һ������Ϊ��׼

		while (left < right) {
			while (left < right && a[right] >= temp) {
				right--;
			}
			//�Ȼ�׼С�������Ƶ����
			a[left] = a[right];

			while (left < right && a[left] <= temp) {
				left++;
			}
			//�Ȼ�׼��������Ƶ��Ҷ�
			a[right] = a[left];
		}
		
		a[left] = temp;

		return left;
	}

	private void quick(int[] a, int left, int right) {
		if (left < right) {
			
			//������a���зָ�
			int middle = getMiddle(a, left, right);
			
			//�����������п�������
			quick(a, left, middle - 1);
			
			//���Ҷ�������п�������
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
