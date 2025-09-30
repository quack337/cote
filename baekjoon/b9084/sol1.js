let IN=require('fs').readFileSync(0).toString().split('\n');
let T=+IN[0],OT=[];
for (let t=0; t<T; ++t) {
  let N=+IN[t*3+1];
  let A=IN[t*3+2].split(' ').map(e=>+e);
  let X=+IN[t*3+3];
  let M=Array(X+1).fill(0);
  M[0]=1;
  for (let i=0; i<N; ++i)
    for (let a=A[i], j=a; j<=X; ++j)
      M[j] += M[j-a];
  OT.push(M[X]);
}
console.log(OT.join(' '));