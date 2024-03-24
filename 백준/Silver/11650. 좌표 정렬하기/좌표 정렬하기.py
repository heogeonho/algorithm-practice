import sys
input = sys.stdin.readline

N = int(input())

arr = []
for i in range(N) :
    coordinate = list(map(int, input().split()))
    arr.append(coordinate)

arr.sort()

for point in arr:
    print(*point)