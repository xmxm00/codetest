[x, y] = input()
x = ord(x) - ord('a') + 1
y = int(y)
dx = [-2, -2, 2, 2, -1, 1, -1, 1]
dy = [-1, 1, -1, 1, -2, -2, 2, 2]

count = 0
for i in range(8):
    if x + dx[i] >= 1 and x + dx[i] <= 8 and y + dy[i] >= 1 and y + dy[i] <= 8:
        count += 1

print(count)