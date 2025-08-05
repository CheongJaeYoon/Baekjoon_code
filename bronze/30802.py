import sys
import math

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
T, P = map(int, sys.stdin.readline().split())

output_T = 0
for size in arr:
    output_T += math.ceil(size/T)

print(output_T)
print(N//P, N%P)