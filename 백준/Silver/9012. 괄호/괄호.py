T = int(input())
PS=[]
for i in range(T):
    PS.append(input())
for testcase in range(len(PS)):
    N=1
    while N <25:
        test=PS[testcase].replace("()", "")
        N+=1
        if test !='':
            PS[testcase]=test
        if test == '':
            break
    if len(test) !=0:
        print("NO")
    else:
        print("YES")