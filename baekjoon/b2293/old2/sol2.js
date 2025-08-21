// 메모리 초과
A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e)
N=A.shift(),K=A.shift()
M=new Map()
console.log(BT(K,0))

function BT(k,fr){
  if(!k)return 1
  let key = k*1000 + fr;
  if(M.has(key)) return M.get(key)
  let s=0
  for (let i=fr;i<N;++i)
    if (k>=A[i])s+=BT(k-A[i],i)
  M.set(key, s);
  return s
}
