package com.liuhao.DataStructures;

import java.util.Arrays;

public class SequenceStack<T> {

	private final int DEFAULT_SIZE = 10;
	private int capacity;// 保存当前数组长度
	private int capacityIncrement = 0;// 数组长度不够时，程序每次增加的数组长度
	private Object[] elementData;// 保存顺序栈的数据元素
	private int size = 0;// 保存顺序栈中元素的个数

	// 以默认长度创建空的顺序栈
	public SequenceStack() {
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}

	// 以一个初始化元素创建顺序栈
	public SequenceStack(T element) {
		this();
		elementData[0] = element;
		size++;
	}

	/**
	 * 以指定长度创建顺序栈
	 * 
	 * @param element
	 *            指定顺序栈中的第一个元素
	 * @param initSize
	 *            指定顺序栈的底层数组的长度
	 */
	public SequenceStack(T element, int initSize) {
		this.capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = element;
		size++;
	}

	/**
	 * 以指定长度创建顺序栈,同时指定底层数组增量
	 * 
	 * @param element
	 *            指定顺序栈中的第一个元素
	 * @param initSize
	 *            指定顺序栈的底层数组的长度
	 * @param capacityIncrement
	 *            底层数组长度不够时，每次增加的增量
	 */
	public SequenceStack(T element, int initSize, int capacityIncrement) {
		this.capacity = initSize;
		this.capacityIncrement = capacityIncrement;
		elementData = new Object[capacity];
		elementData[0] = element;
		size++;
	}

	// 获取顺序栈的长度
	public int length() {
		return size;
	}

	// 入栈
	public void push(T element) {
		this.ensureCapacity(size + 1);

		// 将元素放到数组，同时让长度+1
		elementData[size++] = element;
	}

	// 保证底层数组的长度
	private void ensureCapacity(int minCapacity) {

		// 如果数组的原有长度小于目前所需的长度
		if (minCapacity > capacity) {
			// 如果给定了数组长度增量
			if (capacityIncrement > 0) {
				while (minCapacity > capacity) {
					// 不断的将capacity的长度增加，直到大于minCapacity
					capacity += capacityIncrement;
				}
			}
			// 若没有给定增量
			else {
				while (minCapacity > capacity) {
					// 不断的将capacity加倍，直到大于minCapacity
					capacity <<= 1;
				}
			}

			// 将原来的数组的长度变为新的capacity
			elementData = Arrays.copyOf(elementData, capacity);
		}
	}

	// 出栈
	public T pop() {

		// 若当前为空栈，则弹出null
		if (size == 0) {
			return null;
		}

		T oldValue = (T) elementData[size - 1];
		// 释放栈顶元素，同时将长度-1
		elementData[--size] = null;
		return oldValue;
	}

	// 获取栈顶元素
	public T getPeek() {

		// 若当前为空栈，则返回null
		if (size == 0) {
			return null;
		}
		return (T) elementData[size - 1];
	}

	// 判断是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 情况顺序栈
	public void clear() {
		Arrays.fill(elementData, null);
		size = 0;
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (int i = size - 1; i >= 0; i--) {
				sb.append(elementData[i].toString() + ", ");
			}

			sb.append("]");

			int length = sb.length();

			// 删除多余的“,”和空格
			return sb.delete(length - 3, length - 1).toString();
		}
	}
}
