package com.liuhao.algorithm;

public class DuLinkList<T> {

	/**
	 * 内部类：链表中的一个节点
	 * 
	 * @author liuhao data 节点中的数据 prev 指向前一个节点的引用 next 指向下一个节点的引用
	 */
	private class Node {

		private T data;// 保存的数据元素
		private Node prev;// 指向上一个节点
		private Node next;// 指向下一个节点

		public Node() {
		}

		public Node(T data, Node prev, Node next) {
			super();
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	private Node header;// 头结点
	private Node tail;// 尾节点
	private int size;// 链表中元素个数

	// 创建空链表
	public DuLinkList() {
		header = null;
		tail = null;
	}

	// 已指定数据元素创建链表，只有一个元素
	public DuLinkList(T element) {

		header = new Node(element, null, null);
		// 只有一个节点，header,tail都指向该节点
		tail = header;
		size++;
	}

	// 返回链表长度
	public int length() {
		return size;
	}

	// 获取指定位置的数据元素
	public T get(int index) {
		return this.getNodeByIndex(index).data;
	}

	// 获取指定位置的节点
	private Node getNodeByIndex(int index) {

		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("索引超出线性表范围");
		}

		if (index < size / 2) {
			Node current = header;
			for (int i = 0; i < size / 2 && current != null; i++, current = current.next) {
				if (i == index) {
					return current;
				}
			}
		} else {
			Node current = tail;
			for (int i = size - 1; i >= size / 2 && current != null; i--, current = current.prev) {
				if (i == index) {
					return current;
				}
			}
		}
		return null;
	}

	// 按值查询所在的位置
	public int locate(T element) {
		Node current = header;

		for (int i = 0; i < size - 1 && current != null; i++, current = current.next) {
			if (element.equals(current.data)) {
				return i;
			}
		}

		return -1;
	}

	// 向指定位置插入元素
	public void insert(T element, int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("索引超出线性表范围");
		}

		if (header == null) {
			this.add(element);
		} else {
			if (0 == index) {
				this.addAtHead(element);
			} else {
				Node prev = this.getNodeByIndex(index - 1);// 获取插入节点的前一个节点
				Node next = prev.next;// 待插索引处的节点
				Node newNode = new Node(element, prev, next);// 新增节点，让它的prev指向之前的节点。next指向之后的节点

				prev.next = newNode;// 之前的节点的next指向当前节点
				next.prev = newNode;// 之后节点的prev指向当前节点

				size++;
			}
		}
	}

	// 采用尾插法添加新节点
	public void add(T element) {

		// 若还是空表，则将header和tail都指向该元素即可
		if (header == null) {
			header = new Node(element, null, null);
			tail = header;
		} else {
			// 创建信节点，prev指向tail
			Node newNode = new Node(element, tail, null);
			// 令tail的next指向新节点
			tail.next = newNode;
			tail = newNode;// 把新节点设为尾节点
		}

		size++;
	}

	// 采用头插发添加新节点
	public void addAtHead(T element) {
		Node newNode = new Node(element, null, header);
		header.prev = newNode;
		header = newNode;

		// 如果插入之前是空表
		if (tail == null) {
			tail = header;
		}

		size++;
	}

	// 删除指定索引处的元素
	public T delete(int index) {

		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("索引超出线性表范围");
		}

		Node del = null;

		if (index == 0) {
			del = header;
			header = header.next;
			header.prev = null;
		} else {
			Node prev = this.getNodeByIndex(index - 1);// 获取索引处之前的节点
			del = prev.next;// 获取索引处的节点

			// 让之前的节点的next指向下一个节点
			prev.next = del.next;

			// 有可能删除的是最后一个元素，若直接调用next.prev可能会出错
			if (del.next != null) {
				del.next.prev = prev;
			}

			//若删除的是最后一个元素，那么就要重置tail;
			tail = prev;
			
			del.prev = null;
			del.next = null;

		}
		size--;
		return del.data;
	}

	// 删除最后一个元素
	public T remove() {
		return this.delete(size - 1);
	}

	// 判断是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 清空线性表
	public void clear() {
		header = null;
		tail = null;
		size = 0;
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (Node current = header; current != null; current = current.next) {
				sb.append(current.data.toString() + ", ");
			}
			sb.append("]");

			int len = sb.length();

			// 删除多余的“,”和空格
			return sb.delete(len - 3, len - 2).toString();
		}
	}
}
