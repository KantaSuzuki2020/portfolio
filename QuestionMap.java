package portfolio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionMap {
	//｛英単語、正解の対訳、間違いの対訳（3つ）｝を格納するquizリストを生成
	//private List<String> quiz = new ArrayList<>();

	 //難易度をkey、quizリストをvalueとするマップを生成
	private Map<Integer, List<String>> questionMap = new HashMap<>();

	public Map<Integer, List<String>> returnQuestionMap() {


		//questionMapに問題の難易度（key)と問題リスト(value)を追加
		//問題リスト[英単語、正解選択肢、間違い選択肢、、]
		questionMap.put(30, Arrays.asList("dog", "犬", "猫", "鳥", "魚"));
//						System.out.println(questionMap.get(30));
		questionMap.put(31, Arrays.asList("today", "今日", "毎日", "", ""));
		questionMap.put(32, Arrays.asList("", "", "", "", ""));
		questionMap.put(33, Arrays.asList("mother", "母", "父", "モンスター", "山"));
		questionMap.put(34, Arrays.asList("", "", "", "", ""));
		questionMap.put(35, Arrays.asList("bird", "鳥", "猫", "動物", "羽"));
		questionMap.put(36, Arrays.asList("", "", "", "", ""));
		questionMap.put(37, Arrays.asList("", "", "", "", ""));
		questionMap.put(38, Arrays.asList("", "", "", "", ""));
		questionMap.put(39, Arrays.asList("", "", "", "", ""));
		questionMap.put(40, Arrays.asList("", "", "", "", ""));
		questionMap.put(41, Arrays.asList("", "", "", "", ""));
		questionMap.put(42, Arrays.asList("", "", "", "", ""));
		questionMap.put(43, Arrays.asList("", "", "", "", ""));
		questionMap.put(44, Arrays.asList("", "", "", "", ""));
		questionMap.put(45, Arrays.asList("", "", "", "", ""));
		questionMap.put(46, Arrays.asList("", "", "", "", ""));
		questionMap.put(47, Arrays.asList("", "", "", "", ""));
		questionMap.put(48, Arrays.asList("", "", "", "", ""));
		questionMap.put(49, Arrays.asList("", "", "", "", ""));
		questionMap.put(50, Arrays.asList("", "", "", "", ""));
		questionMap.put(51, Arrays.asList("", "", "", "", ""));
		questionMap.put(52, Arrays.asList("diary", "日記", "牛乳", "二つ", "理髪店"));
		questionMap.put(53, Arrays.asList("", "", "", "", ""));
		questionMap.put(54, Arrays.asList("meal", "食事", "", "", ""));
		questionMap.put(55, Arrays.asList("", "", "", "", ""));
		questionMap.put(56, Arrays.asList("", "", "", "", ""));
		questionMap.put(57, Arrays.asList("", "", "", "", ""));
		questionMap.put(58, Arrays.asList("", "", "", "", ""));
		questionMap.put(59, Arrays.asList("", "", "", "", ""));
		questionMap.put(60, Arrays.asList("", "", "", "", ""));
		questionMap.put(61, Arrays.asList("", "", "", "", ""));
		questionMap.put(62, Arrays.asList("", "", "", "", ""));
		questionMap.put(63, Arrays.asList("", "", "", "", ""));
		questionMap.put(64, Arrays.asList("", "", "", "", ""));
		questionMap.put(65, Arrays.asList("", "", "", "", ""));
		questionMap.put(66, Arrays.asList("", "", "", "", ""));
		questionMap.put(67, Arrays.asList("", "", "", "", ""));
		questionMap.put(68, Arrays.asList("", "", "", "", ""));
		questionMap.put(69, Arrays.asList("", "", "", "", ""));
		questionMap.put(70, Arrays.asList("", "", "", "", ""));
		questionMap.put(71, Arrays.asList("", "", "", "", ""));
		questionMap.put(72, Arrays.asList("", "", "", "", ""));
		questionMap.put(73, Arrays.asList("", "", "", "", ""));
		questionMap.put(74, Arrays.asList("", "", "", "", ""));
		questionMap.put(75, Arrays.asList("", "", "", "", ""));
		questionMap.put(76, Arrays.asList("", "", "", "", ""));
		questionMap.put(77, Arrays.asList("", "", "", "", ""));
		questionMap.put(78, Arrays.asList("", "", "", "", ""));
		questionMap.put(79, Arrays.asList("", "", "", "", ""));
		questionMap.put(80, Arrays.asList("", "", "", "", ""));
		return questionMap;
	}
	public boolean makeQuestionMap(int level, String[] question) {
		if(questionMap.get(level) != null) {
			return false;
		}else {
			List<String> quiz = new ArrayList<String>();
			Collections.addAll(quiz, question);
			questionMap.put(level, quiz);
			return true;
		}

	}
}
