package com.ahchim.designpattern.proxy;

public class Database {
	public static Bbs readBbs(int bbsno){
		Bbs bbs = new Bbs();
		// �����͸� ������ �Ŀ� ������ �ش�.
		// ����...
		bbs.setNo(bbsno);
		bbs.setTitle("������" + bbsno);
		bbs.setContent("�����Դϴ�" + bbsno);
		
		return bbs;
	}
	
	public static void increaseVisit(int bbsno){
		// Visit �����ʹ� ���� Bbs�� ������ �����Ѵ�.
	}

	public static BbsExtend readBbsExtend(int bbsno) {
		BbsExtend bbs = new BbsExtend();
		// �����͸� ������ �Ŀ� ������ �ش�.
		// ����...
		bbs.setNo(bbsno);
		bbs.setTitle("������" + bbsno);
		bbs.setContent("�����Դϴ�" + bbsno);
		
		return bbs;
	}
}
