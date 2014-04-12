package com.liuhao.test;

import org.junit.Test;

import com.liuhao.sort.BubbleSort;
import com.liuhao.sort.HeapSort;
import com.liuhao.sort.InsertionSort;
import com.liuhao.sort.QuickSort;
import com.liuhao.sort.SelectionSort;
import com.liuhao.sort.ShellSort;

public class SortTest {

	int a[] = { 49, 38, 65, 97, 76, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };

	// ºÚµ•≤Â»Î≈≈–Ú
	@Test
	public void testInsertSort() {

		int[] result = new InsertionSort().insertSort(a);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	// œ£∂˚≈≈–Ú
	@Test
	public void testShellSort() {

		int[] result = new ShellSort().shellSort(a);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

	// ºÚµ•—°‘Ò≈≈–Ú
	@Test
	public void testSelectionSort() {

		int[] result = new SelectionSort().selectionSort(a);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

	// ∂—≈≈–Ú
	@Test
	public void testHeapSort() {

		int[] result = new HeapSort().heapSort(a);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

	// √∞≈›≈≈–Ú
	@Test
	public void testBubbleSort() {

		int[] result = new BubbleSort().bubbleSort(a);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

	// øÏÀŸ≈≈–Ú
	@Test
	public void testQuickSort() {

		int[] result = new QuickSort().quickSort(a);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}
}
