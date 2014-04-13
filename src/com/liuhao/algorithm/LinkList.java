package com.liuhao.algorithm;

public class LinkList<T> {

	// 定义一个内部类Node，代表链表的节点
	private class Node {

		private T data;// 保存数据
		private Node next;// 指向下个节点的引用

		//无参构造器
		public Node(){}
		
		//初始化全部属性的构造器
		public Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node header;//保存头结点
	private Node tail;//保存尾节点
	private int size;//保存已含有的节点数
	
	//创建空链表
	public LinkList(){
		header = null;
		tail = null;
	}
	
	//已指定数据元素创建链表，只有一个元素
	public LinkList(T element){
		
		header = new Node(element, null);
		//只有一个节点，header,tail都指向该节点
		tail = header;
		size++;
	}

}
