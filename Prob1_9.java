
public class Prob1_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prob1_9 test = new Prob1_9();
		System.out.println(test.isrotation("abcd", "dabc"));
		
	}
	// if s2 is a rotation of s1, s2 will always be substring of s1s1, both ways
	boolean isrotation(String s1, String s2)
	{
		if (s1.length()!=s2.length())
			return false;
		String s = s1+s1;
		return issubstring(s2, s);
	}
	boolean issubstring(String sshort, String slong)
	{
		return slong.contains(sshort);
	}
}
