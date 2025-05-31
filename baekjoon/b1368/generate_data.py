N = 10
print(N)
for i in range(N):
  print(1)
for r in range(N):
  for c in range(N):
    if (r == c): print(0, end="")
    else: print(1, end="")
    if (c == N-1): print()
    else: print(" ", end="")