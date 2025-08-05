import sys

num = 0
A = sys.stdin.readline().strip()
if(A.isdigit()):
    num = int(A)
if(num != 0):
    num += 1
B = sys.stdin.readline().strip()
if(B.isdigit()):
    num = int(B)
if(num != 0):
    num += 1
C = sys.stdin.readline().strip()
if(C.isdigit()):
    num = int(C)
if(num != 0):
    num += 1

def fizzbuzz(num):
    if num%15 == 0:
        print("FizzBuzz")
    elif num%3 == 0:
        print("Fizz")
    elif num%5 == 0:
        print("Buzz")
    else:
        print(num)


fizzbuzz(num)