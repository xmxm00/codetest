# https://www.acmicpc.net/problem/4673

def constructor(n):
  nums = list(map(int,list(str(n))))
  return n + sum(nums)

selfNumList = [0] * 10001

for i in range(10000):
  index = constructor(i)
  if index > 10000:
    continue
  selfNumList[index] = selfNumList[index] + 1

for i in range(10001):
  if selfNumList[i] == 0:
    print(i)