import sys

ISBM = sys.stdin.readline().strip()
tmp = [1,3]

def valid(digit):
    total = 0
    for idx,char in enumerate(ISBM):
        if char != '*':
            total += (int(char)*tmp[(idx%2)])
        else:
            total += (digit*tmp[(idx%2)])
    return (total % 10) == 0

for i in range(0,10):
    if(valid(i)):
        print(i)