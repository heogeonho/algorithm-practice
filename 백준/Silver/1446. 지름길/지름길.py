import sys
input = sys.stdin.readline

N, D = map(int, input().split())

graph = []
for i in range(N):
    graph.append(list(map(int, input().split())))
    
dist = [i for i in range(D+1)]

for i in range(D+1):
    dist[i] = min(dist[i], dist[i-1] + 1)
    for start, end, distance in graph:
        if i == start and end <= D and dist[i] + distance < dist[end]:
            dist[end] = dist[start] + distance
            
print(dist[D])