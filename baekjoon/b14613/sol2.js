N=20;
C=Array(N+1).fill().map((_,i)=>Array(i+1).fill(1));
for(let n=2;n<=N;++n)
for(let r=1;r<n;++r)C[n][r]=C[n-1][r-1]+C[n-1][r];
[W,L,D]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
pow=Math.pow;P=[0,0,0,0,0];
wn=N*W;ln=N*L;dn=N*D;
for(let w=0;w<=N;++w)
for(let l=N-w;l>=0;--l){
  let d=N-w-l,x=2000+(w-l)*50;
  let i=x<1500?0:x<2000?1:x<2500?2:x<3000?3:4;
  let p=1;
  if(w>wn) p*=pow(W,w-wn);
  if(d>dn) p*=pow(D,d-dn);
  if(l>ln) p*=pow(L,l-ln);
  if(p) console.log(w,d,l,p.toFixed(8));
  P[i] += p*C[N][w]*C[N][d];
}
S=P.reduce((a,e)=>a+e);
console.log(S);
console.log(P.map(p=>(p/S).toFixed(8)))