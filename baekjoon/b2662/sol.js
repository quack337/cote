A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[M,N]=A[0];A[0]=Array(N).fill(0);
P=Array(N+1).fill().map(_=>[]);
B1=(n,m)=>{
 if(!m||n>N)return 0;
 if(P[n][m]!=undefined)return P[n][m];
 let x=0;
 for(let i=0;i<=m;++i){let t=A[i][n]+B1(n+1,m-i);if(t>x)x=t;}
 return P[n][m]=x;
}
B1(1,M);
X=[];m=M;
P[N+1]=Array(M+1).fill(0);
for(let i=0;i<P.length;++i)P[i][0]=0;
for(let n=1;n<=N;++n)
 if(!m)X.push(0);else
 for (let i=0;i<=m;++i)
  if(P[n][m]==P[n+1][m-i]+A[i][n]){X.push(i);m-=i;break;}
console.log(P[1][M]+'\n'+X.join(' '))