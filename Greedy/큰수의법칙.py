n, m, k = map(int, input().split())
data = list(map(int, input().split()))

data.sort()
result = 0
# 가독성을 위해 자주 사용하는 data[len(data) - 1] 등을 변수로 선언한다.
firstBig = data[len(data)-1]
secondBig = data[len(data)-2]

result += (k * firstBig + secondBig) * (m // (k+1))
m %= k+1

result += firstBig * m

print(result)
