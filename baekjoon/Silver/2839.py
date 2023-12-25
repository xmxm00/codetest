# https://www.acmicpc.net/problem/2839

def solve(n):
  k = n // 5
  for i in range(k, -1, -1):
    remain = n - 5*i
    if remain % 3 == 0:
      return int(i + (remain / 3))
  
  return -1

n = int(input())
print(solve(n))