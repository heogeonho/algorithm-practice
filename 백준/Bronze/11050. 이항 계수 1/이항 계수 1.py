import sys
input = sys.stdin.readline

def factorial(num):
    result = 1
    for i in range(1, num + 1):
        result = result * i
    return result

N, K = map(int, input().split())

print(int(factorial(N) / (factorial(N-K) * factorial(K))))
