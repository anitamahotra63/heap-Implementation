package lect19.myHeap;

public class HeapEmptyException extends Exception{

	public HeapEmptyException()
	{
		super("Heap is empty");
	}
}
