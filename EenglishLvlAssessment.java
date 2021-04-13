package portfolio;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EenglishLvlAssessment {
	public static void main(String[] args) {
		QuestionMap qm = new QuestionMap();
		Map<Integer, List<String>> questionMap = qm.returnQuestionMap();

		//questionMapを全て表示
		//		 for (Entry<Integer, List<String>> entry : questionMap.entrySet()) {
		//	            System.out.println("レベル："+entry.getKey() + " : " + entry.getValue());
		//	        }

		int level = 30;
		int answerLength = 4;

		for (int k = 0; k < 10; k++) {

			String answer = questionMap.get(level).get(1);
			String question = questionMap.get(level).get(0);
			String[] wrongAns = new String[answerLength];
			int random = (int) (Math.random() * answerLength + 1);
			wrongAns[0] = questionMap.get(level).get(random);
			for (int i = 1; i < wrongAns.length; i++) {
				random = (int) (Math.random() * answerLength + 1);
				wrongAns[i] = questionMap.get(level).get(random);
				for (int j = 0; j < i; j++) {
					if (wrongAns[j].equals(wrongAns[i])) {
						i--;
						break;
					}
				}
			}
			System.out.println("問題" + k + 1 + ": " + question);
			for (int i = 0; i < wrongAns.length; i++) {
				System.out.print(i + 1 + ":" + wrongAns[i] + " ");
			}
			//		 System.out.println("  答え:" + answer);
			Scanner sc = new Scanner(System.in);
			int line = sc.nextInt();
			if (wrongAns[line - 1].equals(answer)) {
				System.out.println("正解！");
				level += 3;
			} else {
				System.out.println("不正解！");
				level -= 2;
			}
		}
		System.out.println("単語レベル：" + level + "です！");

		//		System.out.println("問題："+questionMap.get(30).get(0));
		//		System.out.print("選択肢："
		//				+ ""+questionMap.get(30).get(1) + ", "+ questionMap.get(30).get(2)
		//				+ ", "+ questionMap.get(30).get(3)+", "+questionMap.get(30).get(4));

	}
}
