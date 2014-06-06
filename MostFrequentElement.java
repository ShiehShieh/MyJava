import java.util.ArrayList;

public class MostFrequentElement {
	public static void main(String[] args) {
		int[] data = {1, 2, 4, 5, 7, 9, 3, 5, 7, 2, 8, 0, 4, 5, 5};

		ArrayList<Integer> one = new ArrayList<Integer>();
		ArrayList<Integer> two = new ArrayList<Integer>();

		for (int i = 0; i < data.length; ++i) {
			if (!one.contains(data[i])) {
				one.add(data[i]);
				two.add(1);
			}else{
				int position = one.indexOf(data[i]);
				two.set(position, two.get(position).intValue() + 1);
			}
		}

		for (int i = 0; i < one.size(); ++i) {
			System.out.println(one.get(i));
			System.out.println(two.get(i));
		}

		System.out.println();
	}
}