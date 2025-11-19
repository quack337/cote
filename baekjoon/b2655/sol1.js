A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=A.shift()[0];
A.sort((a,b)=>b[0]-a[0]);
M=Array(N).fill().map(_=>[]);
BT=(n,w)=>{
 if(n==N) return 0;
 if(M[n][w] != undefined) return M[n][w];
 let a = BT(n+1,w), b = 0;
 if(A[n][2] < w){ b = BT(n+1,A[n][2]) + A[n][1]; }
 return M[n][w] = a > b ? a : b;
}
console.log(BT(0,10001))
//console.log(A.map(a=>a.join('\t')).join('\n'));
/*
X=[BT(0,A[0][2])];
w=0;x=1;
for(let n=N-1;n>=0;--n)
for(let i=w;i<M[n].length;++i)
  if(M[n][i]==x){++x;w=i;X.push(n+1);break}
console.log(X.join('\n'))
*/