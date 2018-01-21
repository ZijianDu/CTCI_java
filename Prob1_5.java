
public class Prob1_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prob1_5 test = new Prob1_5();
		System.out.println(test.oneedit("abd", "abcd"));
		System.out.println(test.oneedit("abcd","abc"));
		System.out.println(test.oneedit("abcd","abce"));
		System.out.println(test.oneedit("abcd","abcdef"));
		
	}
	
	boolean oneedit(String s, String t)
	{
		if (s.length()==t.length()-1)
			return isoneinsert(s, t);
		if (t.length()==s.length()-1)
			return isoneinsert(t, s);
		if (s.length() == t.length())
			return isonereplace(s, t);
		return false;
	}
	boolean isoneinsert(String s, String t)
	{
		int index1=0;
		int index2=0;
		while (index1<s.length() && index2<t.length())
		{
			if(s.charAt(index1) != t.charAt(index2))
			{
				index2 +=1;
				if (s.charAt(index1)!=t.charAt(index2))
					return false;
			
			}
			index1+=1;
			index2+=1;
		}
		return true;
	}
	// we want to count if there are two different values
	boolean isonereplace(String s, String t)
	{
		int count =0;
		int index1=0;
		int index2=0;
		while (index1<s.length())
		{
			if (s.charAt(index1) != t.charAt(index2))
				count ++;
			index1++;
			index2++;
		}
		return count <=1;
	}

}
