def star_box(arr, a, b):
    for i in range (a - 1, b):
        arr[a-1][i] = '*'
        arr[b-1][i] = '*'
        arr[i][a-1] = '*'
        arr[i][b-1] = '*'
    if a == b :
        return
    else :
        a += 2
        b -= 2
        star_box(arr, a, b)

N = int(input())
size = 4 * N - 3
arr = [[' ' for j in range(size)] for i in range(size)]

star_box(arr, 1, size)

for i in range(size):
    for j in range(size):
        print(arr[i][j], end='')
    print()