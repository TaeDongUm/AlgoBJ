from collections import deque
while 1:
    dq_1=[]
    sentence = input()
    if sentence=='.':
        break
    else:
        for i in range(len(sentence)):
            if '(' ==sentence[i]:
                dq_1.append(sentence[i])
            elif '[' == sentence[i]:
                dq_1.append(sentence[i])
            elif ')' ==sentence[i]:
                if dq_1 and dq_1[-1] =='(':
                    dq_1.pop()
                else:
                    dq_1.append(')')
            elif ']' == sentence[i]:
                if dq_1 and dq_1[-1]=='[':
                    dq_1.pop()
                else:
                    dq_1.append(']')
        if len(dq_1) !=0:
            print("no")
        else:
            print("yes")