package sorts;

public class GnomeSort {
	public static void run(){
		int[] nums = {2,3,6,1,3,0,-2,4};
		int l = nums.length;
		for(int i = 1; i< l ; i++) {
			int a = nums[i];
			for(int j = i; j>=0 ; j--) {
				if(a < nums[j] || j == 0) {
					nums = swap(nums, i, j+1);
		for(int k = 0; k < nums.length ; k++) {
		System.out.print(nums[k] + ", ");
		}
		System.out.println();
					break;
				}
			}
		}
		for(int i = 0; i < nums.length ; i++) {
		System.out.print(nums[i] + ", ");
		}
	}
	public static int[] swap(int[] a, int x, int y) {
		int n = a[x];
		a[x] = a[y];
		a[y] = n;
		return a;
	}
}
