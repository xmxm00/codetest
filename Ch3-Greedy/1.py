[n, m, k] = list(map(int,input().split()))
array = sorted(list(map(int, input().split())))
first, second = array[len(array) - 1], array[len(array) - 2]
print((k * first + second) * (m // (k+1)) + ((m % (k + 1)) * first))