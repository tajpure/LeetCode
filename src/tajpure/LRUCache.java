package tajpure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Should change the list to hashmap beacuse of the time limit
 * @author taojx
 *
 */

public class LRUCache {
	
	int curCapacity = 0;
	int totalCapacity = 0;
	
	public class Entry {
		public Entry() {};
		public Entry(int key, int value) { this.key = key; this.value = value; }
		public int key = -1;
		public int value = -1;
	}
	
	LinkedList<Entry> cache = new LinkedList<Entry>();
	
	public LRUCache(int capacity) {
		this.totalCapacity = capacity;
    }
    
    public int get(int key) {
        for (Iterator<Entry> i = cache.iterator(); i.hasNext();) {
        	Entry e = i.next();
        	if (e.key == key) {
        		cache.remove(e);
        		cache.addFirst(e);
        		return e.value;
        	}
        }
    	return -1;
    }
    
    public void set(int key, int value) {
    	Entry e = new Entry(key, value);
        if (curCapacity >= totalCapacity && get(key) == -1) {
        	cache.removeLast();
        	curCapacity--;
        } else if (get(key) != -1) {
        	remove(key);
        	curCapacity--;
        }
        cache.addFirst(e);
        curCapacity++;
    }
    
    public void remove(int key) {
    	for (Iterator<Entry> i = cache.iterator(); i.hasNext();) {
        	Entry e = i.next();
        	if (e.key == key) {
        		cache.remove(e);
        		break;
        	}
        }
    }
    
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	System.out.println("Input capacity:");
    	String in = s.nextLine();
    	LRUCache lru = new LRUCache(Integer.parseInt(in));
    	while (!"E".equals(in)) {
    		System.out.println("Input s or g:");
    		in = s.nextLine();
    		if ("s".equals(in)) {
    		System.out.println("Input set:");
    		in = s.nextLine();
    		String[] str = in.split(" ");
    		int key = Integer.parseInt(str[0]);
    		int value = Integer.parseInt(str[1]);
    		lru.set(key, value);
    		} else {
    		System.out.println("Input get:");
    		in = s.nextLine();
    		System.out.println(lru.get(Integer.parseInt(in)));
    		}
    	}
    }
}
