package algorithms;

import java.util.ArrayList;

public class upto100 {
	static ArrayList<Integer> nums=new ArrayList<Integer>();
public static void main(String[] args) {
	makeList();
	for (int i=0;i<9;i++) {
		for (int x=0;x<9;x++) {
			if(i!=x) {
			ArrayList<Integer> num=nums;
			num.set(i, nums.get(i)*10+nums.get(x));
			num.remove(x);
			test(num);
			}
		}
	}
}
public static void makeList() {
	for(int i=1;i<10;++i) {
		nums.add(i);
	}
	
}
public static void test(ArrayList<Integer> b) {
	int total=0;
	for(int x=0;x<b.size();x++) {
		total=total +b.get(x);
	}
	System.out.println(total);
	if(total==100) {
		for(int x=0;x<b.size();x++) {
			System.out.println(b.get(x));
		}
	}
		
	}
	
}

