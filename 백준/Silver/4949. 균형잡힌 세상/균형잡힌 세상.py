while True :
    str_line = input()
    stack = []
    
    if str_line == "." :
        break
        
    stack = []
    result = True
    
    for el in str_line:
        if el == '(' or el =='[':
            stack.append(el)
        elif el==')':
            if len(stack)==0 or stack[-1]=='[':
                result = False
                break
            elif stack[-1] == '(':
                stack.pop()
        elif el==']':
            if len(stack)==0 or stack[-1]=='(':
                result = False
                break
            elif stack[-1] == '[':
                stack.pop()
    if len(stack)==0 and result==True:
        print('yes')
    else:
        print('no')