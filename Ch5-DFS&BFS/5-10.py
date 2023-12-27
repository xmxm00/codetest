# 음료수 얼려 먹기  
result = 0

[n, m] = map(int, input().split())
ice_maker = []
for i in range(n):
  ice_maker.append(list(map(int,input())))

def dfs(table, i, j):
  if i < 0 or i >= n or j < 0 or j >= m:
    return False
  
  if table[i][j] == 0:
    table[i][j] = 1
    dfs(table, i+1, j)
    dfs(table, i-1, j)
    dfs(table, i, j+1)
    dfs(table, i, j-1)
    return True
  return False


for i in range(n):
  for j in range(m):
    if ice_maker[i][j] == 0:
      if dfs(ice_maker, i, j):
        result += 1


print(result)