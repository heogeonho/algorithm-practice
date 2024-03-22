import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))


def bubble_sort(N, K, arr) :
    count = 0
    result = -1
    for i in range(N-1, 0, -1) :
        
        for j in range(i):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
                count += 1
                if count == K:
                    result = f'{arr[j]} {arr[j+1]}'
    return result

print (bubble_sort(N, K, arr))