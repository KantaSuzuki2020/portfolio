package practice_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//ファイルを読み込んでインデントをつける問題
public class FileEdit {
	public static int replace(String str, char target){
	    return str.length() - str.replace(target + "", "").length();
	}
	public static void main(String[] args) {
//		BufferedReaderのtry・catch
		try {

			// ファイルのパスを指定する
			File file = new File("c:\\ファイル\\test.txt");

			// FileWriterクラスで新規作成するファイルを指定
			FileWriter newfile = new FileWriter("c:\\ファイル\\Bb.java");

	        // PrintWriterクラスを使用する
	        PrintWriter pw = new PrintWriter(new BufferedWriter(newfile));

			// ファイルが存在しない場合に例外が発生するので確認する
			if (!file.exists()) {
				System.out.print("ファイルが存在しません");
				return;
			}

			// BufferedReaderクラスのreadLineメソッドを使って1行ずつ読み込み表示する
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			//読み込んだ行を代入するためのString型の変数を用意
			String data;

			//必要なインデントの個数を数える変数
			int count = 0;

			//行がnullになるまで文字を読み込む
			while ((data = bufferedReader.readLine()) != null) {
				count -= replace(data, '}');

				//countの数に応じて、dataの先頭にインデントを入れる

				for (int i = 0; i <= count - 1; i++) {
					data = "\t" + data;
				}

				System.out.println(data);
				pw.println(data);

//				switch(count) {
//				case 0:
//					System.out.println(data);
//					pw.println(data);
//					break;
//				case 1:
//					System.out.println("\t" + data);
//					pw.println("\t" + data);
//					break;
//				case 2:
//					System.out.println("\t" +"\t" + data);
//					pw.println("\t" + "\t" +data);
//					break;
//				case 3:
//					System.out.println("\t" +"\t" +"\t" + data);
//					pw.println("\t" +"\t" +"\t" + data);
//					break;
//				case 4:
//					System.out.println("\t" +"\t" +"\t" +"\t" + data);
//					pw.println("\t" +"\t" +"\t" +"\t" + data);
//					break;
//				}

//				if(data.contains("}")||data.contains("{")) {
				//文字列に「｝」が含まれる数だけカウントを減らす
					//文字列に「｛」が含まれる数だけカウントを増やす
					count += replace(data, '{');
//				}
			}
//			if (newfile.createNewFile()){
//			        System.out.println("ファイルの作成に成功しました");
//			      }else{
//			        System.out.println("ファイルの作成に失敗しました");
//			      }

			// ファイルを閉じる
			bufferedReader.close();
			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}