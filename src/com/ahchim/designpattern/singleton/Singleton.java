package com.ahchim.designpattern.singleton;

/**
 * Singleton
 * �̱��� ������ �ڿ��� �����ϱ� ���� �������� ����Ѵ�.
 * Multi Thread ȯ�濡���� �Ʒ� ������ ����ȭ�� �߰��ؾ� �Ѵ�.
 * 
 * @author Ahchim
 */
public class Singleton {
	// �̱��� �ڽ��� ��Ƶδ� ��������
	private static Singleton instance = null;
	private String name = "";
	
	// �⺻ �����ڸ� new�� ���� ������ �� ���� private�� ���Ƶд�.
	private Singleton(){ }
	
	public static Singleton getInstance(){
		// 1. instance ������ ���� �ִ����� üũ�ϰ� ������ �����Ѵ�.
		//	    �����ڰ� private������ ���� class�ȿ� �ֱ� ������ new�� �� �� �ִ�.
		if(instance == null){
			instance = new Singleton();
		}
		// 2. instance�� �����Ѵ�.
		return instance;
	}
	
	public static Singleton newInstance(){
		return new Singleton();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
