from collections import deque
import sys
input = sys.stdin.readline

deq = deque()

N = int(input())
for i in range(N):
    str = input().split()
    if(len(str) == 2):
        commend, k = str[0], str[1]
    else :
        commend = str[0]
        
    if (commend == "push_front"):
        deq.appendleft(k)
    elif (commend == "push_back"):
        deq.append(k)
    elif (commend == "pop_front"):
        if(len(deq) == 0):
            print(-1)
        else :
            print(deq.popleft())
    elif (commend == "pop_back"):
        if(len(deq) == 0):
            print(-1)
        else :
            print(deq.pop())
    elif (commend == "size"):
        print(len(deq))
    elif (commend == "empty"):
        if(len(deq) == 0):
            print(1)
        else :
            print(0)
    elif (commend == "front"):
        if(len(deq) == 0):
            print(-1)
        else :
            temp = deq.popleft()
            print(temp)
            deq.appendleft(temp)

    elif (commend == "back"):
        if(len(deq) == 0):
            print(-1)
        else :
            temp = deq.pop()
            print(temp)
            deq.append(temp)

       