package day0718;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOEx6 {

	public static void main(String[] args) throws IOException {
		FileOutputStream fw = new FileOutputStream(new File("C:/Users/odae/workspace/app/src/day0718/IOEx5_sample.txt"));
		
		System.out.println("입력");
		int abc = 0;
		while(abc != -1) { // -1은 ctrl + z
			abc = System.in.read();
			fw.write(abc);
		}
		fw.close();
	}
}
