package com.ahchim.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * �������� �����ϴ� ���μ���
 * 
 * @author Ahchim
 */
public class KakaoTalkServer {
	// ���������� �����صδ� �����
	List<Observer> observers = new ArrayList<>();
	
	// ������ ����ҿ� �������� �����ϴ� ����
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	// ��������� �߻����� �� �������鿡�� �����ϴ� �Լ�
	public void notification(String msg) {
		for(Observer observer : observers){
			observer.update(msg);
		}
	}
	
	// ��Ʃ��Ʈ�� ����ϴ� �޽��� ���� �Լ�
	public void sendMessage(String msg) {
		// �����ؾ� �ϴ� �޽����� �߻��ϸ� notification���� ��� ���������� �˸���.
		notification(msg);
	}
}
