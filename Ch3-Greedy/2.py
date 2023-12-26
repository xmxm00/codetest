n, m = map(int, input().split())
cards = []
for i in range(n):
    cards.append(min(list(map(int, input().split()))))

print(max(cards))