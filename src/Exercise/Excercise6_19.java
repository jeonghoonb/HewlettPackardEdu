package Exercise;

public class Excercise6_19 {
	public static void main(String[] args) {
		Account account = new Account();
		
		account.setBalnace(10000);
		System.out.println("현재 잔고 : "+account.getBalnace());
		
		account.setBalnace(-100);
		System.out.println("현재 잔고 : "+account.getBalnace());
		
		account.setBalnace(2000000);
		System.out.println("현재 잔고 : "+account.getBalnace());
		
		account.setBalnace(300000);
		System.out.println("현재 잔고 : "+account.getBalnace());
	}
}

class Account{
	private int balnace;
	final int MIN_BALANCE = 0;
	final int MAX_BALANCE = 1000000;

	public int getBalnace() {
		return balnace;
	}

	public void setBalnace(int balnace) {
		if(balnace > MIN_BALANCE && balnace < MAX_BALANCE) {
			this.balnace = balnace;
		}else System.out.print("(잔액 범위 오류 발생)");
	}
	
	
}