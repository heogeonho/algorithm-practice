import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))
count = 0

for i in range(N-1, 0, -1):
    for j in range(i):
        if(arr[j] > arr[j+1]):
            arr[j], arr[j+1] = arr[j+1], arr[j]
            count += 1
            if (K == count):
                print(f'{arr[j]} {arr[j+1]}')
                break
    if (K == count):
        break
if(K > count):
    print(-1)