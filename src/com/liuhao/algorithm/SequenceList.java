package com.liuhao.algorithm;

public class SequenceList<T> {
	private final int DEFAULT_SIZE = 16;

	private int capacity;// 保存数组的长度

	private Object[] elementData; // 定义一个数组，用于保存顺序线性表

	private int size = 0;// 保存顺序线性表中当前元素的个数

	// 以默认长度创建空的线性表
	public SequenceList() {
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}

	//以一个初始化元素创建顺序线性表
	public SequenceList(T element) {
		this();
		elementData[0] = element;
		size++;
	}
	
	/**
	 * 以指定长度来创建
	 * @param element 指定的第一个元素
	 * @param initSize 指定的长度
	 */
	public SequenceList(T element ,int initSize){
		capacity = 1;
		
		//把capacity设为大于initSize的最小的2的n次方
		while(capacity < initSize){
			capacity <<= 1;
		}
		
		elementData = new Object[capacity];
		elementData[0] = element;
		size++;
	}

}
