import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))
count = 0
# arr -> [3, 1, 2, 5, 4]

# 배열 전체를 돌면서 교환
for i in range(len(arr)-1, -1, -1):
    max_idx = i
    
    # 각각의 턴을 동작 (인덱스 내려가면서 큰수 찾아 바꾸기)
    for j in range(i, -1, -1):
        
        if arr[max_idx] < arr[j] :
            max_idx = j
        
    if(i != max_idx):
        count += 1
        arr[i], arr[max_idx] = arr[max_idx], arr[i]
        if(K == count):
            print(f"{arr[max_idx]} {arr[i]}")
            break

if(K > count):
    print(-1)
