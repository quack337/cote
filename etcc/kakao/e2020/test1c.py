def compress(s, n):
  result = 0
  prev = ""
  count = 0
  for i in range(0, len(s) - n + 1, n):
    if s[i:i + n] == prev:
      count += 1
    else:
      if count > 1: result += len(str(count))
      result += n
      prev = s[i:i + n]
      count = 1
  if count > 1: result += len(str(count))
  result += n
  result += len(s) % n
  return result

s = "abcabcabcabcdededededede"
print( compress(s, 2) )
print( compress(s, 3) )
print( compress(s, 4) )
print( compress(s, 6) )

print( compress("aabbaccc", 1) )
print( compress("ababcdcdababcdcd", 8) )
print( compress("abcabcdede", 3) )
print( compress("xababcdcdababcdcd", 2) )
