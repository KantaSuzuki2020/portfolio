# portfolio
与えられた設問について、自力で書いたコードです

【Calculation.java】
for文と配列操作がメインのプログラムです。
苦労した点は、インデックスとして変数startを定義し、配列の操作を行っている点です。
特に、pushメソッドにおいて、現在の配列の位置を指定することで、シンプルなfor文で比較的複雑な配列の操作を行っていますが、インデックスの値をどう変化させるかを考えるのに時間がかかりました。

【FileEdit.java】
ファイルを読み込んで、ソースコードにインデントを入れて、ファイルを変更して保存するソースコードです。
BufferedReaderを用いて、ファイルの読み込みと書き込みを行っています。
また、ある特定の文字がいくつ含まれるかを、文字列の長さを元に求めるreplaceメソッドを定義しました。

【MainQuiz.java】【random-quiz.py】
四つの重複しない数字を当てるゲームです。
メインメソッドを含む4つのメソッドに分割してコードを書きました。
3つのメソッドは、①重複しない一桁の整数の配列を返すメソッド
②4桁の数字を配列に格納するメソッド
③配列同士を比較して、同じ場所に同じ数字がある場合は、「○」、場所は違うが同じ数字がある場合は「△」、同じ数字がない場合は「×」を返すメソッド
になっています。
