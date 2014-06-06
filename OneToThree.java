class OneToThree {
	public static void selectionSort(double[] data) {
		int i, j;
		int nMinIndex;
		double temp;

		for (i = 0; i < data.length - 1; ++i) {
			nMinIndex = i;
			for (j = i; j < data.length; ++j) {
				if (data[j] < data[nMinIndex]) {
					nMinIndex = j;
				}
			}
			if (i != nMinIndex) {
				temp = data[i];
				data[i] = data[nMinIndex];
				data[nMinIndex] = temp;
			}
		}
	}

	public static void binarySearch(int[] data, int searchData) {
		int middle = data.length / 2;
		int left = 0;
		int right = data.length;
		double current = 0;
		double last = 0;
		while(last != middle && current != searchData) {
			last = middle;
			current = data[middle + 1];
			if (current < searchData) {
				left = middle;
				middle = (middle + right) / 2;
			}else{
				right = middle;
				middle = (left + middle) / 2;
			}
			System.out.println(current);
			System.out.println(middle);
		}
	}

	public static double calculateWeek(int[][] data) {
		int sum = 0;
		for (int[] a : data) {
			for (int b : a) {
				sum += b;
			}
		}
		return sum / 52;
	}

	public static double calculateSunday(int[][] data) {
		int sum = 0;
		for (int i = 0; i < 52; ++i) {
			sum += data[i][6];
		}
		return sum / 52;
	}

	public static void main(String[] args) {
		int[] data = new int[14];
		int[][] newspaper = new int[52][7];

		for (int i = 1; i < data.length; ++i) {
			data[i] = 2 * i;
		}
//		selectionSort(data);
		binarySearch(data, 21);
	}
}
