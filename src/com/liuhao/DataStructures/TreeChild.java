package com.liuhao.DataStructures;

import java.util.ArrayList;
import java.util.List;

public class TreeChild<E> {

	private static class ChildNode {
		private int pos;// 记录当前节点位置
		private ChildNode next;

		public ChildNode(int pos, ChildNode next) {
			this.pos = pos;
			this.next = next;
		}
	}

	public static class Node<T> {
		T data;
		ChildNode first;// 记录第一个子节点

		public Node() {
		}

		public Node(T data) {
			this.data = data;
			this.first = null;
		}

		public String toString() {
			if (first != null) {
				return "TreeChild$Node[data=" + data + ", first=" + first.pos
						+ "]";
			}
			return "TreeChild$Node[data=" + data + ", first=-1]";
		}
	}

	private final int DEFAULT_TREE_SIZE = 100;
	private int treeSize = 0;

	// 使用一个Node[]数组来记录该树的所有节点
	private Node<E>[] nodes;

	// 记录节点数
	private int nodeNums;

	// 以指定根节点创建树
	@SuppressWarnings("unchecked")
	public TreeChild(E data) {
		treeSize = DEFAULT_TREE_SIZE;
		nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data);
		nodeNums++;
	}

	// 以指定根节点、指定treeSize创建树
	@SuppressWarnings("unchecked")
	public TreeChild(E data, int treeSize) {
		this.treeSize = treeSize;
		this.nodes = new Node[treeSize];
		nodes[0] = new Node<E>(data);
		nodeNums++;
	}

	// 为指定节点添加子节点
	public void addNode(E data, Node<E> node) {
		for (int i = 0; i < treeSize; i++) {
			if (nodes[i] == null) {
				nodes[i] = new Node<E>(data);
				// 若该节点没有第一个子节点，那么就新建子节点链
				if (node.first == null) {
					node.first = new ChildNode(i, null);
				} else {
					// 若有，则依次取该节点的子节点，直到叶子节点
					ChildNode next = node.first;
					while (next.next != null) {
						next = next.next;
					}
					// 在叶子节点处添加该子节点
					next.next = new ChildNode(i, null);
				}
				nodeNums++;
				return;
			}
		}
		throw new RuntimeException("该树已满，无法添加新节点");
	}

	// 判断是否为空
	public boolean isEmpty() {
		// 跟节点是否为空
		return nodes[0] == null;
	}

	// 获取根节点
	public Node<E> getRoot() {
		return nodes[0];
	}

	// 获取指定节点的所有子节点
	public List<Node<E>> getChildren(Node<E> node) {
		List<Node<E>> list = new ArrayList<Node<E>>();
		// 获取给定节点的第一子节点
		ChildNode next = node.first;
		// 沿着孩子链不断搜索下一个孩子节点
		while (next != null) {
			// 添加孩子链中的节点
			list.add(nodes[next.pos]);
			next = next.next;
		}
		return list;
	}

	// 返回指定节点的第index个子节点
	public Node<E> getChildByIndex(Node<E> node, int index) {
		// 获取该节点的第一个子节点
		ChildNode next = node.first;
		// 沿着孩子链一直搜寻
		for (int i = 0; next != null; i++) {
			if (index == i) {
				return nodes[next.pos];
			}
			next = next.next;
		}
		return null;
	}

	// 递归的方式返回某个节点的深度
	private int getDeep(Node<E> node) {
		if (node.first == null) {
			return 1;
		} else {
			int max = 0;
			ChildNode next = node.first;
			while (next != null) {
				// 获取以其子节点为根的子树的深度
				int tmp = this.getDeep(nodes[next.pos]);
				if (tmp > max) {
					max = tmp;
				}
				next = next.next;
			}

			return max + 1;
		}
	}

	public int getDeep() {
		return this.getDeep(getRoot());
	}

	// 返回包含指定节点的索引
	public int pos(Node<E> node) {
		for (int i = 0; i < treeSize; i++) {
			if (nodes[i] == node) {
				return i;
			}
		}
		return -1;
	}

}
