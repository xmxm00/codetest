# https://www.acmicpc.net/problem/11729

n = int(input())

def hanoi(a, start, end, middle):
  if a == 1:
    print(start, end)
  else:
    hanoi(a-1, start, middle, end)
    print(start, end)
    hanoi(a-1, middle, end, start)

print(2**n - 1)
hanoi(n, 1, 3, 2)