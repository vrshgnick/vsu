package ru.vsu.cs.task;

public class Solver {
	public static void sortMatrix(int[][] arr) { // реализация сортировки выбором
		int rows = arr.length;
		int cols = arr[0].length;

		for (int l = 0; l < cols; l++) {
			int minCol = l;
			for (int r = l + 1; r < cols; r++) {
				if (compareColumns(arr, r, minCol) < 0) {
					minCol = r;
				}
			}
			swapColumns(arr, l, minCol);
		}
	}

	private static int compareColumns(int[][] arr, int col1, int col2) {
		for (int[] row : arr) {
			if (row[col1] != row[col2]) {
				return row[col1] - row[col2];
			}
		}
		return 0;
	}

	private static void swapColumns(int[][] arr, int col1, int col2) {
		if (col1 == col2) {
			return;
		}
		for (int[] row : arr) {
			int temp = row[col1];
			row[col1] = row[col2];
			row[col2] = temp;
		}
	}
}
