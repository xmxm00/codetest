n, m = map(int, input().split())
data = []
# for i in range(n):
#     tmp = list(map(int, input().split()))
#     tmp.sort()
#     data.append(tmp)

# result = data[0][0]
# for i in range(len(data)):
#     if (data[i][0] > result):
#         result = data[i][0]

result = 0
# 한 줄마다의 최소값을 찾고, 그것이 가장 큰 것을 기록한다.
for i in range(n):
    data = list(map(int, input().split()))
    min_value = min(data)
    if min_value > result:
        result = min_value

print(result)


