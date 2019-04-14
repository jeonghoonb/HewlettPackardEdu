package day0713;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorEx2 {
	public static void main(String[] args) {
		List<Board> list = new Vector<Board>();
		
		list.add(new Board("제목1","내용1","글쓴이1")); 
		list.add(new Board("제목2","내용2","글쓴이2")); 
		list.add(new Board("제목3","내용3","글쓴이3"));
		list.add(new Board("제목4","내용4","글쓴이4"));
		list.add(new Board("제목5","내용5","글쓴이5"));
		
		list.remove(2);
		list.remove(3);
		
		for(int i=0; i<list.size(); i++) {
			Board board = list.get(i);
			System.out.println(board.subject+", "+board.content+", "+board.writer);
		}System.out.println();
		
		Iterator<Board> it = list.iterator();
		while(it.hasNext()) {
			Board board = it.next();
			System.out.println(board.subject+", "+board.content+", "+board.writer);
		}System.out.println();
		
	}
}
