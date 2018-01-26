
public class Prob2_3{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prob2_3 test = new Prob2_3();
		Linkedlist testlist = test.new Linkedlist();
		for (int i=0;i<10;i++)
			testlist.addelement(i);
		// get a middle node and feed into this function
		//test.deletemiddlenode();
	}
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
	// to delete node in the middle of a linkedlist
	boolean deletemiddlenode(Linkedlistnode node)
	{
		if (node==null || node.next==null)
			return false;
		Linkedlistnode nextnode = new Linkedlistnode();
		nextnode = node.next;
		node.value=nextnode.value;
		node.next = nextnode.next;
		return true;
	}

}
