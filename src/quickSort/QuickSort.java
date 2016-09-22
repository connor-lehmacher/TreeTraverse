package quickSort;

import java.util.ArrayList;

public class QuickSort {
	static int[] ints = {1,3,6,2,9,5};
	static int[] moreints = {7,76,89,10,11,7,12,73,96};
	static int[] sorting;
	static int sortingcarry = 0;
	
	public static void run() {
		//printnew(ints);
		//printnew(quicksort(ints));
		for(int j = 0 ; j < 100 ; j++) {
			int[] rand = randints(67);
			//printnew(rand);
			printnew(quicksort(rand));
			sortingcarry = 0;
		}
	}
	
	public static int[] randints(int elements){
		int[] randints = new int[elements];
		for(int i = 0 ; i < elements ; i++) {
			randints[i] = (int)(Math.random() * 100);
		}
		return randints;
	}
	
	public static void printnew(int[] list){
		for(int i = 0 ; i < list.length ; i++) {
			if(list[i] < 10) {
				System.out.print(list[i] + "  ");
			}
			else{
				System.out.print(list[i] + " ");
			}

		}
		System.out.println();
	}
	
	public static int[] quicksort(int[] list){
		sorting = new int[list.length];
		int llength = list.length;
		int pivot = list[(int)(llength * Math.random())];
		ArrayList<Integer> lower = new ArrayList<Integer>();
		ArrayList<Integer> upper = new ArrayList<Integer>();
		ArrayList<Integer> middle = new ArrayList<Integer>();
		//Sorting
		for(int i = 0 ; i < llength ; i++) {
			if(list[i] < pivot) {
				lower.add(list[i]);
			}
			else if(list[i] > pivot) {
				upper.add(list[i]);
			}
			else if(list[i] == pivot) {
				middle.add(list[i]);
			}
		}
//		System.out.println(pivot);
//		System.out.println(lower);
//		System.out.println(upper);
		if(lower.size() == 1) {
			sorting[sortingcarry] = lower.get(0);
			sortingcarry++;
		}
		else if(lower.size() > 1) {
			partialSort(lower);
		}
		
		for(int i = 0 ; i < middle.size() ; i++ ) {
			sorting[sortingcarry] = pivot;
			sortingcarry++;
		}
		
//		System.out.println("Half-Way");
//		printnew(sorting);
		if(upper.size() == 1) {
			sorting[sortingcarry] = upper.get(0);
			sortingcarry++;
		}
		else if(upper.size() > 1) {
			partialSort(upper);
		}
		
		return sorting;
	}
	public static void partialSort(ArrayList<Integer> list) {
		int llength = list.size();
		int pivot = list.get((int)(llength * Math.random()));
		ArrayList<Integer> lower = new ArrayList<Integer>();
		ArrayList<Integer> upper = new ArrayList<Integer>();
		ArrayList<Integer> middle = new ArrayList<Integer>();
		//Sorting
		for(int i = 0 ; i < llength ; i++) {
			if(list.get(i) < pivot) {
				lower.add(list.get(i));
			}
			else if(list.get(i) > pivot) {
				upper.add(list.get(i));
			}
			else if(list.get(i) == pivot) {
				middle.add(list.get(i));
			}
		}
//		System.out.println(pivot);
//		System.out.println(lower);
//		System.out.println(upper);
		if(lower.size() == 1) {
			sorting[sortingcarry] = lower.get(0);
			sortingcarry++;
		}
		else if(lower.size() > 1) {
			partialSort(lower);
		}
		
		for(int i = 0 ; i < middle.size() ; i++) {
			sorting[sortingcarry] = pivot;
			sortingcarry++;
		}
		
//		System.out.println("Sub-Half");
//		printnew(sorting);
		
		if(upper.size() == 1) {
			sorting[sortingcarry] = upper.get(0);
			sortingcarry++;
		}
		else if(upper.size() > 1) {
			partialSort(upper);
		}
	}
}

