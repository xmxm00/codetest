# DFS 예제

from collections import deque

def dfs(graph, v, visited):
  print("{} ".format(v), end="")
  visited[v] = True
  for node in graph[v]:
    if not visited[node]:
      dfs(graph, node, visited)

def bfs(graph, start, visited):
  queue = deque()
  queue.append(start)
  visited[start] = True
  while True:
    if len(queue) <= 0:
      break
    cur = queue.popleft()
    print(cur, end=" ")
    for node in graph[cur]:
      if not visited[node]:
        visited[node] = True
        queue.append(node)



graph = [
  [],
  [2,3,8],
  [1,7],
  [1,4,5],
  [3,5],
  [3,4],
  [7],
  [2,6,8],
  [1,7]
]

visited = [False] * 9

dfs(graph, 1, visited)
print()

visited = [False] * 9
bfs(graph, 1, visited)
print()