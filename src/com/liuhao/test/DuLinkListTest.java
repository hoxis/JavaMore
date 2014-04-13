package com.liuhao.test;

import org.junit.Test;

import com.liuhao.algorithm.DuLinkList;

public class DuLinkListTest {

	@Test
	public void test() {
		
		//测试构造函数
		DuLinkList<String> duList = new DuLinkList("好");
		System.out.println(duList);
		
		//测试添加元素
		duList.add("ni");
		duList.add("没");
		System.out.println(duList);
		
		//在头部添加
		duList.addAtHead("五月");
		System.out.println(duList);
		
		//在指定位置添加
		duList.insert("摩卡", 2);
		System.out.println(duList);
		
		//获取指定位置处的元素
		System.out.println("第2个元素是（从0开始计数）：" + duList.get(2));
		
		//返回元素索引
		System.out.println("摩卡在的位置是：" + duList.locate("摩卡"));
		System.out.println("moka所在的位置：" + duList.locate("moka"));
		
		//获取长度
		System.out.println("当前线性表的长度：" + duList.length());
		
		//判断是否为空
		System.out.println(duList.isEmpty());
		
		//删除最后一个元素
		duList.remove();
		System.out.println("调用remove()后：" + duList);
		
		//获取长度
		System.out.println("当前线性表的长度：" + duList.length());
		
		//删除指定位置处元素
		duList.delete(3);
		System.out.println("删除第4个元素后：" + duList);
		
		//获取长度
		System.out.println("当前线性表的长度：" + duList.length());
		
		//清空
		duList.clear();
		System.out.println(duList);
		
		//判断是否为空
		System.out.println(duList.isEmpty());
	}

}
