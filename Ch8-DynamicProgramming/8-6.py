# Ex2

n = int(input())
storage = list(map(int, input().split()))

d = [0] * (n)
d[0] = storage[0]
d[1] = max(storage[0],storage[1])
for i in range(2,n):
  d[i] = max(storage[i] + d[i-2], d[i-1])


print(max(d[n-1]))