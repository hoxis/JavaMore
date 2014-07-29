package com.liuhao.DataStructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ThreeLinkBinTree<E> {

	public static class TreeNode{
		Object data;
		TreeNode parent;
		TreeNode left;
		TreeNode right;
		
		public TreeNode() {
		}
		
		public TreeNode(Object data) {
			this.data = data;
		}

		public TreeNode(Object data, TreeNode parent, TreeNode left,
				TreeNode right) {
			this.data = data;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
	}
	
	private TreeNode root;
	
	public ThreeLinkBinTree(){
		this.root = new TreeNode();
	}
	
	//以指定元素创建
	public ThreeLinkBinTree(E data){
		this.root = new TreeNode(data);
	}
	
	/**
	 * 为指定节点添加子节点
	 * @param parent 待添加的节点 
	 * @param data 添加子节点的数据
	 * @param isLeft 是否要添加左子节点
	 * @return 新增的节点
	 */
	public TreeNode addNode(TreeNode parent, E data, boolean isLeft){
		if(parent == null){
			throw new RuntimeException(parent + "节点为空，不能添加子节点！");
		}
		
		if(isLeft && parent.left != null){
			throw new RuntimeException(parent + "节点已有左子节点，不能添加左子节点！");
		}
		
		if(!isLeft && parent.right != null){
			throw new RuntimeException(parent + "节点已有右子节点，不能添加右子节点！");
		}
		
		TreeNode newNode = new TreeNode(data);
		if(isLeft){
			parent.left = newNode;
		}else{
			parent.right = newNode;
		}
		
		//让新节点的parent引用指向parent节点
		newNode.parent = parent;
		return newNode;
	}
	
	//判断二叉树是否为空
	public boolean isEmpty(){
		return root.data == null;
	}
	
	//获取根节点
	public TreeNode getRoot(){
		if(isEmpty()){
			throw new RuntimeException("树为空，无法获取根节点！");
		}
	return root;
	}
	
	//获取指定节点的父节点
	public TreeNode getParent(TreeNode node){
		if(node == null){
			throw new RuntimeException("节点为空，无法获取父节点！");
		}
		
		if(root == node){
			throw new RuntimeException("根节点无法获取父节点！");
		}
		
		return node.parent;
	}
	
	//获取指定节点的左子节点
	public TreeNode getLeft(TreeNode parent){
		if(parent == null){
			throw new RuntimeException(parent + "节点为空，不能获取子节点！");
		}
		
		return parent.left == null ? null : parent.left;
	}
	
	//获取指定节点的右子节点
	public TreeNode getRight(TreeNode parent){
		if(parent == null){
			throw new RuntimeException(parent + "节点为空，不能获取子节点！");
		}
		
		return parent.right == null ? null : parent.right;
	}
	
	//获取指定节点的深度
	private int getDeep(TreeNode node){
		if(node == null){
			return 0;
		}
		
		if(node.left == null && node.right == null){
			return 1;
		}else{
			int leftDeep = getDeep(node.left);
			int rightDeep = getDeep(node.right);
			
			int max = leftDeep > rightDeep ? leftDeep : rightDeep;
			return max + 1;
		}
	}
	
	public int getTreeDeep(){
		return this.getDeep(root);
	}
	
	//实现先序遍历
	public List<TreeNode> preIterator(){
		return preIterator(root);
	}

	private List<TreeNode> preIterator(TreeNode node) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		//处理根节点
		list.add(node);
		
		//递归处理左子树
		if(node.left != null){
			list.addAll(preIterator(node.left));
		}
		
		//递归处理右子树
		if(node.right != null){
			list.addAll(preIterator(node.right));
		}
		
		return list;
	}
	
	public List<TreeNode> inIterator(){
		return inIterator(root);
	}
	
	private List<TreeNode> inIterator(TreeNode node){
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		//递归处理左子树
		if(node.left != null){
			list.addAll(inIterator(node.left));
		}
		
		//处理根节点
		list.add(node);
		
		//递归处理右子树
		if(node.right != null){
			list.addAll(inIterator(node.right));
		}
		
		return list;
	}
	
	public List<TreeNode> postIterator(){
		return postIterator(root);
	}
	
	private List<TreeNode> postIterator(TreeNode node){
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		//递归处理左子树
		if(node.left != null){
			list.addAll(postIterator(node.left));
		}
		
		//递归处理右子树
		if(node.right != null){
			list.addAll(postIterator(node.right));
		}
		
		//处理根节点
		list.add(node);
		
		return list;
	}
	
	public List<TreeNode> breadthFirst(){
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		if(root != null){
			//将根元素加入到“队列”
			queue.offer(root);
		}
		
		while(!queue.isEmpty()){
			//将该队列的“队尾”的元素添加到List中
			list.add(queue.peek());
			TreeNode p = queue.poll();
			//如果左子节点不为null，将它加入到“队列”
			if(p.left != null){
				queue.offer(p.left);
			}
			
			if(p.right != null){
				queue.offer(p.right);
			}
		}
		
		return list;
	}
	
}
