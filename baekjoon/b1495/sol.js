D=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e)
let[N,S,M]=D
V=D.slice(3)
P=Array(N).fill().map(_=>[])
BT=(n,v)=>{
 if(v<0||v>M)return-1
 if(n==N)return v
 if(P[n][v]!=undefined)return P[n][v]
 return P[n][v]=Math.max(BT(n+1,v-V[n]),BT(n+1,v+V[n]))
}
console.log(BT(0,S))