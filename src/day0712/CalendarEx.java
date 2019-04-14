package day0712;

import java.util.Calendar;

public class CalendarEx {
	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance(); // singleton 디자인 패턴
		int year = cal.get(Calendar.YEAR); // 현재 년도
		int month = (cal.get(Calendar.MONTH)) + 1; // 현재 월 (0이 1월)
		int date = cal.get(Calendar.DATE); // 현재 일
		int hour = (12 + cal.get(Calendar.HOUR));
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		// System.out.print("년 : "+year+" ");
		// System.out.print("월 : "+month+" ");
		// System.out.print("일 : "+date+"\n");
		// System.out.print("시 : "+hour+" ");
		// System.out.print("분 : "+minute+" ");
		// System.out.print("초 : "+second+"\n");

		int day1 = cal.get(Calendar.DAY_OF_YEAR); // 1년 중 몇번째 일
		int day2 = cal.get(Calendar.DAY_OF_MONTH); // 1달 중 몇번째 일
		int day3 = cal.get(Calendar.DAY_OF_WEEK); // 1주 중 몇번째 일
		int week = cal.get(Calendar.WEEK_OF_YEAR); // 1년 중 몇번째 주

		// System.out.println("오늘은 올해의 : "+day1+"날 입니다.");
		// System.out.println("오늘은 이번달: "+day2+"일 입니다.");
		// System.out.println("오늘은 이번주 : "+day3+"요일 입니다.");
		// System.out.println("오늘은 올해의 : "+week+"주 입니다.");
		//
		// String[] yoil = {"일","월","화","수","목","금","토"};
		//
		// System.out.println("오늘은 요일은 : "+yoil[day3-1]+"요일 입니다.");

		// 달력 만들기
		// cal.set(year, month, date);
		// System.out.println("일\t월\t화\t수\t목\t금\t토");

		year = 2017;
		month = 6;

		cal.set(year, month - 1, 1); // Calendar 설정(기본은 현재 로컬 시간), 0이 1월이기에 month-1
		int startDay = cal.get(Calendar.DAY_OF_WEEK); // 해당 달력의 1일이 어느 요일인지 (1~7 사이 값)

		int lastDay = cal.getActualMaximum(Calendar.DATE); // 해당 월이 총 몇일인지

		System.out.println("\t\t< " + year + "년  " + month + "월 >\t\n");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for (int i = 1; i < lastDay + startDay; i++) { // 1일 앞의 공백까지 반복문
			if (i < startDay) { // 1일 앞은 이전달로 공백 처리
				System.out.print("\t");
				continue; // 계속 진행
			}
			System.out.print((i - startDay + 1) + "\t"); // 6-6+1 해서 1일부터 출력
			if (i % 7 == 0) {
				System.out.println();
			}
		}
	}
}
