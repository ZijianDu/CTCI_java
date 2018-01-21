
public class Prob1_4 {

	public static void main(String[] args) {
		String testcase = "bbbaaaa";
		Prob1_4 test = new Prob1_4();
		System.out.println(test.palindromepermutation_1(testcase));
		System.out.println(test.palindromepermutation_2(testcase));
		System.out.println(test.palindromepermutation_3(testcase));
	}
	
	// first idea is to use a lookup table, to store the frequency of each character in the string
	// to be a palindrome, at most one char can have odd frequency
	// while all others must have even frequency
	// which is both sufficient and necessary
	
	// solution 1: obtain the frequency table then judge
	boolean palindromepermutation_1(String s)
	{
		 int[] table = buildfrequencytable(s);
		 return checkmaxoneodd(table);
	}
	int[] buildfrequencytable(String s)
	{
		// allocate number of int array
		int[] table = new int[Character.getNumericValue('z')-
		                      Character.getNumericValue('a')+1];
		// for each char in s, increment the table by one according to its numerical value
		for (char c: s.toCharArray())
		{
			int x = getcharnumber(c);
			if (x != -1)
				table[x]+=1;
		}
		return table;
	}
	int getcharnumber(char c)
	{
		int i = Character.getNumericValue(c);
		int low = Character.getNumericValue('a');
		int high = Character.getNumericValue('z');
		if (low <=i && high>=i)
			return i-low;
		return -1;
	}
	boolean checkmaxoneodd(int[] table)
	{
		int count = 0;
		for (int i: table)
		{
			if (i%2 ==1)
				count +=1;
			if (count >1)
				return false;
		}
		return true;
	}
	
	// second idea is to check if we have odd count as we construct the frequency table and return result as
	// soon as we come to the end of the string
	boolean palindromepermutation_2(String s)
	{
		int[] table = new int[Character.getNumericValue('z')-Character.getDirectionality('a')+1];
		int oddcount=0;
		for(char c: s.toCharArray())
		{
			int i = getcharnumber(c);
			// odd count is the number of char with odd count, this number can not be greater than 1
			if (i!=-1)
			{
				table[i] ++;
				if (table[i]%2==1)
					oddcount +=1;
				else
					oddcount -=1;
			}
		}
		return oddcount <=1;
	}
	
	// third idea is that we can use less information bit to code the state(odd/even) frequency instead of 
	// counting the exact frequency 
	// this method has O(n) time complexity since only one scan, besides, the space complexity is much smaller 
	// compared to first two methods.
	
	boolean palindromepermutation_3(String s)
	{
		int bitvector = createbitvector(s);
		// if bitvector is 0 or has exactly one 1
		return bitvector == 0 || exactlyone(bitvector);
	}
	int createbitvector(String s)
	{
		int bitvector=0;
		for (char c: s.toCharArray())
		{
			int i = getcharnumber(c);
			bitvector = toggle(i, bitvector);
		}
		return bitvector;
	}
	int toggle(int i, int bitvector)
	{
		if (i<0)
			return bitvector;
		int mask = 1<<i;
		if((bitvector & mask) ==0)
			bitvector = bitvector |mask;
		else
			bitvector = bitvector & (~mask);
		return bitvector;
	}
	boolean exactlyone(int bitvector)
	{
		// if the number has exactly one 1, when it and with number-1 should be zero
		return (bitvector&(bitvector-1)) ==0;
	}
}
