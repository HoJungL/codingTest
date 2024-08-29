N = int(input())
F = int(input())
str_N =str(N)[:-2]
for i in range(99):
    if len(str(i)) ==1:
        if int(str_N + '0' +str(i)) % F == 0:
            print('0'+str(i))
            break
    else:
        if int(str_N +str(i)) % F == 0:
            print(str(i))
            break