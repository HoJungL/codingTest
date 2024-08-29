N = int(input())
words = [str(input()) for _ in range(N) ]
words = list(set(words))
words.sort()
words.sort(key=len)
for i in range(len(words)):
    print(words[i])