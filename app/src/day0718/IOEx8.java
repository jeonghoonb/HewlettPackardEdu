package day0718;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;


/*
 * 지정한 파일에 내용 쓰기
 */
public class IOEx8 {
	public static void main(String[] args) throws IOException{
		File file = new File("C:/Users/odae/workspace/app/src/day0718/IOEx5_sample.txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw, true); //오토 플러쉬 기능이 있다. flush();
		
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader in = new BufferedReader(isr);
		
		System.out.print("입력 : ");
		String str = "";
		while(!str.equals("end")){
			str = in.readLine();
			pw.println(str);
		}
		in.close();
		pw.close();
	}
}
