// CTCI problems, chapter1 
public class Prob1_1 {
public static void main(String[] args) 
{
	Prob1_1 newtest = new Prob1_1();
	System.out.println("solution1");
	System.out.println(newtest.isunique_1("knn wdjbs"));
	System.out.println("solution2");
	System.out.println(newtest.isunique_2("knn wdjbs"));
	System.out.println("solution3");
	System.out.println(newtest.isunique_3("knn wdjbs"));
}

// method1: use a lookup array to compare
boolean isunique_1(String str)
{
		if (str.length() > 128)
			return false;
		boolean[] charset = new boolean[128];
		for (int i=0; i<str.length(); i++)
		{
			int val = str.charAt(i);
			if (charset[val])
				return false;
			charset[val] = true;
		}
		return true;
}
// method2: O(n2) solution, two for loop to compare
boolean isunique_2(String str)
{
	for (int i=0; i<str.length()-1; i ++)
	{
		for(int j =i+1; j<str.length(); j++)
		{
			if (str.charAt(i) == str.charAt(j))
				return false;
		}
	}
	return true;
}

// method3: sort the string first then do a linear search and compare the element with the next one
boolean isunique_3(String str)
{
	char[] content = str.toCharArray();
	java.util.Arrays.sort(content);
	for (int i=1; i<str.length()-1; i++)
	{
		if (content[i] == content[i+1])
			return false;
	}
	return true;
}
}