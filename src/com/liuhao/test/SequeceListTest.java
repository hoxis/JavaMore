package com.liuhao.test;

import org.junit.Test;

import com.liuhao.algorithm.SequenceList;

public class SequeceListTest {

	@Test
	public void test() {
		SequenceList<String> sList = new SequenceList<String>();
		
		//添加元素
		sList.add("我");
		sList.add("is");
		sList.add("hehe");
		System.out.println(sList);
		
		//指定位置插入
		sList.insert("xxx", 3);
		System.out.println(sList);
		
		//指定位置删除
		sList.delete(2);
		System.out.println(sList);
		
		//获取元素位置
		System.out.println("“我”在其中的位置：" + sList.indexOf("我"));
		
		//清空
		sList.clear();
		System.out.println(sList);
	}

}
