import sys
input = sys.stdin.readline
 
n, m = map(int, input().split())
arr = list(map(int, input().split()))
prefix_sum = [0]

temp = 0
for i in arr:
    temp += i
    prefix_sum.append(temp)
    
for k in range(m):
    i, j = map(int, input().split())
    print(prefix_sum[j] - prefix_sum[i-1])