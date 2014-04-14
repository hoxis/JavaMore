package com.liuhao.DataStructures;

public class LinkStack<T> {

	private class Node {
		private T data;// 保存节点的数据元素
		private Node next;// 保存下一个节点的引用

		public Node() {
		}

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node top;// 存放栈顶节点
	private int size = 0;// 存放栈中已有的元素个数

	// 创建空链栈
	public LinkStack() {
		top = null;
	}

	// 已指定数据元素创建链栈，只有一个元素
	public LinkStack(T element) {
		top = new Node(element, null);
		size++;
	}

	// 返回链栈的长度
	public int length() {
		return size;
	}

	// 进栈
	public void push(T elemnt) {
		// 让top指向新节点，新节点的next指向原来的top
		top = new Node(elemnt, top);
		size++;
	}

	// 出栈
	public T pop() {
		// 若当前为空栈，则返回null
		if (size == 0) {
			return null;
		}

		Node oldTop = top;
		// 让top指向原栈顶的下一个节点
		top = top.next;

		// 释放原栈顶元素的引用
		oldTop.next = null;
		size--;

		return oldTop.data;
	}

	// 获取栈顶元素
	public T getTop() {
		// 若当前为空栈，则返回null
		if (size == 0) {
			return null;
		}

		return top.data;
	}

	// 判断是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 清空栈
	public void clear() {
		top = null;
		size = 0;
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		}

		else {
			StringBuilder sb = new StringBuilder("[");

			for (Node current = top; current != null; current = current.next) {
				sb.append(current.data.toString() + ", ");
			}

			sb.append("]");

			int length = sb.length();

			return sb.delete(length - 3, length - 1).toString();
		}
	}
}
