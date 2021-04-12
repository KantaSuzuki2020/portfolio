package keisannki;

import java.util.Scanner;

//一行計算の問題:【1 + 3 * 4 - 1】など、数字と記号の間にスペースを入れて実行すると答えが表示される
public class Calculation {

	public static void main(String[] args) {
		//計算したい式を受け取る
		Scanner sc = new Scanner(System.in);
		String formula = sc.nextLine();

		//受け取った式をスペースで分けて、文字列配列に格納
		String[] str = formula.split(" ");

		//演算子の現在の位置を表す変数startを初期化
		int start = 1;

		//演算子の種類を左から順番に判別する
		for (int i = 1; i < str.length; i += 2) {

			//演算子が「＊」または「/」のとき
			if (str[i].equals("*") || str[i].equals("/")) {

				//str[i-1]は演算子の左の数字, str[i]は演算子,str[i+1]は演算子の右の数字
				//演算子前後の計算の答えを演算子の右の数字の位置に上書きする
				//[1,+,3,*,4,-,1]→[1,+,3,*,12,-,1]
				str[i + 1] = mul(str[i - 1], str[i], str[i + 1]);

				//乗除で飛ばした加算式分の要素を右詰めにする
				//[1,+,3,*,12,-,1]→[1,+,1,+,12,-,1]
				push(str, i, start);

				//乗除が実行されたら、次に計算する演算子の位置を右にずらす
				start += 2;
			}
		}
		//乗除後の式を表示して確認する
		System.out.print("乗除後の式:");
		for (int i = start - 1; i < str.length; i++)
			System.out.print(str[i]);
		System.out.println("");


		//startの位置から残りの計算（加減）をする
		for (int i = start; i < str.length; i += 2) {
			if (str[i].equals("+") || str[i].equals("-")) {
				str[i + 1] = plus(str[i - 1], str[i], str[i + 1]);
			}
		}
		//		System.out.println("");
		//		for(String val : str)
		//			System.out.print(val + ",");
		System.out.print(formula + " = " + str[str.length - 1]);
	}

	//掛け算・割り算メソッド（左の数字、演算子、右の数字、を引数として受け取り、答えを返す）
	public static String mul(String a, String op, String b) {
		int left = Integer.parseInt(a);
		int right = Integer.parseInt(b);
		int ans = 0;
		if (op.equals("*")) {
			ans = left * right;
		} else if (op.equals("/")) {
			ans = left / right;
		}

		//答えを文字列として返す
		String str = String.valueOf(ans);
		return str;
	}

	//足し算・引き算メソッド
	public static String plus(String a, String op, String b) {
		int left = Integer.parseInt(a);
		int right = Integer.parseInt(b);
		int ans = 0;
		if (op.equals("-")) {
			ans = left - right;
		} else if (op.equals("+")) {
			ans = left + right;
		}

		//答えを文字列として返す
		String str = String.valueOf(ans);
		return str;
	}

	//配列を右詰めにするメソッド
	public static String[] push(String[] str, int i, int start) {

		//ｊをstartの位置まで減らして要素を右詰めに上書きしていく
		for (int j = i; j > start; j--) {

			//二つ前の要素をjの位置に格納していく
			//[1,+,2,*,3]→[1,+,1,+,6]
			str[j] = str[j - 2];
		}
		return str;
	}
}
