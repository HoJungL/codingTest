word = input().upper()
unique_word = list(set(word)) 

counts = []
for i in unique_word:
    cnt = word.count(i)
    counts.append(cnt)

if counts.count(max(counts))>1:
    print('?')
else:
    max_index = counts.index(max(counts))
    print(unique_word[max_index])