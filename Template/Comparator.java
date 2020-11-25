class Solution {
	/*
		Primitive types array CANNOT use comparator
	*/
	public void TemplateOne() {
		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);

		List<Integer> list = new ArrayList<>();
		Collections.sort(list, (x, y) -> x - y);

		Integer[] array = new Integer[] {1,2,3};
		Arrays.sort(array, (x, y) -> x - y);
	}

	public void TemplateTwo() {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});

		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});

		int[][] array = new int[n][n];
		Arrays.sort(array, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
	}

	public void TemplateThree() {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new ComparatorName());

		Collections.sort(list, new ComparatorName());
		Arrays.sort(array, new ComparatorName());
	}

	public class ComparatorName implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return a - b;
		}
	}
}