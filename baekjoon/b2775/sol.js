let A=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e),
T=A.shift(), OUT=[], M
for (let t=0; t<T; ++t) {
  let 층=A[t*2], 호=A[t*2+1];
  M=Array(층+1).fill().map(_=>Array(호+1).fill(0))
  OUT.push(BT(층,호))
}
console.log(OUT.join('\n'));

function BT(층, 호) {
  if (층==0) return 호
  if (M[층][호]) return M[층][호]
  if (호==0) return M[층][호] = BT(층-1,0)
  return M[층][호] = BT(층,호-1) + BT(층-1,호)
}