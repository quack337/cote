// 메모리 초과
A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e)
N=A.shift(),K=A.shift()
M=Array(K+1).fill().map(_=>[])
console.log(BT(K,0))

function BT(k,fr){
  if(!k)return 1
  if(M[k][fr])return M[k][fr]
  let s=0
  for (let i=fr;i<N;++i)
    if (k>=A[i])s+=BT(k-A[i],i)
  return M[k][fr]=s
}
