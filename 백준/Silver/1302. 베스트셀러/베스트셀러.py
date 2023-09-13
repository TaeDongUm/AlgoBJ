T= int(input())
dic={}
for i in range(T):
    book=input()
    if book not in dic:
        dic[book]=1
    else:
        dic[book]+=1

max_=max(dic.values())
keys=[]
for k,v in dic.items():
    if v==max_:
        keys.append(k)
keys=sorted(keys)
print(keys[0])