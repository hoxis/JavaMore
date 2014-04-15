package com.liuhao.test;

import org.junit.Test;

import com.liuhao.DataStructures.SequenceQueue;

public class SequenceQueueTest {

	@Test
	public void test() {

		System.out.println("------------以指定长度构建顺序队列--------------");
		// 以指定长度初始化顺序队列
		SequenceQueue<String> sq = new SequenceQueue<String>("今天", 6);
		System.out.println(sq);
		// 当前队列长度
		System.out.println("当前队列长度:" + sq.length());
		// 当前是否为空
		System.out.println("当前是否为空:" + sq.isEmpty());

		System.out.println("------------添加元素--------------");

		// 添加元素
		sq.add("是");
		sq.add("个");
		sq.add("好日志");
		System.out.println(sq);
		System.out.println("当前队列长度:" + sq.length());
		System.out.println("当前是否为空:" + sq.isEmpty());

		System.out.println("-----------删除元素---------------");

		// 删除元素
		sq.remove();
		System.out.println(sq);
		System.out.println("当前队列长度:" + sq.length());
		System.out.println("当前是否为空:" + sq.isEmpty());

		System.out.println("-----------继续添加-假满现象--------------");

		// 继续添加元素
		sq.add("好吧");
		sq.add("ni");
		System.out.println(sq);
		System.out.println("当前队列长度:" + sq.length());
		System.out.println("当前是否为空:" + sq.isEmpty());

		System.out.println("-----------假满现象---------------");

		// 再添加会出现假满现象
		sq.add("啊啊啊啊");

	}

}
