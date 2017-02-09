package com.ahchim.designpattern.proxy;

/**
 * Proxy
 * 대행자로서 
 * 중간에 다른 기능 또는 요구사항을 처리한 후
 * 클라이언트 요청에 대한 원본데이터는 변형하지 않고 그대로 전달한다.
 * 
 * @author Ahchim
 *
 */
public class Proxy {
	// 1. 나를 담을 변수를 선언
	private static Proxy instance = null;
	
	// 2. 생성을 금지
	private Proxy(){}
	
	// 3. instance를 체크해서 넘겨준다.
	public static Proxy getInstance(){
		if(instance == null){
			instance = new Proxy();
		}
		return instance;
	}
	
	public Bbs getBbs(int bbsno){
		Bbs bbs = Database.readBbs(bbsno);	// 데이터베이스를 통해 가져온다는 가정...
		
		// 원본데이터는 변형하지 않고 조회수 또는 좋아요 수를 증가시켜준다.
		Visit visit = new Visit();
		visit.increase(bbsno);
		
		return bbs;
	}
}
