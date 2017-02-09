package com.ahchim.designpattern.proxy;

public class Database {
	public static Bbs readBbs(int bbsno){
		Bbs bbs = new Bbs();
		// 데이터를 세팅한 후에 리턴해 준다.
		// 로직...
		bbs.setNo(bbsno);
		bbs.setTitle("글제목" + bbsno);
		bbs.setContent("내용입니다" + bbsno);
		
		return bbs;
	}
	
	public static void increaseVisit(int bbsno){
		// Visit 데이터는 현재 Bbs와 별개로 존재한다.
	}

	public static BbsExtend readBbsExtend(int bbsno) {
		BbsExtend bbs = new BbsExtend();
		// 데이터를 세팅한 후에 리턴해 준다.
		// 로직...
		bbs.setNo(bbsno);
		bbs.setTitle("글제목" + bbsno);
		bbs.setContent("내용입니다" + bbsno);
		
		return bbs;
	}
}
