package Github;

import java.util.*;

public class rainWaterTrapping {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t != 0) {
			int n = scn.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}

			int left[] = new int[n];
			left[0] = arr[0];
			for (int i = 1; i < n; i++) {
				if (arr[i] > left[i - 1]) {
					left[i] = arr[i];
				} else {
					left[i] = left[i - 1];
				}
			}
			int right[] = new int[n];
			right[n - 1] = arr[n - 1];
			for (int i = n - 2; i >= 0; i--) {
				if (arr[i] > right[i + 1]) {
					right[i] = arr[i];
				} else {
					right[i] = right[i + 1];
				}
			}

			int sum = 0;
			for (int i = 0; i < n; i++) {
				int min = Math.min(left[i], right[i]);
				sum += (min - arr[i]);
			}
			System.out.println(sum);
			t--;
		}
	}

}
