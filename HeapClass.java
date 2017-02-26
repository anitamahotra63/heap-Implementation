package lect19.myHeap;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapClass<K extends Comparable<K>,V> implements HeapInterface<K,V> 

{

	private class HeapNode implements Comparable<HeapNode>{
		
		K key;
		V value;
		
		public HeapNode(K key,V value)
		{
			this.key=key;
			this.value=value;
		}
		
		public String toString()
		{
			String retval="";
			retval+="{"+this.key+","+this.value+"}";
			return retval;
		}
		
		public int compareTo(HeapNode other) {
			return this.key.compareTo(other.key);
		}
	}
	
	private ArrayList<HeapNode> data;
	private Comparator<HeapNode> comparator; //Comparator is an interface
	private int size;
	
	private class NormalComparator implements Comparator<HeapNode>
	{
		public int compare(HeapNode one,HeapNode two) {
			return one.compareTo(two);
		}
	}

	private class ReverseComparator implements Comparator<HeapNode>
	{
		public int compare(HeapNode one, HeapNode two) {
			return two.compareTo(one);
		}
	}
	
	public HeapClass()
	{
		this(true);
	}
	
	public HeapClass(boolean is_min_heap)
	{
		this.data=new ArrayList<HeapNode>();
		if(is_min_heap)
		{
			this.comparator=new ReverseComparator();
		}
		else
		{
			this.comparator=new NormalComparator();
		}
	}
	
	public int size() {
		
		return this.size;
	}

	public boolean isEmpty() {
		return this.size()==0;
	}

	public void add(K key, V value) {//complexity is logn,logn is the height of heap
		
		HeapNode node=new HeapNode(key,value);
		this.data.add(node);
		this.size++;
		this.upheapify(this.data.size()-1);
	}

	private void upheapify(int ci)
	{
		if(ci==0)
		{
			return;
		}
		int pi=(ci-1)/2;
		
		if(this.comparator.compare(this.data.get(pi),this.data.get(ci))<0)
		{
			this.swapNodes(pi,ci);
			this.upheapify(pi);
		}	
	}
	
	private void swapNodes(int first,int second)
	{
		HeapNode node=this.data.get(first);
		this.data.set(first,this.data.get(second));
		this.data.set(second, node);
	}
	
	public V remove() throws HeapEmptyException {//complexity is logn
		
		if(this.isEmpty())
		{
			throw new HeapEmptyException();
		}
		V retval=this.data.get(0).value;
		this.swapNodes(0,this.size()-1);
		this.data.remove(this.size()-1);
		
		this.downheapify(0);
		
		return retval;
	}

	private void downheapify(int pi)
	{
		int li=pi*2+1;
		int ri=pi*2+2;
		int MinIndex= pi;
		
		if( li<this.size() && this.comparator.compare(this.data.get(MinIndex),this.data.get(li))<0)
		{
			MinIndex=li;
		}
		if( ri<this.size() && this.comparator.compare(this.data.get(MinIndex),this.data.get(ri))<0)
		{
			MinIndex=ri;
		}
		if(MinIndex!=pi)
		{
			this.swapNodes(MinIndex,pi);
			this.downheapify(MinIndex);
		}
		
	}

	public V get() throws HeapEmptyException {
		return this.data.get(0).value;
	}

	public void display() {
		System.out.println(this.data);
	}
		
	//Now, building a complete heap takes nlogn time,which can be reduced by n time
	//here it is-:
	//2.heap sort.whose complexity is also nlogn
	
	public HeapClass(K[] keys, V[] values)
	{
		this.data=new ArrayList<HeapNode>();
		this.comparator=new NormalComparator();
		for(int i=0;i<keys.length;i++)
		{
			HeapNode node=new HeapNode(keys[i],values[i]);
			this.data.add(node);
			this.size++;
		}
		
		for(int i=this.size()/2-1;i>=0;i--)
		{
			 this.downheapify(i);
		}
	}
	
	//in a heap sort , we are given a heap
	
	public void heapsort()
	{
		if(this.size==1)
		{
			return;
		}
		this.swapNodes(0,this.size()-1);
		this.size--;
		this.downheapify(0);
		this.heapsort();
	}

	
	














}
