first, last = map(int, input().split())

answer = last - first + 1

matrix = [False] * answer

for i in range(2, int(last**0.5 +1)):
    squared = i **2
    for j in range( (((first-1)//squared)+1 )*squared, last+1, squared ):
        if matrix[j - first] == False :
            matrix[j - first] =True
            answer -= 1
print(answer)