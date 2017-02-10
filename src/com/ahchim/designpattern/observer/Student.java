package com.ahchim.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Student implements Observer {
	// �޽����� �����ϴ� �����
	List<String> messages = new ArrayList<>();
	
	KakaoTalkServer server;
	String name = "";

	public Student(KakaoTalkServer server, String name) {
		this.server = server;
		this.name = name;
		server.addObserver(this);
		// ��Ʈ��ũ�󿡼��� this�� ���� �Ѱ��ְ� �̷� �� ��������..
	}

	@Override
	public void update(String msg) {
		messages.add(msg);
		showMessage();
	}
	
	// Ÿ������ ���� �ԷµǴ� �޽���
	public void addMessage(String msg) {
		server.sendMessage(msg);
	}
	
	public void showMessage() {
		System.out.println(name + "���� �� �޽���: " + messages.get(messages.size()-1));
	}
}
