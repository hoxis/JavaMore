package com.liuhao.DataStructures;

import java.util.Arrays;

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

	// 以一个初始化元素创建顺序线性表
	public SequenceList(T element) {
		this();
		elementData[0] = element;
		size++;
	}

	/**
	 * 以指定长度来创建
	 * 
	 * @param element
	 *            指定的第一个元素
	 * @param initSize
	 *            指定的长度
	 */
	public SequenceList(T element, int initSize) {
		capacity = 1;

		// 把capacity设为大于initSize的最小的2的n次方
		while (capacity < initSize) {
			capacity <<= 1;
		}

		elementData = new Object[capacity];
		elementData[0] = element;
		size++;
	}

	// 获取线性表的大小
	public int length() {
		return size;
	}

	// 获取索引处i的元素
	public T get(int i) {
		if (i < 0 || i > size - 1) {
			throw new IndexOutOfBoundsException("索引超出线性表范围");
		}

		return (T) elementData[i];
	}

	// 根据元素查找在线性表中的位置
	public int indexOf(T element) {
		for (int i = 0; i < size; i++) {
			if (elementData[i].equals(element)) {
				return i;
			}
		}

		return -1;
	}

	// 向顺序表中的指定位置插入元素
	public void insert(T element, int index) {
		
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("索引超出线性表范围");
		}
		
		ensureCapacity(size + 1);
		
		//将指定索引处之后的所有元素往后移
		System.arraycopy(elementData, index, elementData, index+1, size-index);
		
		elementData[index] = element;
		
		size++;

	}
	
	//在线性表的末端添加一个元素
	public void add(T element){
		insert(element, size);
	}

	private void ensureCapacity(int minCapacity) {

		// 如果数组的原有长度小于目前所需的长度
		if (minCapacity > capacity) {

			// 不断的将capacity*2,直到capacity 大于minCapacity
			while (capacity < minCapacity) {
				capacity <<= 1;
			}

			elementData = Arrays.copyOf(elementData, capacity);
		}
	}
	
	//删除指定索引处的元素
	public T delete(int index){
		if(index < 0 || index > size-1){
			throw new IndexOutOfBoundsException("索引超出线性表范围");
		}
		
		T oldValue = (T) elementData[index];
		
		int numMoved = size - index - 1;
		if(numMoved > 0){
			System.arraycopy(elementData, index+1, elementData, index, numMoved);
		}
		
		elementData[--size] = null;
		
		return oldValue;
	}
	
	//删除最后一个元素
	public T remove(){
		return delete(size-1);
	}
	
	//盘对线性表是否为空
	public boolean isEmpty(){
		return size == 0;
	}
	
	//清空线性表
	public void clear(){
		//将所有元素置为null
		Arrays.fill(elementData, null);
		size = 0;
	}
	
	public String toString(){
		if(size == 0){
			return "[]";
		}
		else{
			StringBuilder sb = new StringBuilder("[");
			
			for(int i=0;i<size;i++){
				sb.append(elementData[i].toString() + ", ");
			}
			
			int len = sb.length();
			
			return sb.delete(len-2, len).append("]").toString();
		}
	}
}
