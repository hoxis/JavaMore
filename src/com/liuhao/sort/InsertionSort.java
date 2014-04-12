package com.liuhao.sort;

public class InsertionSort {

	/**
	 *  ֱ�Ӳ�������
	 *  ����˼�룺��Ҫ�����һ�����У�����ǰ��(n-1)[n>=2] �����Ѿ����ź�˳��ģ�
	 *  ����Ҫ�ѵ�n�����嵽ǰ����������У�ʹ����n����Ҳ���ź�˳��ġ���˷���ѭ����
	 *  ֱ��ȫ���ź�˳��
	 * @param a
	 * @return
	 */
	public int[] insertSort(int a[]){
		
		int temp = 0;
		
		for(int i=1; i<a.length; i++){
			int j = i-1;
			temp = a[i];
			
			for(;j>=0 && a[j]>temp; j--){
				a[j+1] = a[j];
			}
			
			a[j+1] = temp;
		}
		
		return a;
	}
}
