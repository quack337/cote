수열재귀()
  if selectCount == 5
    answer = max(answer, 최대값계산())
  else
    for mv = 0 to 4
      selected.push(mv)
      수열재귀()
      selected.pop()


최대값계산()
  B = A.clone()
  for (mv of selected)
    이동(B, mv)
  return 최대값(B)

이동(B, mv)
  for r = 0 to ROW-1
    for c = COL-1 to 0
      if B[r][c] > 0 then 이동(B, r, c, mv)

이동(B, r0, c0, mv)
  r = r0; c = c0 + 1;


