[n, m] = list(map(int, input().split()))
[x, y, dir] = list(map(int, input().split()))
map_data = []

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

for i in range(n):
    map_data.append(list(map(int, input().split())))

result = 0
initial_dir = dir
while True:
    # 1단계
    dir = dir - 1 if dir > 0 else 3
    map_data[x][y] = 2
    if map_data[x+dx[dir]][y+dy[dir]] == 0:
        initial_dir = dir
        x += dx[dir]
        y += dy[dir]
        result += 1
    else:
        if dir == initial_dir:
            if map_data[x-dx[dir]][y-dy[dir]] != 1:
                x -= dx[dir]
                y -= dy[dir]
                result += 1
            else:
                break

print(result)