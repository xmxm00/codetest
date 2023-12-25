# https://www.acmicpc.net/problem/7576

# 1: 익은 토마토, 0: 익지 않은 토마토, -1: 없는 칸
from collections import deque

def checkComplete(box):
  for line in box:
    if 0 in line:
      return False
  
  return True

m, n = map(int, input().split())
box = []
for i in range(n):
  box.append(list(map(int, input().split())))

queue = deque()

di = [-1, 1, 0, 0]
dj = [0, 0, -1, 1]

for i in range(n):
  for j in range(m):
    box[i][j] == 1 and queue.append([i,j])

result = 0
while queue:
  result += 1
  tmp = deque()
  for k in range(len(queue)):
    i, j = queue.popleft()
    for k in range(4):
      ni = i+di[k]
      nj = j+dj[k]
      if ni >= 0 and nj >= 0 and ni < n and nj < m:
        if box[ni][nj] == 0:
          tmp.append([ni,nj])
          box[ni][nj] = 1
  queue = tmp

if checkComplete(box):
  print(result-1)
else:
  print(-1)
