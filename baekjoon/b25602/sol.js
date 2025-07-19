let [[N,K],A,...R]=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e))
X=0
BT=(n,x)=>{
 if (n==K+K) {if(x>X) X=x; return}
 for (let i=0;i<N;++i)
   if (A[i]) {--A[i]; BT(n+1,x+R[(n>>1)+n%2*K][i]); ++A[i]}
}
BT(0,0)
console.log(X)