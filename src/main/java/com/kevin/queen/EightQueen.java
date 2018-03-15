package com.kevin.queen;

/**
 * company: 我修改company内容
 * @author Kevin Zhang @Date 2018年3月14日 下午8:13:19
 * master增加点内容
 */
public class EightQueen {
	static int[][] queens = new int[8][8];
	// 最近一子位置
	static int curI = -1;
	static int curJ = -1;
	// 第1子位置
	static int oneI = -1;
	static int oneJ = -1;

	static int times = 0;

	// 总答案集合
	static int[][][] total = new int[92][8][8];
	static int[][] flag = new int[92][1];

	public static void main(String[] args) {
		for (int i = 0; i < 8; i++) {
			reset();
			setQueen(1, 0, i);
		}
		// 求出独立解
		// 初始化标识位
		for (int i = 0; i < 92; i++) {
			flag[i][0] = 1;
		}
		// 去重
		int resultOne = 0;
		int[][] temp = new int[8][8];
		for (int time = 0; time < 92; time++) {
			if (flag[time][0] == 1) {
				// 拿出结果
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						temp[i][j] = total[time][i][j];
					}
				}
				// 打印结果
				resultOne++;
				System.out.println("独立:" + resultOne);
				printResultOnly(temp);

				// 转换
				int[][] tsfResultEast = transferEast(temp);
				int[][] tsfResultSouth = transferSouth(temp);
				int[][] tsfResultWest = transferWest(temp);
				//翻过来
				int[][] contrast = contrast(temp);
				int[][] contrastEast = transferEast(contrast);
				int[][] contrastSouth = transferSouth(contrast);
				int[][] contrastWest = transferWest(contrast);
				
				//对比
				for(int timeTemp = time + 1; timeTemp < 92; timeTemp++){
					boolean same = true;
					isSame: for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							if(total[timeTemp][i][j] != tsfResultEast[i][j]){
								same = false;
								break isSame;
							}
						}
					}
					if(same){
						flag[timeTemp][0] = 0;
					}
					
					same = true;
					isSame: for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							if(total[timeTemp][i][j] != tsfResultSouth[i][j]){
								same = false;
								break isSame;
							}
						}
					}
					if(same){
						flag[timeTemp][0] = 0;
					}
					
					same = true;
					isSame: for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							if(total[timeTemp][i][j] != tsfResultWest[i][j]){
								same = false;
								break isSame;
							}
						}
					}
					if(same){
						flag[timeTemp][0] = 0;
					}
					
					same = true;
					isSame: for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							if(total[timeTemp][i][j] != contrast[i][j]){
								same = false;
								break isSame;
							}
						}
					}
					if(same){
						flag[timeTemp][0] = 0;
					}
					
					same = true;
					isSame: for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							if(total[timeTemp][i][j] != contrastEast[i][j]){
								same = false;
								break isSame;
							}
						}
					}
					if(same){
						flag[timeTemp][0] = 0;
					}
					
					same = true;
					isSame: for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							if(total[timeTemp][i][j] != contrastSouth[i][j]){
								same = false;
								break isSame;
							}
						}
					}
					if(same){
						flag[timeTemp][0] = 0;
					}
					
					same = true;
					isSame: for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							if(total[timeTemp][i][j] != contrastWest[i][j]){
								same = false;
								break isSame;
							}
						}
					}
					if(same){
						flag[timeTemp][0] = 0;
					}
				}
			}
		}
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
		// printTest();

		// 放子是否成功
		boolean success = false;
		int i = pI >= 0 ? pI : 0;
		int j = pJ >= 0 ? pJ : 0;

		line: for (; i < 8; i++) {
			for (; j < 8; j++) {
				if (queens[i][j] == 0 && i == queen - 1) {
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
				times++;
				printResult(queens);
				// 将最后一子拿掉, 将影响的格减少1
				queens[curI][curJ] = 0;
				setOne(false, curI, curJ);
				// 如果最后一子，刚好放在最后一格
				if (curI == 7 && curJ == 7) {
					queen = queen - 1;
					int[] result = previous(queen);
					nextI = result[1];
					nextJ = result[2];
				}
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
			if (queen <= 1) {
				return;
			}

			// 将要放的子拿掉
			int[] results = previous(queen);
			// 如果向前移动已到最后
			if (results[0] == 0) {
				return;
			}

			nextI = results[1];
			nextJ = results[2];
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
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				queens[i][j] = 0;
			}
		}
	}

	/**
	 * 打印结果
	 */
	private static void printResult(int[][] result) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (result[i][j] > 100) {
					total[times - 1][i][j] = 1;
					System.out.print(result[i][j] + "      ");
				} else {
					total[times - 1][i][j] = 0;
					System.out.print(result[i][j] + "        ");
				}
			}
			System.out.println("");
		}
		System.out.println("==============================================  " + times);
	}
	
	/**
	 * 打印独立解
	 * @param result
	 */
	private static void printResultOnly(int[][] result) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(result[i][j] + "        ");
			}
			System.out.println("");
		}
	}
	
	

	/**
	 * 将影响的格设置为1 isSet: 是否放子。 true: 放子； false: 拿子
	 */
	private static void setOne(boolean isSet, int x, int y) {
		// 将当前子所影响的格置为1
		// 处理当前行
		for (int k = 0; k < 8; k++) {
			if (k != y) {
				if (queens[x][k] < 100) {
					if (isSet) {
						queens[x][k] += 1;
					} else {
						if (queens[x][k] >= 1) {
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
					if (isSet) {
						queens[k][y] += 1;
					} else {
						if (queens[k][y] >= 1) {
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
				if (isSet) {
					queens[topLeftI][topLeftJ] += 1;
				} else {
					if (queens[topLeftI][topLeftJ] >= 1) {
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
				if (isSet) {
					queens[topLeftI][topLeftJ] += 1;
				} else {
					if (queens[topLeftI][topLeftJ] >= 1) {
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
				if (isSet) {
					queens[topLeftI][topLeftJ] += 1;
				} else {
					if (queens[topLeftI][topLeftJ] >= 1) {
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
				if (isSet) {
					queens[topLeftI][topLeftJ] += 1;
				} else {
					if (queens[topLeftI][topLeftJ] >= 1) {
						queens[topLeftI][topLeftJ] -= 1;
					}
				}
			}
		}
	}

	/**
	 * 将上一子拿掉
	 */
	public static int[] previous(int queen) {
		int[] result = new int[3];
		result[0] = 1;

		// 将要放的子拿掉
		int tempK = 0;
		int tempL = 0;
		line: for (int k = 0; k < 8; k++) {
			for (int l = 0; l < 8; l++) {
				if (queens[k][l] == 100 + queen) {
					queens[k][l] = 0;
					tempK = k;
					tempL = l;
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
			result[0] = 0;
		}

		result[1] = tempK;
		result[2] = tempL;

		return result;
	}

	/**
	 * 将矩阵进行旋转:东
	 */
	private static int[][] transferEast(int[][] temp) {
		int[][] result = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				result[j][8 - 1 - i] = temp[i][j];
			}
		}
		return result;
	}
	
	/**
	 * 将矩阵进行旋转: 南
	 */
	private static int[][] transferSouth(int[][] temp) {
		int[][] result = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				result[8 - 1 - i][8 - 1 - j] = temp[i][j];
			}
		}
		return result;
	}
	
	/**
	 * 将矩阵进行旋转: 西
	 */
	private static int[][] transferWest(int[][] temp) {
		int[][] result = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				result[8 - 1 - j][i] = temp[i][j];
			}
		}
		return result;
	}
	
	/**
	 * 翻过来
	 */
	private static int[][] contrast(int[][] temp) {
		int[][] result = new int[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				result[i][8 - 1 - j] = temp[i][j];
			}
		}
		return result;
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
