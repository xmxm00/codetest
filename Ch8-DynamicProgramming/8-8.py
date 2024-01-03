# Ex4

n, m = map(int, input().split())
currency = []
for i in range(n):
  currency.append(int(input()))

# currency.sort()

d = [10001] * (m+1)

d[0] = 0
for i in range(n):
  for j in range(currency[i], m+1):
    if d[j-currency[i]] != 10001:
      d[j] = min(d[j], d[j-currency[i]] + 1)

if d[m] == 10001:
  print(-1)
else:
  print(d[m])