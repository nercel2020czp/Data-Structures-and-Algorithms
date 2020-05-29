package test;

public class Inter {
	public static void main(String[] args) {
//		String s1 = new StringBuilder("go").append("od").toString();
//		String s2 = s1.intern();
//		System.out.println(s2 == s1);
		String s2 = new StringBuilder("ja").append("va").toString();
		String s3 = s2.intern();
		System.out.println(s3 == s2);
	}
}
