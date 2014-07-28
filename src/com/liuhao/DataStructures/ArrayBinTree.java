package com.liuhao.DataStructures;

import java.util.Arrays;

public class ArrayBinTree<T> {

	// 使用数组来记录所有节点
	private Object[] datas;
	private final int DEFAULT_DEEP = 8;
	// 保存该树的深度
	private int deep;
	// 数组的长度
	private int arraySize;

	// 以默认深度创建二叉树
	public ArrayBinTree() {
		this.deep = DEFAULT_DEEP;
		this.arraySize = (int) Math.pow(2, deep);
		datas = new Object[arraySize];
	}

	// 以指定深度创建
	public ArrayBinTree(int deep) {
		this.deep = deep;
		this.arraySize = (int) Math.pow(2, deep);
		datas = new Object[arraySize];
	}

	// 以指定深度，指定根节点创建
	public ArrayBinTree(int deep, T data) {
		this.deep = deep;
		this.arraySize = (int) Math.pow(2, deep);
		datas = new Object[arraySize];
		datas[0] = data;
	}

	/**
	 * 为指定节点添加子节点
	 * 
	 * @param index
	 *            需要添加子节点的父节点索引
	 * @param data
	 *            新的子节点的数据
	 * @param left
	 *            是否为左节点
	 */
	public void add(int index, T data, boolean left) {
		if (datas[index] == null) {
			throw new RuntimeException(index + "处节点为空，无法添加子节点！");
		}

		if (2 * index + 1 > arraySize || 2 * index + 2 > arraySize) {
			throw new RuntimeException("树底层数组已满");
		}

		if (left) {
			if (datas[2 * index + 1] == null) {
				datas[2 * index + 1] = data;
			} else {
				throw new RuntimeException("该节点已存在！");
			}
		} else {
			if (datas[2 * index + 2] == null) {
				datas[2 * index + 2] = data;
			} else {
				throw new RuntimeException("该节点已存在！");
			}
		}
	}

	// 判断二叉树是否为空
	public boolean isEmpty() {
		return datas[0] == null;
	}

	// 获取根节点
	public T getRoot() {
		return (T) datas[0];
	}

	// 返回指定节点的父节点
	public T getParent(int index) {
		if (index == 0) {
			throw new RuntimeException("根节点不存在父节点！");
		}

		return (T) datas[(index - 1) / 2];
	}
	
	//获取右子节点
	public T getRight(int index){
		if (2 * index + 1 > arraySize || 2 * index + 2 > arraySize) {
			throw new RuntimeException("该节点不存在右子节点！");
		}
		
		return (T) datas[index * 2 + 2];
	}
	
	//获取左子节点
	public T getLeft(int index){
		if (2 * index + 1 > arraySize || 2 * index + 2 > arraySize) {
			throw new RuntimeException("该节点不存在左子节点！");
		}
		
		return (T) datas[index * 2 + 1];
	}
	
	//返回该二叉树的深度
	public int getDeep(){
		return deep;
	}
	
	//返回指定数据的位置
	public int getPos(T data){
		for(int i=0;i<arraySize;i++){
			if(datas[i].equals(data)){
				return i;
			}
		}
		
		return -1;
	}
	
	public String toString(){
		return Arrays.toString(datas);
	}

}
