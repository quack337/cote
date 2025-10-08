A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
N=A.shift();
D=[[9,3,1],[9,1,3],[3,9,1],[1,9,3],[3,1,9],[1,3,9]];
if (N==1) console.log(Math.ceil(A[0]/9));
else if (N==2) {
  M=Array(61).fill().map(_=>Array(61));
  console.log(B2(...A));
}
else {
  M=Array(61).fill().map(_=>Array(61).fill().map(_=>Array(61)));
  console.log(B3(...A));
}

function B2(a,b) {
  if (a<0) a=0; if (b<0) b=0;
  if (!a && !b) return 0;
  if (M[a][b]!=undefined) return M[a][b];
  return M[a][b]=Math.min(B2(a-9,b-3), B2(a-3,b-9))+1;
}

function B3(a,b,c) {
  if (a<0)a=0; if (b<0)b=0; if (c<0)c=0;
  if (!a && !b && !c) return 0;
  if (M[a][b][c]!=undefined) return M[a][b][c];
  let x=Infinity;
  for (let i=0; i<6;++i){
    let d=D[i], t=B3(a-d[0], b-d[1], c-d[2]);
    if (t<x) x=t;
  }
  return M[a][b][c]=x+1;
}