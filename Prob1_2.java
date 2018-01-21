// given two string, decide if one is permutation of the other
public class Prob1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prob1_2 test = new Prob1_2();
		System.out.println(test.ispermutation_1("tgsh", "gtsh"));
		System.out.println(test.ispermutation_2("tgsh", "gtsh"));
		
	}
	// solution 1: realize that if we sort the two, they should be exactly the same
	// create sort function to return sorted array. sort might be in place or not
	String sort(String x)
	{
		char[] content = x.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	boolean ispermutation_1(String s, String t)
	{
		return sort(s).equals(sort(t));
	}
	// solution 2: we can use extra O(n) memory to maintain a lookup table, basically a hash
	boolean ispermutation_2(String s, String t)
	{
		// if the length of the two are different, return false
		if (s.length() != t.length())
			return false;
		// assuming ASCII
		int[] lookup  = new int[128];
		for (int i=0; i<s.length(); i ++)
		{
			lookup[s.charAt(i)] +=1;
		}
		for (int j=0; j<t.length(); j++)
		{
			lookup[t.charAt(j)] -=1; 
			if (lookup[t.charAt(j)]<0)
				return false;
		}
		return true;
	}
}
