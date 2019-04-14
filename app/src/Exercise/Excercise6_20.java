package Exercise;

import java.util.Scanner;

public class Excercise6_20 {
	private static Account2[] accountArray = new Account2[100];
	private static Scanner scanner = new Scanner(System.in);
	private static int index = 0;

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("==============================");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("==============================");
			System.out.print("선택>");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}

	private static void createAccount() {
		System.out.println("----------");
		System.out.println("계좌생성");
		System.out.println("----------");
		System.out.print("계좌번호 : ");
		String ano = scanner.next();
		System.out.print("계좌주 : ");
		String owner = scanner.next();
		System.out.print("초기입금액 : ");
		int balance = scanner.nextInt();

		accountArray[index] = new Account2(ano, owner, balance);
		System.out.println("결과 : 계좌가 생성되었습니다.");
		index++;
	}

	private static void accountList() {
		System.out.println("----------");
		System.out.println("계좌목록");
		System.out.println("----------");

		for (int i = 0; i < index; i++) {
			System.out.println(accountArray[i].getAno() + "  " + accountArray[i].getOwner() + "  "
					+ accountArray[i].getBalance() + "원");
		}

	}

	private static void deposit() {
		System.out.print("계좌번호 : ");
		Account2 account2 = findAccount(scanner.next());
		System.out.print("예금액 : ");
		int tmp = scanner.nextInt();
		account2.setBalance((tmp + account2.getBalance()));
		System.out.println("결과 : " + tmp + "원 예금 성공");
	}

	private static void withdraw() {
		System.out.print("계좌번호 : ");
		Account2 account2 = findAccount(scanner.next());
		System.out.print("출금액 : ");
		int tmp = scanner.nextInt();
		account2.setBalance((account2.getBalance() - tmp));
		System.out.println("결과 : " + tmp + "원 출금 성공");
	}

	private static Account2 findAccount(String ano) {
		Account2 account2 = null;
		for (int i = 0; i < index; i++) {
			if (accountArray[i].getAno().equals(ano)) {
				account2 = accountArray[i];
				return account2;
			}
		}
		System.out.println("<계좌번호 오류> 계좌번호를 다시 입력하세요.");

		withdraw();
		return account2;
	}
}

class Account2 {
	private String ano;
	private String owner;
	private int balance;

	public Account2(String ano, String owner, int balance) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}