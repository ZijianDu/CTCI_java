public class Prob2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prob2_5 test = new Prob2_5();
		Linkedlist l1 = test.new Linkedlist();
		Linkedlist l2 = test.new Linkedlist();
		for (int i=0; i<10;i++)
		{
			l1.addelement(i);
			l2.addelement(7-i);
		}
		test.addlist(l1.head, l2.head, 0);
		test.addlist_2(l1.head, l2.head);

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
	// sum of linked lists, both start from the LSB
	// use recursion, maintain carry for each recursive call, function return desired node
	Linkedlistnode addlist(Linkedlistnode l1, Linkedlistnode l2, int carry)
	{
		if (l1==null&&l2==null&&carry==0)
		{
			return null;
		}
		Linkedlistnode result = new Linkedlistnode();
		int value = carry;
		if (l1!=null)
			value+=l1.value;
		if (l2!=null)
			value+=l2.value;
		result.value = value%10;
		// recursion
		if(l1!=null||l2!=null)
		{
			Linkedlistnode more = addlist(l1==null? null:l1.next, l2==null? null:l2.next, value>=10?1:0);
			result.next=more;
		}
		return result;
	}
	// for the second part: if we use recursion, need to insert the result at the head of the list
	// wrapper object provides possibility to extend the attributes (as needed by the recursive call) and defined functions for needed behaviors
	class PartialSum
	{
		public Linkedlistnode sum = null;
		public int carry =0;
	}
	Linkedlistnode addlist_2(Linkedlistnode l1, Linkedlistnode l2)
	{
		int len1 = length(l1);
		int len2 = length(l2);
		// pad the shorter with zeros
		if (len1<len2)
		{
			l1 = padlist(l1, len2-len1);
		}
		else 
		{
			l2 = padlist(l2, len1-len2);
		}
		PartialSum sum=addlisthelper(l1, l2);
		// if there is a carry value left over, insert this at the front of the list
		if (sum.carry==0)
			return sum.sum;
		else
		{
			Linkedlistnode result = insertbefore(sum.sum, sum.carry);
			return result;
		}
	}

	// addlist helper uses partial sum class wrapper to maintain both linkedlistnode pointer and int carry value
	// use recursive call to reach the end and then call insert at front function
	PartialSum addlisthelper(Linkedlistnode l1, Linkedlistnode l2)
	{
		if (l1==null && l2==null)
		{
			PartialSum sum = new PartialSum();
			return sum;
		}
		// write recursive call
		PartialSum sum = addlisthelper(l1.next, l2.next);
		// add carry to current data
		int val = sum.carry+l1.value+l2.value;
		// now we want to insert the higher digit value before the current sum node
		Linkedlistnode fullresult = insertbefore(sum.sum, val%10);
		// now we want to return sum (linkedlistnode) with updated results
		sum.sum=fullresult;
		sum.carry=val/10;
		return sum;
	}
	// pad the list with zeros
	Linkedlistnode padlist(Linkedlistnode l, int padding)
	{
		Linkedlistnode head = l;
		for (int i=0; i<padding; i++)
			head = insertbefore(head, 0);
		return head;
	}
	// insert before function takes node and data and insert one node before
	Linkedlistnode insertbefore(Linkedlistnode list, int data)
	{
		Linkedlistnode newnode = new Linkedlistnode();
		newnode.value = data;
		if (list!=null)
		{
			newnode.next = list;
		}
		return newnode;
	}
	int length(Linkedlistnode l)
	{
		int length =0;
		Linkedlistnode head = l;
		while (head!=null)
		{
			length+=1;
			head=head.next;
		}
		return length;
	}
}
