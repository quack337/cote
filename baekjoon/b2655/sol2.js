A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=A.shift()[0];
for(let i=0;i<N;++i)A[i].push(i+1);
A.sort((a,b)=>b[0]-a[0]);
M=Array(N+1).fill().map(_=>[]);
BT=(n,w)=>{
 if(n==N) return [0,0];
 if(M[n][w] != undefined) return M[n][w];
 let a = BT(n+1,w), b = [0,0];
 if(A[n][2] < w){ let t = BT(n+1,A[n][2]); b[0] = t[0] + A[n][1]; b[1] = t[1] + 1; }
 if(n==2) console.log(a, b);
 return M[n][w] = a[0] > b[0] ? a : b;
}
console.log(BT(0,10001))
