package recurson;

public class Main {

	public static void main(String[] args) {
		//print the number 0 to 5;
		print1(0);
	}
	
	public static void print1(int N) {
		System.out.println(N);
		if(N>=6) return;
		print1(N+1);
	}
	
	
}
