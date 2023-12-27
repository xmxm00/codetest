from collections import deque
maze = []

n,m = map(int, input().split())

for i in range(n):
  maze.append(list(map(int, input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def solve():
  i = 0
  j = 0
  result = 1
  maze[0][0] = result
  queue = deque([[i,j]])
  while queue:
    [i, j] = queue.popleft()
    print(i,j)
    result = maze[i][j] + 1
    for a in range(4):
      nx = i+dx[a]
      ny = j+dy[a]
      if nx >= 0 and nx < n and ny >= 0 and ny < m and maze[nx][ny] == 1:
        queue.append([nx,ny])
        maze[nx][ny] = result
    print(queue)
  
  return maze[n-1][m-1]


print(solve())
for k in maze:
  print(k)