from collections import deque
import copy

N = int(input())
num_list=[]
new_list1=[]
for i in range(1,N+1):
    num_list.append(i)
new_list=deque(num_list)
for i in copy.deepcopy(new_list):    #RuntimeError: deque mutated during iteration 에러, 그래서 list 넣었음
    new_list1.append(new_list[0])  
    new_list.popleft()
    if len(new_list) ==0:
        break      
    new_list.append(new_list[0])  
    new_list.popleft()            
    if len(new_list) ==1:
        new_list1.append(new_list[0])
        break
print(*new_list1,end='')
