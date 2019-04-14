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
			System.out.println("0.시동 걸기 | 1.색상 변경 | 2. 속도 증가 | 3.속도 감소 | 4.차량 정보 | 5.종료");
			System.out.println("-------------------------------");
			System.out.print("선택> ");
			
			int selectNo = scanner.nextInt();
			
			switch (selectNo) {
			case 0:
				boolean powerOn = false;
				while(!powerOn) {
					int a = (int)(Math.random()*2)+1;
					if(a==1) {
						powerOn = true;
						System.out.println("시동 걸기 성공.");
						break;
					}else {
						System.out.println("시동 걸기 실패");
						break;
					}
				}
				break;
			case 1:
				String [] color = {"검정색", "흰색", "노란색", "빨간색", "파랑색"};
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
	String model = "싼타페";
	String company = "현대자동차";
	String color = "흰색";
	int maxSpeed = 360;
	int speed = 0;
	
	public void setColor(String color) {
		this.color = color;
		System.out.println("\n색상이 "+color+"로 변경되었습니다.");
	}
	
	public void upSpeed() {
		this.speed +=10;
		System.out.println("현재 속도는 "+speed+"km/h");
	}
	
	public void downSpeed() {
		this.speed -=10;
		System.out.println("현재 속도는 "+speed+"km/h");
	}
	
	public void printInfo() {
		System.out.println("<차량 정보>\nModel : "+model+" / Company : "+company+" \nColor : "+color+" / 최고 속도 : "+maxSpeed+" / 현재 속도 : "+speed+"km/h");
	}
}
