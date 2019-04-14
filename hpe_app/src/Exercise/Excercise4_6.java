package Exercise;

public class Excercise4_6 {
	public static void main(String[] args) {
		
		for(int i=0; i<5; i++) {
			for(int j = 0; j<=i; j++) {
				System.out.print("*");
			}System.out.println();
		}System.out.println("================");
		
		
		for(int i=5; i>0; i--) {
			for(int j=i; j>0; j--) {
				System.out.print("*");
			}System.out.println();
		}System.out.println("================");
		
		
		for(int i = 5; i>0; i--) {
			for(int j=4; j>0; j--) {
				System.out.print(" ");
				if((i+j)==6) {
					for(int k = 0; k<j; k++) {
						System.out.print("*");
					}	
				}
				
			}System.out.println();
		}
		
		
		
	}
}
