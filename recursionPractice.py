# Practicing Recursion for Class in Python

# Example 1: Fibonacci
# 0 1 1 2 3 5 8 13 21

def fibonacci(n):
    if n >= 0 and n <= 1:
        return n
    else:
        # fibonacci
        # fibonacci(n) = fibonacci(n-1) + fibonacci (n-2)
        return fibonacci(n-1) + fibonacci(n-2)


# call fibonacci, and give it a number to find that fibonacci number
"""
n = int(input())
print("Fibonacci (" +  str(n) + ") is: " + str(fibonacci(n)))
"""


# Example 2: Draw Triangle
# use * to draw a triangle, with number of asterisks on last row equal to n
# each row will increase by 2 asterisks, starting with 1 on the first row

def drawTriangle(n):
    spaces = 9 - n // 2

    if n <= 0:
        return
    elif n == 1:
        print(" " * spaces + "*")
    else:
        drawTriangle(n-2)
        print(" " * spaces + "*" * n)

# drawTriangle(17)


# Example 3: Sum of Natural Numbers

def sum(n):
    if (n == 1):
        return 1
    else:
        return n + sum(n-1)
    
# print(sum(3))


# Example 4: Factorial of a Number

def factorial(n):
    if (n == 0):
        return 1
    else:
        return n * factorial(n - 1)
    

# Example 5: Upside Down Triangle
def drawTriangleUD(n):
    spaces = 9 - n // 2
    
    if n <= 0:
        return
    else:
        print(" " * spaces + "*" * n)
        drawTriangleUD(n - 2)

drawTriangleUD(19)