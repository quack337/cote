D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];A=D[1];
C=Array(N+1).fill(0);
for(let i=0;i<N;++i)C[A[i]]++;
F=0n;H=0n;J=1n;
for(let i=0;i<=N;++i){let c=BigInt(C[i]);
  if(c>1){H+=c;J*=c+1n}else if(c==1)++F;
}
H=1n<<H;J<<1n;F=1n<<F;
console.log(((1n<<BigInt(N))-1n-F*(H-J))%1_000_000_007n+'')