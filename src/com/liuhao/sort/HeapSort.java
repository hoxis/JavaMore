package com.liuhao.sort;

import java.util.Arrays;

public class HeapSort {
	public static void heapSort(DataWrap[] data) {
		System.out.println("开始排序");
		int arrayLen = data.length;

		// 循环建堆
		for (int i = 0; i < arrayLen - 1; i++) {
			// 建堆
			buildMaxHeap(data, arrayLen - 1 - i);
			// 交换堆顶元素和大顶堆的最后一个元素
			swap(data, 0, arrayLen - 1 - i);
			System.out.println(Arrays.toString(data));
		}
	}

	/**
	 * 对data数组从0到lastIndex建大顶堆
	 * 
	 * @param data
	 * @param lastIndex
	 */
	private static void buildMaxHeap(DataWrap[] data, int lastIndex) {

		// 从lastIndex处节点（最后一个节点）的父节点开始
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			int k = i; // 保存当前正在判断的节点

			// 如果当前k节点的子节点存在
			while (k * 2 + 1 <= lastIndex) {
				int biggerIndex = 2 * k + 1; // k节点的左子节点的索引

				// 如果biggerIndex < lastIndex，代表k节点存在右子节点，
				//那就先比较左、右节点的值大小，并将大者索引放在biggerIndex
				if (biggerIndex < lastIndex) {
					if (data[biggerIndex].compareTo(data[biggerIndex + 1]) < 0) {
						biggerIndex++;// biggerIndex总是代表较大子节点的索引
					}
				}

				// k节点处的值小于其子节点的值
				if (data[k].compareTo(data[biggerIndex]) < 0) {
					swap(data, k, biggerIndex);

					// 重新保证k节点的值大于其子节点的值，主要用于保证交换后k的子节点也满足大顶堆
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}

	/**
	 * 交换data数组i、j索引处的元素
	 * 
	 * @param data
	 * @param i
	 * @param j
	 */
	private static void swap(DataWrap[] data, int i, int j) {
		DataWrap tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	public static void main(String[] args) {
		DataWrap[] data = { 
				new DataWrap(21, "")
				,new DataWrap(30, "")
				,new DataWrap(49, "")
				,new DataWrap(30, "*")
				,new DataWrap(16, "")
				,new DataWrap(9, "") };

		System.out.println("排序之前：" + Arrays.toString(data));

		heapSort(data);

		System.out.println("排序之后：" + Arrays.toString(data));
	}
}
