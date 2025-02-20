def compress(s, n):
  result = []
  prev = s[0:n]
  count = 1
  for i in range(n, len(s) - n + 1, n):
    if s[i:i + n] == prev:
      count += 1
    else:
      if count > 1: result.append(str(count))
      result.append(prev)
      prev = s[i:i + n]
      count = 1
  if count > 1: result.append(str(count))
  result.append(prev)
  tail = len(s) % n
  if tail > 0: result.append(s[len(s) - tail:])
  return "".join(result)

s = "abcabcabcabcdededededede"
print( compress(s, 2) )
print( compress(s, 3) )
print( compress(s, 4) )
print( compress(s, 6) )

print( compress("aabbaccc", 1) )
print( compress("ababcdcdababcdcd", 8) )
print( compress("abcabcdede", 3) )
print( compress("xababcdcdababcdcd", 2) )
