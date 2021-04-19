import random

"""
ランダムな重複しない数字を当てるクイズ
入力は、1234などスペースや「、」などのない数字

場所も数字も同じ場合は○
場所は違うが数字が同じ場合は×
数字がまったく一致しない場合は△
が表示される
関数四つと最後の4行がメインの呼び出しコード
"""

# 重複しないランダムなリストを返す関数
# 引数は、（桁数、最初の数字、最後の数字）です。
# 引数が(4,1,9)なら[1,4,9,6]、引数が(3,2,7)なら、[3,6,2]など
def makeRandNum(digit, first, last):
    # リストrandLに最初の数字から最後の数字を順に格納する
    randL = []
    for i in range(first, last):
        randL.append(i)
    # リストrandにリストrandLから指定桁数分ランダムに数値を格納する
    rand = random.sample(randL, digit)
    # print(rand)
    return rand

# 受け取った数値をリストに入れる関数
def receiveNum():
    sNum = input("数字を入力してください")
    rNum = []

    # 受け取った値がすべて数値だったときにリストに格納する
    for i in range(len(sNum)):
        if sNum[i].isnumeric():
            rNum.append(int(sNum[i]))
        else:
            print("数値を入力してください")
            break
    print(rNum)
    return rNum

# 二つの数値リストを比較してヒントとなるリストを返す関数
def judgeList(rand, rNum):
    hint = []
    for i in range(len(rand)):
        for j in range(len(rand)):
            # 場所と数字が同じとき
            if rand[i] == rNum[i]:
                hint.append("○")
                break
            # 場所は違うが、同じ数字を含むとき
            if rand[j] == rNum[i]:
                hint.append("△")
                break
        # 上記の条件をすべて満たさないとき
        else: hint.append("×")
    print(hint)
    return hint

# 正解するまで値を受け取る関数
def untilEqual(rand, hint):
    # countで正解までかかった回数をカウントする
    count = 1

    #　リストhintの中の"○"の数と、hintの長さが同じときにwhileを抜ける
    while hint.count("○") != len(hint):
        # receiveNum()とjudgeList()を呼び出す
        rNum = receiveNum()
        hint = judgeList(rand, rNum)
        count += 1
    print(count, "回で正解です!")
        
# ランダムなリストを作成。桁数に4を指定
digit = 4
rand = makeRandNum(digit,1,9)
# 最初のトライ
rNum = receiveNum()
hint = judgeList(rand, rNum)
# 正解するまで繰り返す
untilEqual(rand,hint)
            
    
