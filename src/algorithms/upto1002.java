package algorithms;

import java.util.ArrayList;
import java.util.Random;

public class upto1002 {
	static int solutions=0;
	static ArrayList<Integer> nums=new ArrayList<Integer>();
	static ArrayList<ArrayList<Integer>> solution=new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		ArrayList<Integer> num=new ArrayList<Integer>();
		makeList1();
		Random r = new Random();
		for(int i=0;i<Math.pow(3, 9);i++) {
			for(int x=0;x<9;x++) {
				if(i==0) {
				num.add(r.nextInt(3));
				}
				else {
					num.set(x, r.nextInt(3));
				}
			}
				for(int t=8;t>-1;t--) {
					
				
					if(num.get(t)==0){
						nums.set(t, 1+t);
					}
					if(num.get(t)==1){
						nums.set(t, -t-1);
					}
					if(num.get(t)==2 && t<8 && nums.get(t)!=0 && t>-1){
						if(nums.get(t+1)>10) {
							if(nums.get(t)>0 || nums.get(t+1)>0) {
								nums.set(t, 100*(t+1) +nums.get(t+1));
								nums.set(t+1, 0);
							}
							else {
								nums.set(t, -100*Math.abs(t+1) +Math.abs(nums.get(t+1)));
								nums.set(t+1, 0);
							}
						}
						else {
						nums.set(t, 10*(t+1)+t+2);
						nums.set(t+1, 0);
						}
					}
					//System.out.println(nums);
					
				}
				test(nums);

			
		}
		System.out.println(solutions);
	}
	public static void makeList() {
		for(int i=1;i<10;++i) {
			nums.set(i-1,i);
		}
		
	}
	public static void makeList1() {
		for(int i=1;i<10;++i) {
			nums.add(i);
		}
		
	}
	public static void test(ArrayList<Integer> b) {
		
		int total=0;
		for(int x=0;x<b.size();x++) {
			total=total +b.get(x);
		}
		if(total==100) {
			boolean c=true;
			for(int i=0;i<solution.size();i++) {
				if(b==solution.get(i)) {
					c=false;
				}
			}
			if(c==true) {
			solution.add(b);
			solutions++;
			System.out.println();
			for(int x=0;x<b.size();x++) {
				if(b.get(x)!=0) {
				System.out.print(b.get(x)+" ");
				}
			}
			}
		}
			
		}
}
