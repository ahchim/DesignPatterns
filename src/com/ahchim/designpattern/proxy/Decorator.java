package com.ahchim.designpattern.proxy;

public class Decorator {
	// 1. 나를 담을 변수를 선언
	private static Decorator instance;
	
	// 2. 생성을 금지
	private Decorator(){}
	
	// 3. instance를 체크해서 넘겨준다
	public static Decorator getInstance(){
		if(instance ==  null){
			instance = new Decorator();
		}
		return instance;
	}
	
	// 4. 대행함수 getBbs 구현
	public BbsExtend getBbs(int bbsno){
		BbsExtend bbs = Database.readBbsExtend(bbsno);
		// 원본 데이터를 가져와서 가공한 후 넘겨준다.
		
		bbs.setCount(bbs.getCount() + 1);
		bbs.setTitle("제목: " + bbs.getTitle());
		return bbs;
	}
}
