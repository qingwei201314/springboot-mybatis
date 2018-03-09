package com.kevin.queen;

public class EightQueen {
	static int[][] queens = new int[8][8];
	// 最近一子位置
	static int curI = -1;
	static int curJ = -1;
	// 第1子位置
	static int oneI = -1;
	static int oneJ = -1;

	public static void main(String[] args) {
//		for(int j = 0; j < 8; j ++){
			reset();
			setQueen(1, 0, 7);
//		}
	}

	/**
	 * 放子
	 * 
	 * @param queen
	 *            当前在放的子
	 * @param pI
	 *            开始放的横坐标
	 * @param pJ
	 *            开始放的纵坐标
	 */
	private static void setQueen(int queen, int pI, int pJ) {
//		printTest();

		// 放子是否成功
		boolean success = false;
		int i = pI >= 0 ? pI : 0;
		int j = pJ >= 0 ? pJ : 0;

		line: for (; i < 8; i++) {
				for (; j < 8; j++) {
					if (queens[i][j] == 0) {
						success = true;
						queens[i][j] = 100 + queen;
						curI = i;
						curJ = j;
	
						// 设置第1子位置
						if (queen == 1) {
							oneI = i;
							oneJ = j;
						}
	
						// 将影响的格增加1
						setOne(true, curI, curJ);
	
						// 放完后，要退出
						break line;
					}
				}
				j = 0;
			  }

		// 下一子开始放的坐标
		int nextI = curI;
		int nextJ = curJ;
		if (success) { // 如果放子成功
			if (queen >= 8) {
				printResult();
				// 将最后一子拿掉, 将影响的格减少1
				queens[curI][curJ] = 0;
				setOne(false, curI, curJ);
			} else {
				queen = queen + 1;
			}
			// 将位置向前移动一格
			if (nextJ < 7) {
				nextJ += 1;
			} else if (nextI < 7) {
				nextI += 1;
				nextJ = 0;
			} else {
				// 如果向前移动已到最后
				return;
			}
		} else { // 如果放子失败，说明方案错误 ，重置
			queen = queen - 1;
			//将要放的子拿掉
			int tempK = 0;
			int tempL = 0;
			line: for(int k = 0; k < 8; k ++){
					for(int l = 0; l < 8; l ++){
						if(queens[k][l] == 100 + queen){
							queens[k][l] = 0;
							tempK = k;
							tempL =l;
							break line;
						}
					}
				  }
			// 将影响的格减少1
			setOne(false, tempK, tempL);
			// 将位置向前移动一格
			if (tempL < 7) {
				tempL += 1;
			} else if (tempK < 7) {
				tempK += 1;
				tempL = 0;
			} else {
				// 如果向前移动已到最后
				return;
			}
			nextI = tempK;
			nextJ = tempL;
		}
		setQueen(queen, nextI, nextJ);
	}

	/**
	 * 重置
	 */
	private static void reset() {
		// 最近一子位置
		curI = -1;
		curJ = -1;
		
		oneI = -1;
		oneJ = -1;
		
		// 初始化
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 8; j++) {
				queens[i][j] = 0;
			}
		}
	}

	/**
	 * 打印结果
	 */
	private static void printResult() {
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
		System.out.println("==============================================" + oneI + "--" + oneJ);
	}

	/**
	 * 将影响的格设置为1
	 * isSet: 是否放子。 true: 放子； false: 拿子
	 */
	private static void setOne(boolean isSet, int x, int y) {
		// 将当前子所影响的格置为1
		// 处理当前行
		for (int k = 0; k < 8; k++) {
			if (k != y) {
				if (queens[x][k] < 100) {
					if(isSet){
						queens[x][k] += 1;
					} else {
						if(queens[x][k] >= 1){
							queens[x][k] -= 1;
						}
					}
				}
			}
		}
		// 处理当前列
		for (int k = 0; k < 8; k++) {
			if (k != x) {
				if (queens[k][y] < 100) {
					if(isSet){
						queens[k][y] += 1;
					} else {
						if(queens[k][y] >= 1){
							queens[k][y] -= 1;
						}
					}
				}
			}
		}
		// 处理左上角斜线
		int topLeftI = x;
		int topLeftJ = y;
		while (true) {
			topLeftI -= 1;
			topLeftJ -= 1;
			if (topLeftI < 0 || topLeftJ < 0) {
				break;
			}
			if (queens[topLeftI][topLeftJ] < 100) {
				if(isSet){
					queens[topLeftI][topLeftJ] += 1;
				} else {
					if(queens[topLeftI][topLeftJ] >= 1){
						queens[topLeftI][topLeftJ] -= 1;
					}
				}
			}
		}
		// 处理右下角斜线
		topLeftI = x;
		topLeftJ = y;
		while (true) {
			topLeftI += 1;
			topLeftJ += 1;
			if (topLeftI > 7 || topLeftJ > 7) {
				break;
			}
			if (queens[topLeftI][topLeftJ] < 100) {
				if(isSet){
					queens[topLeftI][topLeftJ] += 1;
				} else {
					if(queens[topLeftI][topLeftJ] >= 1){
						queens[topLeftI][topLeftJ] -= 1;
					}
				}
			}
		}
		// 处理右上角斜线
		topLeftI = x;
		topLeftJ = y;
		while (true) {
			topLeftI -= 1;
			topLeftJ += 1;
			if (topLeftI < 0 || topLeftJ > 7) {
				break;
			}
			if (queens[topLeftI][topLeftJ] < 100) {
				if(isSet){
					queens[topLeftI][topLeftJ] += 1;
				} else {
					if(queens[topLeftI][topLeftJ] >= 1){
						queens[topLeftI][topLeftJ] -= 1;
					}
				}
			}
		}
		// 处理左下角斜线
		topLeftI = x;
		topLeftJ = y;
		while (true) {
			topLeftI += 1;
			topLeftJ -= 1;
			if (topLeftI > 7 || topLeftJ < 0) {
				break;
			}
			if (queens[topLeftI][topLeftJ] < 100) {
				if(isSet){
					queens[topLeftI][topLeftJ] += 1;
				} else {
					if(queens[topLeftI][topLeftJ] >= 1){
						queens[topLeftI][topLeftJ] -= 1;
					}
				}
			}
		}
	}

	/**
	 * 打印中间结果，用于测试
	 */
	private static void printTest() {
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
		System.out.println("-----------------------------");
	}
}
