package day0712;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateTimeParsingEx {
	public static void main(String[] args) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		LocalDateTime dateTime = LocalDateTime.of(1986, Month.APRIL, 8, 12, 30);
		String formattedDateTime = dateTime.format(formatter);
		
		System.out.println(formattedDateTime);
		
		formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH/mm");
		dateTime = LocalDateTime.of(1986, Month.APRIL,8,12,30);
		formattedDateTime = dateTime.format(formatter);
		System.out.println(formattedDateTime);

		formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm");
		dateTime = LocalDateTime.of(1986, Month.APRIL,8,12,30);
		formattedDateTime = dateTime.format(formatter);
		System.out.println(formattedDateTime);
		
		
	}
}
