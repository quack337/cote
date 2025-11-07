A=(require('fs').readFileSync(0)+'').split(/\s+/).map(e=>+e);
N=A[0];M=A[1]+2;B=[];
for(let i=2;i<M;++i)B[A[i]-1]=1;
P=Array(N).fill().map(_=>[]);
BT=(n,c)=>{
 if(n>=N)return 0;let p=P[n];
 if(p[c]!=undefined)return p[c];
 if(B[n])return P[n][c]=BT(n+1,c);
 return p[c]=Math.min(c>=3?BT(n+1,c-3):9999,BT(n+1,c)+10,BT(n+3,c+1)+25,BT(n+5,c+2)+37);
}
console.log(BT(0,0)*1000)