# Fibonacci recursive

def fibo(x):
    if x==1 or x==2:
        return 1
    return fibo(x-1) + fibo(x-2)
memo = [0] * 100
def fiboDP(x):
    if x==1 or x==2:
        return 1
    if memo[x] != 0:
        return memo[x]
    memo[x] = fiboDP(x-1) + fiboDP(x-2)
    return memo[x]

print(fibo(99))
print(fiboDP(99))