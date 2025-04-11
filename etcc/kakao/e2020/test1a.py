def compress(s):
  result = []
  prev = s[0]
  count = 1
  for c in s[1:]:
    if c == prev:
      count += 1
    else:
      if count > 1: result.append(str(count))
      result.append(prev)
      prev = c
      count = 1
  if count > 1: result.append(str(count))
  result.append(prev)
  return "".join(result)

a = ["aaabbbcdee", "aabbaccc", "abbcdde", "a"]
for s in a:
  print( compress(s) )

