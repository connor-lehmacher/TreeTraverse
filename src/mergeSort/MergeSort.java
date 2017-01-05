package mergeSort;

public class MergeSort {

	public static void run() {
		
		int[] nums = {2,3,4,1,4,2,9,0,7,7,7,7,5,2,3};
		int[][] nums1 = new int[nums.length][1];
		for(int i = 0; i < nums.length; i++){
			nums1[i][0] = nums[i];
		}
		for(int i = 0; i < nums.length ; i++) {
		System.out.print(sort(nums1)[0][i] + ", ");
		}
	}
	
	public static int[][] sort(int[][] in) {
		if(in.length > 1) {
			int[][] an = new int[(in.length + 1) / 2][];
			for(int i = 0; i+1< in.length; i+=2) {
				an[i/2] = merge(in[i], in[i+1]);
			}
			if(in.length % 2 == 1) {
				an[an.length - 1] = in[in.length - 1];
			}
			return sort(an);
		}
		return in;
	}
	
	public static int[] merge(int[] a, int[] b) {
		int x = 0;
		int y = 0;
		int[] s = new int[a.length + b.length];
		for(int i = 0; i <a.length + b.length; i++) {
			if(y == b.length) {
				s[i] = a[x];
			} else {
				if(x == a.length || a[x] > b[y]) {
					s[i] = b[y];
					y++;
				}
				else{
					s[i] = a[x];
					x++;
				}
			}
		}
		return s;
	}
}
