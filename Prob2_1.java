import java.util.HashSet;

public class Prob2_1 {
	public static void main(String[] args) {
		// test the linkedlistnode and linkedlist class
		Prob2_1 test = new Prob2_1();
		Linkedlistnode newhead = test.new Linkedlistnode(0,null);
		Linkedlist unsortedlist = test.new Linkedlist();
		unsortedlist.head = newhead;
		//add element now
		for (int i = 10; i>=0; i--)
		{
			unsortedlist.addelement(i);
		}
		test.deleteduplicate_1(unsortedlist.head);
		test.deleteduplicate_2(unsortedlist.head);
	}
	
	// define linkedlistnode class, which contains variable int value and pointer to next node
    class Linkedlistnode
	{
		private int value;
		private Linkedlistnode next;
		// constructor
		Linkedlistnode(int d, Linkedlistnode n)
		{
			value=d;
			next =n;
		}
	}
    // define Linkedlist class which contains head and addelement method to test the algorithms
    class Linkedlist
	{
		private Linkedlistnode head;
		private void addelement(int i)
		{
			Linkedlistnode current = head;
			// create a head node if its an empty list
			if (head == null)
			{
				head = new Linkedlistnode(i, null);
			}
			// otherwise loop till we find the end of the list and append O(n)
			while(current.next!=null)
			{
				current=current.next;
			}
			// new node will be next node of the last node
			current.next = new Linkedlistnode(i, null);
		}
	}

	// to remove duplicate from an unsorted linkedlist
	// method using a hashing set (which used as buffer)
	Linkedlistnode deleteduplicate_1(Linkedlistnode n)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		Linkedlistnode previous=null;
		while(n!=null)
		{
			if(set.contains(n.value))
			{
				previous.next = n.next;
			}
			else
			{
				set.add(n.value);
				previous = n;
			}
			n=n.next;
		}
		return n;
	}
	// if can not use extra buffer: iterate the list twice, relink if there is duplicate, O(n2) time
	Linkedlistnode deleteduplicate_2(Linkedlistnode n)
	{
		// first loop 
		Linkedlistnode current = n;
		while (current != null)
		{
			// remove all the duplicate items
			Linkedlistnode runner = current;
			while (runner.next != null)
			{
				if(runner.next.value==current.value)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			current = current.next;
		}
		return n;
	}
}