package other;

import java.util.Random;

public class ThreadedNumberSorter {
	static final int TOTAL_NUMS = 10000;

	//Complete the method below so that it uses threads to sort the integer array.
	//Try to get the completion time as short as possible.
	//Use the printArray method to check sorting accuracy
	public static int[] sort(int[] nums){
		if(nums.length>3) {
			int[] newList =new int[nums.length/2];
			int[] newListT =new int[nums.length - nums.length/2];
			for(int i=0;i<nums.length/2;i++) {
				newList[i]=nums[i];
				newListT[i]=nums[i+nums.length/2];
			}
			new Thread(()->sort(newList)).start();
			new Thread(()->sort(newListT)).start();
		}
		else {
			
			for(int x=0;x<nums.length-1;x++) {
				if(nums[x]>nums[x+1]) {
					int temp=nums[x];
					nums[x]=nums[x+1];
					nums[x+1]=temp;
				}
			}
			return nums;
		}
		return nums;
	}
	public static void parallelSort(int[] nums) {
		long startTime = System.nanoTime();
		//Complete this method starting at this point
		int[] b=sort(nums);
		for(int i=0;i<b.length-1;i++) {
			for(int x=0;x<b.length-1;x++) {
				if(b[x]>b[x+1]) {
					int temp=b[x];
					b[x]=b[x+1];
					b[x+1]=temp;
				}
			}
		}
		for(int i=0;i<b.length;i++) {
			System.out.println(b[i]);
		}
		long totalTime = System.nanoTime() - startTime;
		double timeInSeconds = (double)totalTime / 1_000_000_000;
		System.out.println("The total computing time in seconds was: " + timeInSeconds);
	}

	public static void main(String[] args) {
		int[] nums = new int[TOTAL_NUMS];

		Random randGen = new Random();
		for (int i = 0; i < TOTAL_NUMS; i++) {
			nums[i] = randGen.nextInt(TOTAL_NUMS);
		}

		//printArray(nums);
		parallelSort(nums);
		//printArray(nums);
	}
	
	private static void printArray(int[] nums){
		for(int i = 0; i < nums.length; i++){
			System.out.println(nums[i]);
		}
	}
}
