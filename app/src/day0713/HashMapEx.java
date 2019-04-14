package day0713;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx {
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		System.out.println("총 Entry 수 : "+map.size()); //key값 중복 x : 3개
		
		System.out.println("\t홍길동 : "+map.get("홍길동"));
		System.out.println();
		
		Set<String> keySet = map.keySet(); //Map의 key 값만 꺼내서 Set으로 저장
		Iterator<String> keyIterator = keySet.iterator(); //그 키 값을 iterator로 저장
		while(keyIterator.hasNext()) { //iterator에 값이 있으면
			String key = keyIterator.next(); //iterator 다음 값 뽑기
			Integer value = map.get(key); //해당 key값의 데이터 추출
			System.out.println("\t"+key+" : "+value);
		}
		System.out.println();
		
		map.remove("홍길동");
		System.out.println("총 Entry 수 : "+map.size());
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t"+key+" : "+value);
		}
		System.out.println();

		map.clear();
		System.out.println("총 Entry 수 : "+map.size());
		
	}
}
