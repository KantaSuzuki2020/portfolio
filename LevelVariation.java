package portfolio;

public class LevelVariation {

	public static void main(String[] args) {
		int minus = -2;
		int plus = 3;
		int level = 50;
		int count = 4;
		int row = (int) Math.pow(2, count);
		System.out.println(row);
		int[][] lvl = new int[10][row];
		lvl[0][0] = 50;
		lvl = evaluate(lvl);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < count; j++) {
				System.out.println(lvl[j][i]);
			}
			System.out.println("");
		}


	}

	static int[][] evaluate(int[][] level) {
		int i = 0;
		if(i == 10) {
			return level;
		}
		for(int j = 0; j < level[i].length; j++) {
			level[i + 1][j * 2] = level[i][j] - 2;
			level[i + 1][j * 2 + 1] = level[i][j] + 3;
			i++;
		}
		return evaluate(level);
	}

}
