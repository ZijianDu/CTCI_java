
public class Prob1_3 {

	public static void main(String[] args) {
		Prob1_3 test = new Prob1_3();
		char[] input = "Mr John Smith    ".toCharArray();
		System.out.println(test.replacespace(input, 13));

	}
	// some notes: string is immutable, though implemented in char array underneath
	// string concatenation possible, char array is mutable, string to char array: .tochararray()
    char[] replacespace(char[] str, int truelength)
	{
		int spacecount = 0;
		int index;
		for (int i=0; i<truelength; i++)
		{
			if (str[i]==' ')
				spacecount ++;
		}
		index = truelength+2*spacecount;
		if (truelength<str.length) 
			str[truelength] = '\0';
		for (int i=truelength-1; i>=0; i--)
		{
			if (str[i]==' ')
			{
				str[index-1] ='0';
				str[index-2]='2';
				str[index-3]='%';
				index=index-3;
			}
			else
			{
				str[index-1] = str[i];
				index --;
			}
		}
		return str;
	
	}
		
}
	


