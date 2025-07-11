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
  병합 = [][]
  for r = 0 to ROW-1
    for c = COL-2 to 0
      if B[r][c] > 0 then 이동(B, r, c, mv)

이동(B, r, c, mv)
  c1 = c+1;
  while (c1 < COL-1 && B[r][c1]==0)
    ++c1;
  if (B[r][c1]==0) { B[r][c1]=B[r][c]; B[r][c]=0; }
  else if (B[r][c1]==B[r][c] && !병합[r][c1]) {
    B[r][c1] *= 2; 병합[r][c1] = true; B[r][c]=0;
  } else if (c1-1 > c) { B[r][c1]=B[r][c]; B[r][c]=0; }




