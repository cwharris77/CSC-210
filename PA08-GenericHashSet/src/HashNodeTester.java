import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashNodeTester {

	@Test
	void testPrint() {
		MyHashMap<String, Integer> myMap = new MyHashMap<>();
		//System.out.println(myMap);
		myMap.put("First", 0);
		//System.out.println(myMap.get("First"));
		myMap.put("First", 5);
		//System.out.println(myMap.get("First"));
		
		//myMap.printTable();
		
	}
	
	@Test
	void get_EmptyHashMap_ShouldReturnNull() {
	var hm = new MyHashMap<String, Integer>();
	var res = hm.get("hello");
	assertNull(res);
	}

	@Test
	void get_HashMapHasKey_ShouldReturnPairedValue() {
	var hm = new MyHashMap<Integer, String>();
	var key = 1;
	var value = "JAVA";
	hm.put(key, value);

	var res = hm.get(key);

	assertEquals(value, res);
	}

	@Test
	void put_NewKey_ShouldContainKeyValue() {
	var hm = new MyHashMap<Integer, String>();
	var key = 1;
	var value = "JAVA";
	hm.put(key, value);

	var res = hm.get(key);

	assertEquals(value, res);
	}

	@Test
	void put_KeyAlreadyExists_ShouldContainNewValue() {
	var hm = new MyHashMap<Integer, String>();
	var key = 1;
	var value = "JAVA";
	var secondValue = "J++";
	hm.put(key, value);
	hm.put(key, secondValue);

	var res = hm.get(key);

	assertEquals(secondValue, res);
	}

	@Test
	void clear_HashMapHasSeveralKeys_ShouldRemoveAllItems() {
	var hm = new MyHashMap<Integer, String>();
	var key = 1;
	var key2 = 2;
	var value = "JAVA";
	hm.put(key, value);
	hm.put(key2, value);
	//hm.printTable();
	hm.clear();

	assertNull(hm.get(key));
	assertNull(hm.get(key2));
	}

	@Test
	void containsKey_HashMapHasKey_ShouldReturnTrue() {
	var hm = new MyHashMap<Integer, String>();
	var key = 1;
	var value = "JAVA";

	hm.put(key, value);

	assertTrue(hm.containsKey(key));
	}

	@Test
	void containsKey_HashMapDoesNotHaveKey_ShouldReturnTrue() {
	var hm = new MyHashMap<Integer, String>();
	var key = 1;
	var keyNotMapped = 2;
	var value = "JAVA";

	hm.put(key, value);

	assertFalse(hm.containsKey(keyNotMapped));
	}

	@Test
	void containesValue_HashMapHasValue_ShouldReturnTrue() {
	var hm = new MyHashMap<Integer, String>();
	var key = 1;
	var value = "JAVA";

	hm.put(key, value);
	hm.put(2, value);
	hm.put(3, value);
	hm.put(4, value);
	hm.put(5, value);
	hm.put(6, value);
	hm.put(7, value);
	hm.put(8, value);
	hm.put(11, value);
//	hm.put(12, value);
//	hm.put(0, value);
//	hm.put(67, value);
//	hm.put(57, value);
//	hm.put(47, value);
//	hm.put(97, value);
//	hm.put(567, value);
//	hm.put(37, value);
//	hm.put(87, value);
	


	hm.printTable();

	assertTrue(hm.containsValue(value));
	}

	@Test
	void containesValue_HashMapDoesNotHaveValue_ShouldReturnTrue() {
	var hm = new MyHashMap<Integer, String>();
	var key = 1;
	var value = "JAVA";
	var valueNotMapped = "HASKELL";

	hm.put(key, value);

	assertFalse(hm.containsValue(valueNotMapped));
	}

	@Test
	void empty_HashMapIsEmpty_ShouldReturnTrue() {
	var hm = new MyHashMap<Integer, String>();

	assertTrue(hm.isEmpty());
	}

	@Test
	void empty_HashMapIsNotEmpty_ShouldReturnFalse() {
	var hm = new MyHashMap<Integer, String>();
	var key = 1;
	var value = "JAVA";

	hm.put(key, value);

	assertFalse(hm.isEmpty());
	}

	@Test
	void remove_HashMapContainsKey_ShouldRemoveKey() {
	var hm = new MyHashMap<Integer, String>();
	var key = 1;
	var value = "JAVA";

	hm.put(key, value);

	var removed = hm.remove(key);
	
	hm.printTable(); 
	
	assertEquals(value, removed);
	assertNull(hm.get(key));
	
	}

	@Test
	void size_HashMapContainsSeveralKeyValue_ShouldReturnExpectedSize() {
	var hm = new MyHashMap<Integer, String>();
	var expectedSize = 5;

	hm.put(1, "JAVA");
	hm.put(2, "JAVA");
	hm.put(3, "JAVA");
	hm.put(4, "JAVA");
	hm.put(5, "JAVA");

	assertEquals(expectedSize, hm.size());
	}

//	void values_HashMapContainsSeveralKeyValue_ShouldReturnValues() {
//	var hm = new MyHashMap<Integer, String>();
//	var expectedValues = List.of("JAVA", "C++", "ADA");
//
//	for (int i = 0; i < expectedValues.size(); i++) {
//	hm.put(i, expectedValues.get(i));
//	}
//
//	var res = hm.values();
//
//	assertEquals(expectedValues, res);
//	}
//
//	void values_HashMapIsEmpty_ShouldReturnEmptyCollection() {
//	var hm = new MyHashMap<Integer, String>();
//
//	var res = hm.values();
//
//	assertTrue(res.isEmpty());
//	}

}
