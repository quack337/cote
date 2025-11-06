[R,C,W]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
N=R+W-1;
M=Array(N).fill().map(_=>Array(N).fill(1));
for(let r=2;r<N;++r)
for(let c=1;c<r;++c)
  M[r][c]=M[r-1][c-1]+M[r-1][c];
X=0;--R;--C;
for(let r=0;r<W;++r)
for(let c=0;c<=r;++c)X+=M[r+R][c+C];
console.log(X);