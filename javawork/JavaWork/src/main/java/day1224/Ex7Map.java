package day1224;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex7Map {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "송혜교");
		map.put("age", "34");
		map.put("blood","AB");
		map.put("name", "이영자");
		
		System.out.println("map 의 사이즈:" + map.size());
		System.out.println("map 에서 key 값으로 value 값 꺼내기");
		System.out.println("이름:" + map.get("name"));
		System.out.println("나이:" + map.get("age"));
		System.out.println("혈액형:" + map.get("blood"));
		System.out.println("핸드폰:" + map.get("hp"));
		System.out.println();
		System.out.println("key 값들을 자동으로 얻은후 value 값들 얻기");
		Set<String> keySets = map.keySet();
		for(String key : keySets) {
			String v = map.get(key);
			System.out.println(key + "=>" + v);
		}

	}

}
