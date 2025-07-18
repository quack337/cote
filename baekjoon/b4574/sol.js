nums=s=>s.split(' ').map(e=>+e)
DD=[[-1,0],[0,1],[1,0],[0,-1]]
IN=''+require('fs').readFileSync(0)
for (i=0; i<9; ++i)
  IN=IN.replaceAll('ABCDEFGHI'.charAt(i), i+' ')
IN=IN.split('\n')
ix=0
OUT=[]
for (let t=1;;++t) {
  N=+IN[ix++]
  if (!N) break;
  OUT.push('Puzzle '+t)
  USED=[]
  A=Array(9).fill().map(_=>[])
  for (i=0; i<N; ++i) {
    let [a,ra,ca,b,rb,cb]=nums(IN[ix++])
    A[ra][ca-1]=a
    A[rb][cb-1]=b
    USED[a<b?a*10+b:b*10+a]=1
  }
  B=nums(IN[ix++])
  for (i=0; i<9; ++i) A[B[i*2]][B[i*2+1]-1]=i+1
  BT(0,0,0)
}
console.log(OUT.join('\n'))

function valid(ro,co,x) {
  let v= !x ? Array(10).fill(1) : 1
  for (let i=0; i<9; ++i) {
    if (x) {if (A[i][co]==x || A[ro][i]==x) return 0}
    else v[A[i][co]]=v[A[ro][i]]=0
  }
  let rb=Math.floor(ro/3)*3, cb=Math.floor(co/3)*3
  for (let r=0; r<3; ++r)
    for (let c=0; c<3; ++c)
      if (x) {if (A[rb+r][cb+c]==x) return 0}
      else v[A[rb+r][cb+c]]=0
  return v
}

function BT(ro,co,depth) {
  if (co>8) {
    co=0; ++ro
    if (ro>8) {OUT.push(...A.map(e=>e.join(''))); return 1}
  }
  if (A[ro][co]>0) return BT(ro,co+1,depth)
  let va=valid(ro,co)
  for (let a=1; a<=9; ++a) {
    if (!va[a]) continue
    for (let b=1; b<=9; ++b) {
      let k=a<b?a*10+b:b*10+a
      if (a==b||USED[k]) continue
      for (let [dr,dc] of DD) {
        let r=ro+dr, c=co+dc
        if (r<0||c<0||r>8||c>8) continue
        if (A[r][c] || !valid(r,c,b)) continue
        A[ro][co]=a; A[r][c]=b; USED[k]=1
        if (BT(ro,co+1,depth+1)) return 1
        A[ro][co]=A[r][c]=USED[k]=0
  }}}
  return 0
}