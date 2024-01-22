import sys
input = sys.stdin.readline
INF = int(1e9)
n = int(input()) # num of nodes
m = int(input()) # num of edges

graph = [[INF]*(n+1) for i in range(n+1)]
for a in range(1, n+1):
  graph[a][a] = 0

for _ in range(m):
  a, b, c = map(int, input().split())
  graph[a][b] = c

for k in range(1, n+1):
  for a in range(1, n+1):
    for b in range(1, n+1):
      graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

print([x[1:] for x in graph[1:]])
