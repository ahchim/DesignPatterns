package com.ahchim.designpattern.proxy;

public class Visit {
	int no;
	int count = 0;
	
	public int getCount(){
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

	public void increase(int bbsno) {
		no = bbsno;
		count = count + 1;
		// 뒤에 로직 또 있음...
	}
}
