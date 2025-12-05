D=(require('fs').readFileSync(0)+'').trim().split('\n').map(s=>s.trim().split(' '));
[C,R]=D[1].map(e=>+e);
A=D[0][1].split('').map(e=>+e).reverse();
CM=[,[2,0],[1,1],[4,1],[3,0]];
RM=[,[4,0],[3,0],[2,1],[1,1]];
while(C||R){
  let m=C?CM:RM, p=C?'C':'R', q=C?C:R;
  for(let i=0;;++i){
    if(i==A.length){console.log(-1);return}
    let [n,d]=m[A[i]];
    // console.log('i:%d n:%d d:%d p:%s', i, n, d, p);
    A[i]=n;
    // console.log([...A].reverse());
    // console.log('C:%d R:%d q:%d d:%d', C, R, q, d);
    if(q>0&&d||q<0&&!d)break;
  }
  if(p=='C')C+=C>0?-1:1;else R+=R>0?-1:1;
}
console.log(A.reverse().join(''))