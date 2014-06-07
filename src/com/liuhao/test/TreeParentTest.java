package com.liuhao.test;

import java.util.List;

import org.junit.Test;

import com.liuhao.DataStructures.TreeParent;
import com.liuhao.DataStructures.TreeParent.Node;

public class TreeParentTest {

	@Test
	public void test() {
		TreeParent<String> tree = new TreeParent<String>("root");
		Node<String> root = tree.getRoot();
		System.out.println("根节点：" + root);

		tree.addNode("节点1", root);
		tree.addNode("节点2", root);
		System.out.println("树的深度：" + tree.getDeep());

		List<Node<String>> nodes = tree.getChildren(root);
		System.out.println("根节点的第一个子节点：" + nodes.get(0));

		tree.addNode("节点3", nodes.get(0));
		System.out.println("树的深度：" + tree.getDeep());

		tree.removeChildren(root);
		System.out.println("根节点的第一个子节点：" + nodes.get(0));
		System.out.println("树的深度：" + tree.getDeep());
	}

}
