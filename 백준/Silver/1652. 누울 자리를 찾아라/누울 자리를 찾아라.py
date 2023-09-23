N=int(input())
Matrix=[list(input()) for i in range(N)]
Black=0
White=0
White_Length=[]
cnt=0
Laydown=[]
for i in range(N):
    for j in range(N):
        if Black >=1:
            if Matrix[i][j]=='.':
                White+=1
                Black=0
                if j==N-1:
                    White_Length.append(White)
                    White=0
            elif Matrix[i][j]=='X':
                Black+=1
        else:
            if Matrix[i][j] =='.':
                White +=1
                if j==N-1:
                    White_Length.append(White)
                    White=0
            elif Matrix[i][j] =='X':
                White_Length.append(White)
                White=0
                Black+=1
for k in range(len(White_Length)):
    if White_Length[k]>=2:
        cnt+=1
Black=0
White=0
White_Length=[]
Laydown.append(cnt)
cnt=0
for i in range(N):
    for j in range(N):
        if Black >=1:
            if Matrix[j][i]=='.':
                White+=1
                Black=0
                if j==N-1:
                    White_Length.append(White)
                    White=0
            elif Matrix[j][i]=='X':
                Black+=1
        else:
            if Matrix[j][i] =='.':
                White +=1
                if j==N-1:
                    White_Length.append(White)
                    White=0
            elif Matrix[j][i] =='X':
                White_Length.append(White)
                White=0
                Black+=1
for k in range(len(White_Length)):
    if White_Length[k]>=2:
        cnt+=1
Laydown.append(cnt)
for i in range(len(Laydown)):
    print(Laydown[i], end=' ')