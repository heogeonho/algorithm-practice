import sys
input = sys.stdin.readline

N = int(input())
list = []

for i in range(N):
    age, name =  input().split()
    list.append([int(age), name])
    
list.sort(key=lambda x:x[0])
for i in list:
    print(*i)
