package com.liuhao.sort;

/**
 * ��ѡ������
 * @author liuhao
 * ��Ҫ�����һ�����У�ѡ����С��һ�������һ��λ�õ���������
 * Ȼ����ʣ�µ�������������С����ڶ���λ�õ������������ѭ���������ڶ����������һ�����Ƚ�Ϊֹ��
 */
public class SelectionSort {

	public int[] selectionSort(int[] a){
		
		int pos = 0;
		
		for(int i=0; i<a.length; i++){
			int j = i+1;
			pos = i;
			int temp = a[i];
			
			//�ҳ���Сֵ����������λ��
			for(; j<a.length; j++){
				if(a[j] < temp){
					temp = a[j];
					pos = j;
				}
			}
			
			//��С���뵱ǰ�Ľ��н���
			a[pos] = a[i];
			a[i] =temp;
		}
		
		return a;
	}
}
