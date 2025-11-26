// 검증용 BT
D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];A=D[1];
S=[]
CK =_=> {
  let C=Array(N+1).fill(0);
  S.forEach(e => ++C[e]);
  return C.every(e => e<2);
}
BT = n => {
  if(n==N) {
    if(S.length && CK()) {
      ++X;
      //console.log(S.join(' '));
    }
    return;
  }
  BT(n+1);
  S.push(A[n]); BT(n+1); S.pop();
}
X=0;
BT(0);
console.log(X)