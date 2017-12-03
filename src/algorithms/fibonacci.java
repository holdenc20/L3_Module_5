package algorithms;

public class fibonacci {
public static void main(String[] args) {
	sequence(0,1);
}
public static void sequence(int x,int y) {
	if(x>150) {
		
	}
	else {
	System.out.println(x);
	sequence(x+y,x);
	}
}
}
