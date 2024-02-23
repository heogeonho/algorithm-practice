from collections import deque

N, M = map(int,input().split())
index = list(map(int,input().split()))
data = deque([i for i in range(1,N+1)])
# data = [1,2,3 ... ,n]

count = 0
for num in index :
    while True :
        if data[0] == num :
            data.popleft()
            break
        else :
            if data.index(num) <= len(data)//2 :
                data.rotate(-1)
                count += 1
            else :
                data.rotate(1)
                count += 1
                
print(count)