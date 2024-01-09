def mySum(k):
    i = 1
    result = 0
    while result < k:
        result += i
        i += 1
    print("{}, {}".format(i-1, k - result + i - 1))
    return i-1

s, e = map(int, input().split())

s_coord = [mySum(s)]
e_coord = [mySum(e)]