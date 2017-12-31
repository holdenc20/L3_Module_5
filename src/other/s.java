package other;

public class s {
	public static void main(String[] args) {
		int[] nums= {1,2,4,0,12,1,4,3};
for(int i=0;i<nums.length-1;i++) {
	for(int x=0;x<nums.length-1;x++) {
		if(nums[x]>nums[x+1]) {
			int temp=nums[x];
			nums[x]=nums[x+1];
			nums[x+1]=temp;
		}
	}
}
	for(int i=0;i<nums.length;i++) {
		System.out.println(nums[i]);
	}
}
}