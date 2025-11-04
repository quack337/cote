A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
M=A.pop();N=A.shift();
BT=(n,m)=>{
  if (n<0) return '';
  let x1, x2 = -Infinity;
  for (let i=0, s=''; A[n]*i<=m; ++i,s+=n) {
    let t1 = s + BT(n-1, m-A[n]*i);
    let t2 = +((n==N-1?'0':'1') + t1);
    //let t2 = +('1' + t1);
    if (n==N-1) console.log("%d t1:%s t2:%d x1:%s x2:%d",i, t1, t2, x1, x2); 
    if (t2 > x2) { x1 = t1; x2 = t2; }
  }
  return x1;
}
console.log(BT(N-1,M));