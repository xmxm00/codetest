# https://www.acmicpc.net/problem/9663

# n = int(input())

chessMap = [[0]*8] * 8
print(chessMap)

while True:
  i,j = map(int, input().split())
  for n in range(8):
    print("({}, {}), ({}, {})".format(i, n, n, j))
    print(chessMap[i][n])
    print(chessMap[n][j])

  print(chessMap)