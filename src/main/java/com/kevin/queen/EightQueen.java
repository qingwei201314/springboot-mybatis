package com.kevin.queen;

public class EightQueen {
	static int[][] queens = new int[8][8];
	// 处理8个子
	static int queen = 0;
	// 处理结果
	static int result = 0;
	// 当前位置
	static int curI = -1;
	static int curJ = -1;

	public static void main(String[] args) {
		reset();

		// 第一个子的位置
		int startI = -1;
		int startJ = -1;

		while (true) {
			// 放子是否成功
			boolean success = false;
			queen = queen + 1;
			int i = startI >= 0 ? startI : 0;
			int j = startJ >= 0 ? startJ : 0;
			
			for (; i < 8; i++) {
				for (; j < 8; j++) {
					if (queens[i][j] == 0) {
						success = true;
						queens[i][j] = 100 + queen;
						curI = i;
						curJ = j;
						// 如果是第一个子
						if (queen == 1) {
							startI = i;
							startJ = j;
						}
						// 将影响的格设置为1
						setOne();

						// 放完后，要退出
						break;
					}
				}
				j = 0;
				if (success) {
					break;
				}
			}
			// 如果放子失败，说明方案错误 ，重置
			if (!success) {
				//第1子的位置往前挪一步
				if (startJ < 7) {
					startJ += 1;
				} else if (startI < 7) {
					startI += 1;
					startJ = 0;
				} else {
					break;
				}
				reset();
			}

			// 如果已摆放8个，需要把结果打印出来
			if (queen >= 8) { // 如果刚好放满，打印
				printResult();
			}
			// 如果到最后一格，不处理
			if (startI >= 7 && startJ >= 7) {
				break;
			}
			if (result == 1) {
				break;
			}
		}
		System.out.println(result);
	}

	/**
	 * 重置
	 */
	private static void reset() {
		queen = 0;
		// 初始化
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				queens[i][j] = 0;
			}
		}
	}

	/**
	 * 打印结果
	 */
	private static void printResult() {
		result = result + 1;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (queens[i][j] > 100) {
					System.out.print(queens[i][j] + "      ");
				} else {
					System.out.print(queens[i][j] + "        ");
				}

			}
			System.out.println("");
		}
		// 重置
		reset();
		System.out.println("==============================================" + result);
	}

	/**
	 * 将影响的格设置为1
	 */
	private static void setOne() {
		// 将当前子所影响的格置为1
		// 处理当前行
		for (int k = 0; k < 8; k++) {
			if (k != curJ) {
				if (queens[curI][k] == 0) {
					queens[curI][k] = 1;
				}
			}
		}
		// 处理当前列
		for (int k = 0; k < 8; k++) {
			if (k != curI) {
				if (queens[k][curJ] == 0) {
					queens[k][curJ] = 1;
				}
			}
		}
		// 处理左上角斜线
		int topLeftI = curI;
		int topLeftJ = curJ;
		while (true) {
			topLeftI -= 1;
			topLeftJ -= 1;
			if (topLeftI < 0 || topLeftJ < 0) {
				break;
			}
			if (queens[topLeftI][topLeftJ] == 0) {
				queens[topLeftI][topLeftJ] = 1;
			}
		}
		// 处理右下角斜线
		topLeftI = curI;
		topLeftJ = curJ;
		while (true) {
			topLeftI += 1;
			topLeftJ += 1;
			if (topLeftI > 7 || topLeftJ > 7) {
				break;
			}
			if (queens[topLeftI][topLeftJ] == 0) {
				queens[topLeftI][topLeftJ] = 1;
			}
		}
		// 处理右上角斜线
		topLeftI = curI;
		topLeftJ = curJ;
		while (true) {
			topLeftI -= 1;
			topLeftJ += 1;
			if (topLeftI < 0 || topLeftJ > 7) {
				break;
			}
			if (queens[topLeftI][topLeftJ] == 0) {
				queens[topLeftI][topLeftJ] = 1;
			}
		}
		// 处理左下角斜线
		topLeftI = curI;
		topLeftJ = curJ;
		while (true) {
			topLeftI += 1;
			topLeftJ -= 1;
			if (topLeftI > 7 || topLeftJ < 0) {
				break;
			}
			if (queens[topLeftI][topLeftJ] == 0) {
				queens[topLeftI][topLeftJ] = 1;
			}
		}
	}
}
