import sys
input = sys.stdin.readline

def merge_sort(arr):

    if len(arr) > 1 :
        # 분할을 위한 계산
        m = len(arr) // 2

        L = arr[:m]
        R = arr[m:]

        merge_sort(L)
        merge_sort(R)

        merge(arr, L, R)


def merge(arr, L, R):
    i = 0
    j = 0
    k = 0

    while i <  len(L) and j < len(R):
        if L[i] < R[j]:
            arr[k] = L[i]
            i += 1
        else :
            arr[k] = R[j]
            j += 1
        k += 1

    while i < len(L):
        arr[k] = L[i]
        i += 1
        k += 1

    while j < len(R):
        arr[k] = R[j]
        j += 1
        k += 1

N = int(input().strip())
arr = []

for i in range(N):
    arr.append(int(input().strip()))

merge_sort(arr)

for i in arr:
    print(i)