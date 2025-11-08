A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=A.shift()[0];
M=Array(N).fill().map(_=>Array(N));
M[N-1][N-1]=1;A[N-1][N-1]=0;
for(let r=N-1;r>=0;--r)
for(let c=N-1;c>=0;--c){let j=A[r][c];
  M[r][c]=(r+j<N&&M[r+j][c])||(c+j<N&&M[r][c+j]);}
console.log(M[0][0]?'HaruHaru':'Hing')