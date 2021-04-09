package random_quiz;

import java.util.Arrays;
//数字当てクイズ

public class MainQuiz {
	//メインメソッド
	public static void main(String[] args) {
		//当てる桁数を設定
		int digit = 4;

		//問題の説明を表示
		System.out.println("【重複しない"+digit+"桁の整数を当てるゲームです】");
		System.out.println("〇＝場所も一致");
		System.out.println("△＝どれかが一致");
		System.out.println("×＝一致していない");

		//ランダムな整数配列randomArrayを宣言
		int[] randomArray =Array.makeRandomArray(digit);

		//正解数をカウントする変数
		int count = 1;

		//正解になるまで回した数をカウントし、間違えている間はHintメソッドを呼ぶ
		while (true) {
			System.out.println(digit +"桁の整数を入力してください");

			//digit桁の整数を受け取って、桁を分解して配列enteredArrayにする
			int[] enteredArray = Array.makeIntArray(digit);

			//配列同士が同じ時、while文をブレイク
			if (Arrays.equals(enteredArray, randomArray) == true) {
				break;

			//配列同士が異なる時、ヒントメソッドを呼び出す
			} else {
				Hint.hint(enteredArray, randomArray);
			}

			//breakしないときにカウントを一つ増やす
			count++;
		}
		System.out.println(count + "回で正解です！！");
	}
}

class Array {
	//重複しない一桁の整数の配列を返すメソッド（digitは配列の要素数）
	public static int[] makeRandomArray(int digit) {

		//要素数digitの配列sを用意
		int[] s = new int[digit];

		//１～９のランダムな数を配列の先頭に入れる
		s[0] = new java.util.Random().nextInt(9) + 1;

		//配列の2つ目以降の要素を調べる
		for (int i = 1; i < s.length; i++) {

			//配列のi番目にランダムな値を代入する
			s[i] = new java.util.Random().nextInt(9) + 1;

			//最初の配列（start番目）とi番目の配列を比較する
			for (int start = 0; start < i; start++) {

				//start番目とi番目の要素が同じとき、iを1つ戻して、ランダムな値をもう一度代入する
				if(s[start]==s[i]) {
					i--;
				}
/*過去のコード  //配列内の要素を比較して同じときは要素を戻して再検証する
//				if (i > 0 && s[i] == s[i - 1]) {
//					i--;
//				} else if (i > 1 && s[i] == s[i - 2]) {
//					i--;
//				} else if (i > 2 && (s[i] == s[i - 3] || s[i - 1] == s[i - 2])) {
//					i--;
//				}
*/			}
		}
		//配列sを返す
		return s;
	}

	//digit桁数の「桁の数」を要素とする配列を返すメソッド
	public static int[] makeIntArray(int digit) {

		//入力された数値を変数inに代入する
		int in = new java.util.Scanner(System.in).nextInt();

		//要素数digitの配列ｓを宣言する
		int[] s = new int[digit];

		//先頭の桁から順に、10の余りを配列sに代入していく
		for(int i = digit -1; i >=0; i--) {
			 s[i] =in % 10;
			 in = in / 10;
		}
		return s;
	}
}
class Hint{
	//2つの配列を引数に入れると、[〇×△×]などのヒントを表示させるメソッド
	public static void hint(int [] a, int []b) {

		//〇×△を格納する配列cを宣言
		String[] c = new String[a.length];

		//配列aと配列bの要素を二重配列で比較して、配列cに格納する
		for(int i = 0; i < a.length ;i ++) {
			for(int j = 0;j < a.length;j++) {
				//場所も数字も同じなら、配列cに〇を格納
				if (a[i]==b[i]) {
					c[i] = "〇";
					break;
				//数字がどこかで一致するときに、配列cに△を格納
				}else if(a[i]==b[j] ){
					c[i] = "△";
					break;
				//それ以外の場合は、×を格納
				}else {
					c[i] = "×";
				}
			}
		}
		//配列ｃの要素を表示する
		for(String value : c) {
				System.out.print(value);

		}
		System.out.println("");
	}
}
