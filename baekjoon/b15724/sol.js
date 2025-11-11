A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[R,C]=A.shift();
Q=A[R][0];
M=Array(R).fill().map(_=>Array(C));
M[0][0]=A[0][0];
for(let r=1;r<R;++r)M[r][0]=A[r][0]+M[r-1][0];
for(let c=1;c<C;++c)M[0][c]=A[0][c]+M[0][c-1];
for(let r=1;r<R;++r)for(let c=1;c<C;++c)M[r][c]=A[r][c]+M[r][c-1]+M[r-1][c]-M[r-1][c-1];
X=[];
for(let i=1;i<=Q;++i){
  let[r1,c1,r2,c2]=A[i+R];
  --r1;--c1;--r2;--c2;
  let x=M[r2][c2];
  if(r1)x-=M[r1-1][c2];
  if(c1)x-=M[r2][c1-1];
  if(r1&&c1)x+=M[r1-1][c1-1];
  X.push(x);
}
console.log(X.join('\n'))