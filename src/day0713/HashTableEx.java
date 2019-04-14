package day0713;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableEx {

	public static void main(String[] args) {
		
		Map<String, String> map = new Hashtable<String, String>();
		
		//HashTable에 삽입
		map.put("spring","12");
		map.put("summer","123");
		map.put("fall","1234");
		map.put("winter","12345");
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("아이디와 비밀번호를 입력해주세요.");
			System.out.print("아이디 : ");
			String id = scanner.nextLine();
			
			System.out.print("비밀번호 : ");
			String password = scanner.nextLine();
			System.out.println();
			
			if(map.containsKey(id)) { //입력한 id가 map에 포함되어 있으면
				if(map.get(id).equals(password)) { //id에대한 데이터, 즉 password 비교
					System.out.println("=>로그인 되었습니다.");
					break;
				}else {
					System.out.println("=> 비밀번호가 일치하지 않습니다.\n");
				}
			}else {
				System.out.println("=>입력하신 아이디가 존재하지 않습니다.\n");
			}
		}
	}
}
