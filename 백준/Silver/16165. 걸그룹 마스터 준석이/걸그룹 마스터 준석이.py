import sys
input = sys.stdin.readline

N, M = map(int, input().split())
girl_group = {}

for i in range(N):
    group_name = input().strip()
    number = int(input().strip())
    for j in range(number):
        girl_group[input().strip()] = group_name

for i in range(M):
    quiz_input = input().strip()
    q_type = int(input().strip())
    if q_type == 1 :
        print(girl_group[quiz_input])
    
    else :
        result = []
        for name, gp_name in girl_group.items():
            if gp_name == quiz_input :
                result.append(name)
        result.sort()
        for item in result :
            print(item)