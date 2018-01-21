
public class Prob1_6 {

	public static void main(String[] args) {
		Prob1_6 test = new Prob1_6();
		System.out.println(test.compressstring_1("aabbbbh"));
		System.out.println(test.compressstring_2("aabbbbh"));
		

	}
	// solution 1: scan through the original string and append the desired character and count to the result
	String compressstring_1(String s)
	{
		String compressed = "";
		int count=0;
		for (int i=0; i<s.length(); i++)
		{
			count ++;
			if (i+1>=s.length()|| s.charAt(i)!=s.charAt(i+1))
			{
				compressed += ""+s.charAt(i)+count;
				count =0;
			}
		}
		return compressed.length() <= s.length()? compressed:s;
	}
	// Solution 2: for iterative concatenation of string, it is more efficient using stringbuilder
	String compressstring_2(String s)
	{
		StringBuilder compressed = new StringBuilder();
		int count = 0;
		for (int i = 0; i <s.length(); i++)
		{
			count ++;
			if (i+1>=s.length()||s.charAt(i)!=s.charAt(i+1))
			{
				compressed.append(s.charAt(i)).append(count);
				count =0;
			}
		}
		return compressed.length()<=s.length()?compressed.toString():s;
	}

}
