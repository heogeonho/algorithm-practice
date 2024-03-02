from collections import deque

import sys
input = sys.stdin.readline

T = int(input().strip())

for t in range(T):
    P = input().strip()
    P_list = [] #쓸 것

    for i in range(len(P)):
        P_list.append(P[i])
    
    n = int(input().strip())
    input_value = input().strip()[1:-1].split(",")
    if n == 0:
        q = deque()
    else:
        # n_list = map(int,input_value.split(','))
        q = deque(input_value) # 쓸 것

    check_value = 0
    is_reverse = False

    for do in P_list:

        if (do == 'R'):
            if is_reverse == False:
                is_reverse = True
            else :
                is_reverse = False
        if (do == 'D'):
            if len(q) == 0:
                print("error")
                check_value = 1
                break
            else :
                if is_reverse == False:
                    q.popleft()
                else :
                    q.pop()
    
    if (check_value == 0) :
        if(is_reverse == True):
            q.reverse()
            print('[' + ",".join(q) + ']')
        else:
            print('[' + ",".join(q) + ']')