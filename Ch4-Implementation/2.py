
n = int(input())

def my_solution(n):
    # 0시 0분 0초부터 n시 59분 59초까지 3이 들어간 경우
    # 3, 13, 23, 33, 43, 53, 30,31,32,34,35,36,37,38,39 => 15
    # 3시, 13시, 23시에는 3600번
    # 그 외에는 360 + 56 * 6
    NORMAL_COUNT = 15 * 60 + 45 * 15
    SPECIAL_COUNT = 3600

    if n < 3:
        result = NORMAL_COUNT * (n+1)
    elif n < 13:
        result = NORMAL_COUNT * (n) + SPECIAL_COUNT
    elif n < 23:
        result = NORMAL_COUNT * (n-1) + SPECIAL_COUNT * 2
    else:
        result = NORMAL_COUNT * (n-2) + SPECIAL_COUNT * 3
    print(result)

def brute_force(n):
    count = 0
    for h in range(n+1):
        for m in range(60):
            for s in range(60):
                if '3' in str(h)+str(m)+str(s):
                    count += 1
    
    print(count)

# my_solution(n)
brute_force(n)