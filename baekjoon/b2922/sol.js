let D=require('fs').readFileSync(0).toString().trim().split(''),
A=D.map(e=> e=='_' ? e : ('AEIOU'.includes(e) ? 'A':'B')),
C=[...A], AN=A.length, L=D.includes('L'), B=[],
many = (i,c)=>(i>1&&C[i-1]==c&&C[i-2]==c)||(i<AN-2&&C[i+1]==c&&C[i+2]==c)||(i>0&&i<AN-1&&C[i-1]==c&&C[i+1]==c),
map={a:5n, b:20n, L:1n, A:1n, B:1n}, X=0n, BN; // b:20 = 모음과 L 빼고

A.forEach((e,i) => { if (e=='_') B.push(i) })
BN = B.length
DFS(0,L)
console.log(''+X)

function DFS(b,L) {
  if (b==BN) {
    if (L) X += A.reduce((r,c)=>r*map[c], 1n)
    return
  }
  let i=B[b];
  if (!many(i,'B')) { A[i]='b'; C[i]='B'; DFS(b+1,L); A[i]='_'; C[i]='_' }
  if (!many(i,'A')) { A[i]='a'; C[i]='A'; DFS(b+1,L); A[i]='_'; C[i]='_'  }
  if (!many(i,'B')) { A[i]='L'; C[i]='B'; DFS(b+1,true); A[i]='_'; C[i]='_' }
}
