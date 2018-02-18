package algorithms;

import java.util.ArrayList;

public class upto100 {
	static int solutions=0;
	static ArrayList<Integer> nums=new ArrayList<Integer>();
public static void main(String[] args) {
	ArrayList<Integer> num=new ArrayList<Integer>();
	makeList1();
	int total=0;
	boolean x=false;
	for(int a=0;a<3;a++) {
		for(int b=0;b<3;b++) {
			for(int c=0;c<3;c++) {
				for(int d=0;d<3;d++) {
					for(int e=0;e<3;e++) {
						for(int f=0;f<3;f++) {
							for(int g=0;g<3;g++) {
								for(int h=0;h<3;h++) {
									for(int i=0;i<3;i++) {
										total++;
										if(x==false) {
											x=true;
										}
										else {
											num.remove(0);num.remove(0);num.remove(0);num.remove(0);num.remove(0);num.remove(0);num.remove(0);num.remove(0);
										}
										num.add(a);num.add(b);num.add(c);num.add(d);num.add(e);num.add(f);num.add(g);num.add(h);num.add(i);
										makeList();
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
								}	
							}	
						}	
					}	
				}	
			}	
		}
	}
	System.out.println();
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

