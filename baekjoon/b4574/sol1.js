// 입력 구현
nums=s=>s.split(' ').map(e=>+e)
IN=require('fs').readFileSync(0).toString()
for (i=0; i<9; ++i)
  IN=IN.replaceAll('ABCDEFGHI'.charAt(i), i+' ')
IN=IN.split('\n')
ix=0
for (;;) {
  V=[]
  A=Array(9).fill().map(_=>Array(9).fill(0))
  N=+IN[ix++]
  if (!N) break;
  for (i=0; i<N; ++i) {
    let [a,ra,ca,b,rb,cb]=nums(IN[ix++])
    A[ra][ca-1]=a
    A[rb][cb-1]=b
    V[a<b ? a*10+b : b*10+a]=1
  }
  B=nums(IN[ix++])
  for (i=0; i<9; ++i) {
    r=B[i*2], c=B[i*2+1]-1
    A[r][c]=i+1
  }
  console.log(V)
  for (row of A)
    console.log(row.map(e=>e ? e : '.').join(' '))
}
