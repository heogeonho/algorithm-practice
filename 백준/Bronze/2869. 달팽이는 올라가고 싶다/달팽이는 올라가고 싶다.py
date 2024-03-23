import sys
input = sys.stdin.readline

A, B, V = map(int, input().split())

if((V-B)%(A-B)==0):
    result = (V-B)//(A-B)
else:
    result = (V-B)//(A-B) + 1

print(result)

