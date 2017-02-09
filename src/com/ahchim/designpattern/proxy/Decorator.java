package com.ahchim.designpattern.proxy;

public class Decorator {
	// 1. ���� ���� ������ ����
	private static Decorator instance;
	
	// 2. ������ ����
	private Decorator(){}
	
	// 3. instance�� üũ�ؼ� �Ѱ��ش�
	public static Decorator getInstance(){
		if(instance ==  null){
			instance = new Decorator();
		}
		return instance;
	}
	
	// 4. �����Լ� getBbs ����
	public BbsExtend getBbs(int bbsno){
		BbsExtend bbs = Database.readBbsExtend(bbsno);
		// ���� �����͸� �����ͼ� ������ �� �Ѱ��ش�.
		
		bbs.setCount(bbs.getCount() + 1);
		bbs.setTitle("����: " + bbs.getTitle());
		return bbs;
	}
}
