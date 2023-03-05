coins = [500, 100, 50, 10]

money = int(input("Input: "))

count = 0
for coin in coins:  # JavaScript의 for...of문과 같이, Python에는 for...in 문법을 활용할 수 있다.
    count += money // coin  # 몫을 구할 땐 "//" 를 이용
    money = money % coin

print(count)
