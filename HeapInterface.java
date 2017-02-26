package lect19.myHeap;

public interface HeapInterface<K,V> {

	int size();
	boolean isEmpty();
	void add(K key,V value);
	V remove() throws HeapEmptyException;
	V get() throws HeapEmptyException;
	void display();
}
