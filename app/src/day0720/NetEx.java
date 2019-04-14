package day0720;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.omg.CORBA.portable.UnknownException;

public class NetEx {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr1 = InetAddress.getByName("www.naver.com");
		InetAddress[] addr2 = InetAddress.getAllByName("www.naver.com");
		InetAddress addr3 = InetAddress.getLocalHost();
		System.out.println("=============");
		System.out.println("IP : "+addr1.getHostAddress());
		System.out.println("HOST : "+addr1.getHostName());
		System.out.println("로컬주소 : "+addr3.getHostAddress());
		System.out.println("로컬이름 : "+addr3.getHostName());
		for(InetAddress str : addr2){
			System.out.println(str);
		}
	}
}
