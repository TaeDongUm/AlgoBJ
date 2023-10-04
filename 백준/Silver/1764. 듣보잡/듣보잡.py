N,M=map(int,(input().split()))
dict={}
for i in range(N+M):
    word=input()
    if word not in dict:
        dict[word]=1
    else:
        dict[word]+=1
keys=[]
for k,v in dict.items():
    if v >1:
        keys.append(k)
keys=sorted(keys)
print(len(keys))
for i in range(len(keys)):
    print(keys[i])   