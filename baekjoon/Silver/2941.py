# https://www.acmicpc.net/problem/2941

croatia = ["c=", "c-", "dz", "d-", "lj", "nj", "s=", "z="] # "dz" 체크 후 다음이 "="인지 확인

input = list(input())
length = len(input)
result = 0

i = 0
while True:
  if i+1 > length-1:
    break
  sub = ''.join(input[i:i+2])
  if sub in croatia:
    if sub == croatia[2]:
      if i+2 < length and input[i+2] == "=":
        i += 3
      else:
        i += 2
        result += 1
    else:
      i += 2
  else:
    i += 1
  result += 1

if i < length:
  result += length - i

print(result)