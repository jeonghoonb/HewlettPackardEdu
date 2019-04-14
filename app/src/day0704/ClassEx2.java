package day0704;

import java.util.Scanner;

public class ClassEx2 {
	public static void main(String[] args) {
		
		Car car = new Car();
		Scanner scanner = new Scanner(System.in);
		car.printInfo();
		boolean run = true;
		
		while(run) {
			System.out.println("\n-------------------------------");
			System.out.println("0.�õ� �ɱ� | 1.���� ���� | 2. �ӵ� ���� | 3.�ӵ� ���� | 4.���� ���� | 5.����");
			System.out.println("-------------------------------");
			System.out.print("����> ");
			
			int selectNo = scanner.nextInt();
			
			switch (selectNo) {
			case 0:
				boolean powerOn = false;
				while(!powerOn) {
					int a = (int)(Math.random()*2)+1;
					if(a==1) {
						powerOn = true;
						System.out.println("�õ� �ɱ� ����.");
						break;
					}else {
						System.out.println("�õ� �ɱ� ����");
						break;
					}
				}
				break;
			case 1:
				String [] color = {"������", "���", "�����", "������", "�Ķ���"};
				int a = (int)(Math.random()*5)+1;
				car.setColor(color[a]);
				break;
			case 2:
				car.upSpeed();
				break;
			case 3:
				car.downSpeed();
				break;
			case 4:
				car.printInfo();
				break;
			default:
				run=false;
				break;
			}
		}		
	}
}

class Car {
	String model = "��Ÿ��";
	String company = "�����ڵ���";
	String color = "���";
	int maxSpeed = 360;
	int speed = 0;
	
	public void setColor(String color) {
		this.color = color;
		System.out.println("\n������ "+color+"�� ����Ǿ����ϴ�.");
	}
	
	public void upSpeed() {
		this.speed +=10;
		System.out.println("���� �ӵ��� "+speed+"km/h");
	}
	
	public void downSpeed() {
		this.speed -=10;
		System.out.println("���� �ӵ��� "+speed+"km/h");
	}
	
	public void printInfo() {
		System.out.println("<���� ����>\nModel : "+model+" / Company : "+company+" \nColor : "+color+" / �ְ� �ӵ� : "+maxSpeed+" / ���� �ӵ� : "+speed+"km/h");
	}
}
