package com.liuhao.DataStructures;

import java.util.Arrays;

public class SequenceQueue<T> {

	private final int DEFAULT_SIZE = 16;
	private int capacity;// 保存数组的长度

	private Object[] elementData; // 定义一个数组，用于保存顺序队列饿的数据元素

	private int front = 0;

	private int rear = 0;

	// 以默认长度创建空队列
	public SequenceQueue() {
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}

	// 以一个初始化元素创建顺序队列
	public SequenceQueue(T element) {
		this();
		elementData[0] = element;
		rear++;
	}

	/**
	 * 以指定长度来创建
	 * 
	 * @param element
	 *            指定的第一个元素
	 * @param initSize
	 *            指定的长度
	 */
	public SequenceQueue(T element, int initSize) {
		capacity = initSize;
		elementData = new Object[capacity];
		elementData[0] = element;
		rear++;
	}

	// 获取队列大小
	public int length() {
		return rear - front;
	}

	// 插入元素
	public void add(T element) {
		//若队列已满，此时没有进行底层数组的长度自增，抛出异常
		if (rear >= capacity) {
			throw new IndexOutOfBoundsException("队列已满");
		}

		elementData[rear++] = element;
	}

	// 删除元素
	public T remove() {
		if (this.isEmpty()) {
			return null;
		}

		// 保留front处的元素
		T oldValue = (T) elementData[front];

		// 释放队列front的元素
		elementData[front++] = null;

		return oldValue;
	}

	// 返回栈顶元素
	public T getPeek() {
		if (this.isEmpty()) {
			return null;
		}

		return (T) elementData[front];
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	// 清空队列
	public void clear() {
		Arrays.fill(elementData, null);
		front = 0;
		rear = 0;
	}

	public String toString() {
		if (this.isEmpty()) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (int i = front; i < rear; i++) {
				sb.append(elementData[i].toString() + ", ");
			}

			int length = sb.length();
			return sb.delete(length - 2, length).append("]").toString();
		}
	}
}
