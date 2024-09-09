# https://www.acmicpc.net/problem/1316

def isGroup(word):
  prev = None
  history = []
  for a in list(word):
    if not prev:
      prev = a
      history.append(a)
      continue
    if prev == a:
      continue
    else:
      if a in history:
        return False
      else:
        prev = a
        history.append(a)
  
  return True

n = int(input())
words = []
for i in range(n):
  words.append(input())

result = 0
for word in words:
  if isGroup(word):
    result += 1

print(result)
