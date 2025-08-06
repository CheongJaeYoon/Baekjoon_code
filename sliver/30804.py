import sys

class Tanghuru:
    def __init__(self, current_set, turning_point, left_idx, right_idx):
        self.current_set = current_set
        self.turning_point = turning_point
        self.left_idx = left_idx
        self.right_idx = right_idx
    
    def getlen(self):
        return self.right_idx - self.left_idx

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

t = Tanghuru({arr[0]}, 0, 0, 1)
max_len = t.getlen()

while True:
    if t.right_idx == N:
        break

    if arr[t.right_idx-1] == arr[t.right_idx]:
        t.right_idx += 1
        max_len = max(max_len, t.getlen())
        continue
    else:
        if arr[t.right_idx] in t.current_set:
            t.turning_point = t.right_idx
            t.right_idx += 1
            max_len = max(max_len, t.getlen())
            continue
        else:
            if len(t.current_set) == 1:
                t.current_set.add(arr[t.right_idx])
                t.turning_point = t.right_idx
                t.right_idx += 1
                max_len = max(max_len, t.getlen())
            else:
                t.left_idx = t.turning_point
                t.turning_point = t.right_idx
                t.current_set = {arr[t.left_idx], arr[t.right_idx]}
                t.right_idx += 1
                
print(max_len)