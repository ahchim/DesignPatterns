package com.ahchim.designpattern;

import com.ahchim.designpattern.factorymethod.FactoryMethod;
import com.ahchim.designpattern.factorymethod.Packed;
import com.ahchim.designpattern.factorymethod.Product;
import com.ahchim.designpattern.factorymethod.TVFactory;
import com.ahchim.designpattern.observer.KakaoTalkServer;
import com.ahchim.designpattern.observer.Student;
import com.ahchim.designpattern.proxy.Bbs;
import com.ahchim.designpattern.proxy.Proxy;
import com.ahchim.designpattern.singleton.Multiton;
import com.ahchim.designpattern.singleton.Singleton;
import com.ahchim.designpattern.strategy.Soldier;
import com.ahchim.designpattern.strategy.Strategy;
import com.ahchim.designpattern.strategy.StrategyGun;
import com.ahchim.designpattern.strategy.StrategySheild;
import com.ahchim.designpattern.strategy.StrategySword;
import com.ahchim.designpattern.templatemethod.Frog;
import com.ahchim.designpattern.templatemethod.Rabbit;
import com.ahchim.designpattern.templatemethod.TemplateMethod;

public class MainDesignPattern {
	public static void main(String[] args){
		// 1. �̱��� ���� ����� ����
		// ���յ�(������)�� ���߰� �������� ���̰�
		// new�� ���ϰ� �ϴ� ���� �ٽ�
		Singleton single1 = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
		
		System.out.printf("single1.name = %s, single2.name = %s\n", single1.getName(), single2.getName());
		single1.setName("�̾�ħ");
		System.out.printf("single1.name = %s, single2.name = %s\n", single1.getName(), single2.getName());
		
		System.out.println();
		
		// 2. ��Ƽ�� ���� ����� ����
		// �����Լ����� new�� �������� ���ϱ� ������ �����Լ����� ������ ����
		Multiton multi1 = Multiton.newInstance();
		Multiton multi2 = Multiton.newInstance();
		
		System.out.printf("multi1.name = %s, multi2.name = %s\n", multi1.getName(), multi2.getName());
		multi1.setName("���̾�ħ");
		System.out.printf("multi1.name = %s, multi2.name = %s\n", multi1.getName(), multi2.getName());
		
		System.out.println();
		
		// 3. �̱��Ͽ� newInstance() �Լ��� �߰��ϰ� ���� single3�� ������ �� single3.name�� ����غ�����.
		Singleton single3 = Singleton.newInstance();
		System.out.printf("single3.name = %s\n", single3.getName());
		
		System.out.println();
		
		// 4. ���Ͻ� ������ ����غ��ϴ�.
		Proxy proxy = Proxy.getInstance();
		Bbs bbs = proxy.getBbs(33);
		System.out.printf("no = %d | title = %s | content = %s\n", bbs.getNo(), bbs.getTitle(), bbs.getContent());
		
		System.out.println();
		
		// 5. ���ø� �޼��� ������ ����մϴ�.
		TemplateMethod frog = new Frog();
		frog.play();
		
		TemplateMethod rabbit = new Rabbit();
		rabbit.play();
		
		// 6. ���丮 �޼��� ������ ����մϴ�.
		FactoryMethod factory = new TVFactory();
		Product product = factory.make();
		Packed packed = factory.pack(product);
		
		
		
		// 7. ���������� ����մϴ�. Main�� Ŭ���̾�Ʈ
		Strategy strategy = null;
		Soldier context = new Soldier();
		
		context.status = Soldier.NEAR;
		
		// ���������� �����������̽��� ������ ����ü�� �����Ѵ�.
		if(context.status == Soldier.ATTACKED){
			strategy = new StrategySheild();
		} else if(context.status == Soldier.NEAR){
			strategy = new StrategySword();
		} else {
			strategy = new StrategyGun();
		}
		
		// ������ ���ؽ�Ʈ�� �Ѱܼ� ����Ѵ�
		context.useStrategy(strategy);
		
		// 7. ���� CallBack ������ ����մϴ�.
		// �������ϰ� �����ѵ� ������ü�� Ŭ���̾�Ʈ���� �͸�ü�� �����Ѵ�.
		Strategy strategy2 = null;
		Soldier context2 = new Soldier();
		
		context2.status = Soldier.ATTACKED;
		
		// ���� CallBack�� ����ü�� ������� �ʰ� �͸�ü�� �ڵ�󿡼� �������ش�.
		if(context2.status == Soldier.ATTACKED){
			context2.useStrategy(
				// �͸�ü��?
				// ������ ���� instance�� �����Ǵ� ���� ����Ų��.
				// �Ʒ��� ���� ������ �������� �ʰ� �ٷ� �ʱ�ȭ�� �� ������
				// �ʱ�ȭ�� �� �̿ܿ����� ����� �� ����.
				new Strategy(){
					@Override
					public void runStrategy() {
						useSheild();
						System.out.println("���´�~");
					}
					
					private void useSheild(){ // bothHands
						System.out.println("���и� ������� ���");
					}
			});
		} else if(context2.status == Soldier.NEAR){
			context2.useStrategy(new Strategy(){
				@Override
				public void runStrategy() {
					System.out.println("���~");
				}
			});
		} else {
			context2.useStrategy(new Strategy(){
				@Override
				public void runStrategy() {
					System.out.println("���~");
				}
			});
		}
		
		// 8. ������ ����ϱ�
		// 8.1 �������� ����ϱ� ���ؼ��� ������ ���� �����Ǿ�� �Ѵ�.
		// �������� �������� �������鿡�� ���������� ���� ����
		KakaoTalkServer server = new KakaoTalkServer();
		
		Student leeahchim = new Student(server, "�̾�ħ");
		// �ؿ�ó�� ���� �� �ƴ϶� �����ڷ� server�� �Ѱ��ָ� ����ɰŴ�.
		//server.addObserver(leeahchim);
		
		Student parksaesom = new Student(server, "�ڻ���");
		Student leeyounkyu = new Student(server, "������");
		
		parksaesom.addMessage("�����Դϴ�. 10�ñ��� Ƣ�������");
	}
}
