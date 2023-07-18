import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * AUTHOR: Cooper Harris
 * FILE: MyHashMap.java
 * PURPOSE: This class creates a generic implementation
 * of a HashMap backed by an ArrayList of Linked lists.
 * 
 */

public class MyHashMap<K, V> {
	
	private ArrayList<LinkedList<HashNode<K, V>>> masterList;
	private int size;
	private static final int NUMBUCKETS = 8;
	
	public MyHashMap() {
		masterList = new ArrayList<>();
		
		for (int i = 0; i < 8; i++) {
			masterList.add(null);
		}
		size = 0;
	}
	
	/*
	 * The given hash function to determine the indeces
	 * of values.
	 * 
	 * @Param key-The key a value will be mapped to
	 * 
	 * @Return index- the index the key will be placed at
	 */
	private int hash(K key) { 
		int hashCode = key.hashCode(); 
		int index = hashCode % NUMBUCKETS; 
		return Math.abs(index); 
	}
	
	/*
	 * Removes all of the mappings from this map.
	 * 
	 * @Return null
	 */
	public void clear() {
		size = 0;
		for (int i = 0; i < masterList.size(); i++) {
			if (masterList.get(i) != null) {
				masterList.set(i, null);
			}
		} 
	}
	
	/*
	 * Returns true if this map contains a mapping for the specified key.
	 * 
	 * @Param key-The key to search the map for
	 * 
	 * @Return boolean- true if the map contains the key
	 */
	public boolean containsKey(K key) {
		int id = hash(key);
		
		LinkedList<HashNode<K, V>> list = masterList.get(id);
		
		if (list != null) {
			HashNode<K, V> curr = list.get(0);
			
			for (int i = 0; i < list.size(); i++) {
				if (curr != null) {
					if (curr.getKey().equals(key)) {
						return true;
					}
					curr = curr.getNext();
				}
			}
		}

		return false;
	}
	
	/*
	 * Returns true if this map maps one or more keys to the specified value.
	 * 
	 * @Param val-The value to search the map for
	 * 
	 * @Return boolean- true if the map contains the given value
	 */
	public boolean containsValue(V val) {
		for (int i = 0; i < masterList.size(); i++) {
			LinkedList<HashNode<K, V>> list = masterList.get(i);
			
			if (list != null) {
				HashNode<K, V> curr = list.get(0);
				
				for (int j = 0; j < list.size(); j++) {
					if (curr.getValue().equals(val)) {
						return true;
					}
					curr = curr.getNext();
				}
			}
		}
		return false;
	}
	
	/*
	 * Returns the value to which the specified key is mapped, or null if this map 
	 * contains no mapping for the key.
	 * 
	 * @Param key - The key mapped to the return value
	 * 
	 * @Return curr.getValue - the value associated with the given key
	 */
	public V get(K key) {
		int id = hash(key);
		
		LinkedList<HashNode<K, V>> list = masterList.get(id);
		
		if (list != null && list.size() != 0) {
			HashNode<K, V> curr = list.get(0);
			
			for (int i = 0; i < list.size(); i++) {
				if (curr.getKey().equals(key)) {
					return curr.getValue();
				}
				curr = curr.getNext();
			}
		}
		return null;
	}
	
	/*
	 * Returns whether the map is empty or not.
	 * 
	 * @Return boolean - true if the map is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*
	 * Returns a hash set of all the keys in the map
	 * 
	 * @Return set - A hash set containing all keys in
	 * the map
	 */
	public HashSet<K> keySet() {
		HashSet<K> set = new HashSet<>();
			
		for (int i = 0; i < masterList.size(); i++) {
			LinkedList<HashNode<K, V>> list = masterList.get(i);
			
			if (list != null) {
				for (int j = 0; j < list.size(); j++) {
					HashNode<K, V> curr = list.get(j);
					set.add(curr.getKey());
				}
			}					
		}
		
		return set;
	}
	
	/*
	 * Associates the specified value with the specified key in this map.
	 * 
	 * @Param key - The key mapped to the return value
	 * @Param val - the value to go with the given key
	 * 
	 * @Return prevVal - the previous value associated with key, or 
	 * null if there was no mapping for key
	 */
	public V put(K key, V val) {
		int index = hash(key);
		
		if (masterList.get(index) == null) {
			HashNode<K, V> newNode = new HashNode<>(key, val);
			LinkedList<HashNode<K, V>> list = new LinkedList<>();
			list.add(newNode);
			masterList.set(index, list);
			
			size++;
			return null;		
		} else {			
			LinkedList<HashNode<K, V>> list = masterList.get(index);		
			if (containsKey(key)) {
				for (int i = 0; i < masterList.get(index).size(); i++) {
					if (key.equals(masterList.get(index).get(i).getKey())) {
						HashNode<K, V> node = masterList.get(index).get(0);
						
						V prevVal = masterList.get(index).get(i).getValue();
						
						node.setValue(val);
						
						size++;
						return prevVal;
					}
				}				
			} else {
				HashNode<K, V> newNode = new HashNode<>(key, val);
				list.add(0, newNode);
			}
			size++;
			return null;
		}		
	}
	
	/*
	 * Removes the mapping for the specified key from this map if present.
	 * 
	 * @Param key - The key to be removed from the map
	 * 
	 * @Return - the previous value associated with key, or 
	 * null if there was no mapping for key
	 */
	public V remove(K key) {
		int index = hash(key);
		
		LinkedList<HashNode<K, V>> list = masterList.get(index);
		
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				HashNode<K, V> curr = list.get(i);
				 if (curr.getKey().equals(key)) {
					 list.remove(i);
					 size--;
					 return curr.getValue();
				 }		 
			}
		}
		
		return null;
	}
	
	/*
	 * Returns the number of mappings in the map
	 * 
	 * @Return size - the size of the map
	 */
	public int size() {
		return size;
	}
	
	/*
	 * prints the map in the form:
	 * Index 1: (O conflicts) [keys in this index]
	 * 
	 * @Return null
	 */
	public void printTable() {
		int count = 0;
		int lstCount = 0;
		
		for (int i = 0; i < 8; i++) {
			if (masterList.get(i) == null) {
				System.out.println("Index " + i + ": (0 conflicts), []");
			} else {
				ArrayList<K> keys = new ArrayList<>();
				
				for (int j = 0; j < masterList.get(i).size(); j++) {
					LinkedList<HashNode<K, V>> list = masterList.get(i);
					keys.add(list.get(j).getKey());
				}
				count += keys.size() - 1;
				
				if (keys.size() == 0) {
					lstCount = 1;
				} else {
					lstCount = keys.size();
				}
				System.out.print("Index " + i + ": (" + (lstCount - 1) + " conflicts), [");
				for (int j = 0; j < keys.size(); j++) {
					System.out.print(keys.get(j) + ", ");
				}
				System.out.println("]");
			}
		}
		if (count < 0) {
			count = 0;
		}
		System.out.println("Total # of conflicts: " + count);
	}
	
//	@Override
//	public String toString() {
//		HashSet<K> keys = keySet();
//		String
//		for (int i = 0; i < keys.size(); i++) {
//			
//		}
//	}
//	
}
