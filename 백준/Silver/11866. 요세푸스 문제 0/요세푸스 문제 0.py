import queue

N, K = map(int, input().split())
que = queue.Queue()
li = []

for i in range(1, N + 1):
    que.put(i)
    
while que.empty() == False:
    for i in range(K-1):
        temp = que.get()
        que.put(temp)
    li.append(que.get())

result = ", ".join(map(str, li))
print("<" + result + ">")