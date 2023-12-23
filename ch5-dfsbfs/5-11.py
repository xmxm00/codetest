# 미로 탈출
from collections import deque

maze = []
[n,m] = map(int, input().split())

for i in range(n):
  maze.append(list(map(int, input())))

def bfs(maze, n, m):
  i = 0
  j = 0
  result = 1
  queue = deque()
  queue.append([i,j,result])
  while i != n-1 or j != m-1:
    [i, j, result] = queue.popleft()
    maze[i][j] = 0
    if i > 0 and maze[i-1][j] == 1:
      queue.append([i-1, j, result + 1])
    if i < n-1 and maze[i+1][j] == 1:
      queue.append([i+1, j, result + 1])
    if j > 0 and maze[i][j-1] == 1:
      queue.append([i, j-1, result + 1])
    if j < m-1 and maze[i][j+1] == 1:
      queue.append([i, j+1, result + 1])
  
  return result


print(bfs(maze, n, m))
    





