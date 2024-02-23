word = input()
len_word = len(word)
word_set = set()

for i in range(len_word) :
    for j in range(len_word-i) :
        temp = word[i:i+j+1]
        word_set.add(temp)
        
print(len(word_set))