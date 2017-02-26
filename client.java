package lect19.myHeap;

public class client {

	public static void main(String[] args) { 
		
		//HeapClass<Integer,String> heap=new HeapClass<Integer,String>(true);
		
		/*heap.add(10, "India");
		heap.add(17, "nepal");
		heap.add(6, "china");
		heap.add(8,"us");
		heap.add(34, "japan");*/
		
		Integer[] keys={3,2,8,1,6,5,9,0,4};
		String[] values={"anita","sunita","anuj","raju","bajju","radda","sakshi","samridh","ram"};
		HeapClass<Integer,String> heap=new HeapClass<Integer,String>(keys,values);
		heap.display();
		/*while(!heap.isEmpty())
		{
			try{
				System.out.println(heap.remove());
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}*/
		heap.heapsort();
		heap.display();
	}

}
