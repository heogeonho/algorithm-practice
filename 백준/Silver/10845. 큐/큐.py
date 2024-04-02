import sys
input = sys.stdin.readline

queue = []

N = int(input())
for i in range(N):
    str = input().split()
    if(len(str) == 2):
        commend, k = str[0], str[1]
    else :
        commend = str[0]
        
    if commend == "push":
        queue.append(k)
    elif commend == "pop":
        if len(queue) == 0:
            print(-1)
        else :
            print(queue.pop(0))
    elif commend == "size":
        print(len(queue))
    elif commend == "empty":
        if len(queue) == 0:
            print(1)
        else :
            print(0)
    elif commend == "front":
        if len(queue) == 0:
            print(-1)
        else :
            print(queue[0])
        
    elif commend == "back":
        if len(queue) == 0:
            print(-1)
        else :
            print(queue[len(queue)-1])
            
        
        