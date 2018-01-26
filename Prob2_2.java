public class Prob2_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prob2_2 test = new Prob2_2();
		Linkedlist testlist = test.new Linkedlist();
		for (int i=0; i<10;i++)
			// addelement is class method
			testlist.addelement(i);
		// returnkth is method in problem class
		test.returnkth_1(testlist.head, 5);
		test.returnkth_2(testlist.head,5);
		test.returnkth_3(testlist.head, 5);
	}
	// define linkedlistnode class, which contains variable int value and pointer to next node
    class Linkedlistnode
	{
		private int value;
		private Linkedlistnode next;
		// constructors
		public Linkedlistnode()
		{
			next=null;
			value=0;
		}
		public Linkedlistnode(int d, Linkedlistnode n)
		{
			value=d;
			next=n;
		}
	}
    // define Linkedlist class which contains head and addelement method to test the algorithms
    class Linkedlist
	{
		private Linkedlistnode head;
		// constructor
		public Linkedlist()
		{
			head = null;
		}
		// function used to do testing, O(n) time complexity
		private void addelement(int i)
		{
			// create new node
			Linkedlistnode newnode = new Linkedlistnode(i, null);
			if (head == null)
				head = newnode;
			else
			{
				Linkedlistnode current = head;
				while (current.next != null)
				{
					current = current.next;
				}
				current.next = newnode;
			}
		}
	}
	// return kth to last element for a linked list 1st: O(n) to get the length of the list
    Linkedlistnode returnkth_1(Linkedlistnode head, int k)
    {
    	// get the length of the list
    	Linkedlistnode current = new Linkedlistnode();
    	current = head;
    	int length = 0;
    	while (current !=null)
    	{
    		length+=1;
    		current = current.next;
    	}
    	// now we just need to count length - k times to get to the right node
    	int count = length-k;
    	Linkedlistnode result = head;
    	for (int i=0; i<count; i++)
    		result = result.next;
    	return result; 		
    }
    // solution 2: use recursion, iterate to the end then use a counter to get back k times
    int returnkth_2(Linkedlistnode head, int k)
    {
    	if (head==null)
    		return 0;
    	int index = returnkth_2(head.next, k);
    	if (index ==k)
    		System.out.println(k+" th to last node is: "+ head.value);
    	return index;
    }
    
    // solution 3: iterative by using two pointers with k offset
    Linkedlistnode returnkth_3(Linkedlistnode head, int k)
    {
    	Linkedlistnode p1 = head;
    	Linkedlistnode p2 = head;
    	// move the p2 pointer to desired offset
    	for (int i=0; i<k; i++)
    	{
    		if (p2 == null)
    			return null;
    		p2=p2.next;
    	}
    	// now move both pointer at same pace
    	while (p2.next!=null)
    	{
    		p1=p1.next;
    		p2=p2.next;
    	}
    	return p1;
    }
	
}
