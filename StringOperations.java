public class StringOperations {
	public static void main(String[] args) {
		String myName = "Cameron";
		System.out.println(myName);
		String AmyName = myName.replace("C", "A");
		String myNameAZ = AmyName.replace("n", "Z");
		System.out.println(myNameAZ);
		String url = "www.cameron.com";
		System.out.println(url);
		String urlName = url.substring(4, 11);
		String urlNums = "www." + urlName + "1331.com";
		System.out.println(urlNums);
	}
}