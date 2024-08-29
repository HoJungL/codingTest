N, M = map(int, input().split())
board = []
result = []

for _ in range(N):
    board.append(input())

for a in range(N-7):
    for b in range(M-7):
        change_w = 0
        change_b = 0
        for i in range(a, a+8):
            for j in range(b, b+8):
                if (i+j) % 2 ==0:
                    if board[i][j] !="W":
                        change_w += 1
                    if board[i][j] !="B":
                        change_b += 1
                else:
                    if board[i][j] !="B":
                        change_w += 1
                    
                    if board[i][j] !="W":
                        change_b += 1
        result.append(change_w)
        result.append(change_b)
print(min(result))