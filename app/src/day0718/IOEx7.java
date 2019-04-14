package day0718;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IOEx7 {
	public static void main(String[] args) throws IOException{
		//FileWriter fw = new FileWriter(new File("C:/Users/odae/workspace/app/src/day0718IOEx5_sample.txt"));
		PrintWriter fw = new PrintWriter(new File("C:/Users/odae/workspace/app/src/day0718IOEx5_sample.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력 :");
		String str = "";
		while(!str.equals("end")) {
			str = in.readLine();
			//fw.write(str);
			fw.println(str);
		}
		fw.close();
	}
}
