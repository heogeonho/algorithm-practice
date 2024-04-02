import sys
input = sys.stdin.readline

while True:
    str_line = input().rstrip()
    stack = []
    
    if str_line == ".":
        break

    for i in str_line:
        if i == "(" or i == "[":
            stack.append(i)
        elif i == ")":
            if len(stack) != 0 and stack[-1] == "(":
                stack.pop()
            else :
                stack.append(i)
                break
        elif i == "]":
            if len(stack) != 0 and stack[-1] == "[":
                stack.pop()
            else :
                stack.append(i)
                break
    if len(stack) == 0:
        print("yes")
    else:
        print("no")