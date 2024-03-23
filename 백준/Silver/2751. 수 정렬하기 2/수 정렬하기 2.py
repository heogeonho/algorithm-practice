import sys
input = sys.stdin.readline
N = int(input().strip())

arr = []
for i in range(N):
    arr.append(int(input().strip()))
    
arr.sort()

for i in arr:
    print(i)