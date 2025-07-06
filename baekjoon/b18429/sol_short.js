let [d1,d2]=require('fs').readFileSync(0).toString().split('\n')
let [N,K]=d1.split(' ').map(e=>+e), A=d2.split(' ').map(e=>+e)
let L=[], V=[], C=0
DFS(0)
console.log(C)

function DFS(w) {
 if (w<0) return;
 if (L.length==N) ++C
 else
   for (let i=0; i<N; ++i)
     if (!V[i]) {
       L.push(A[i]); V[i]=1
       DFS(w-K+A[i])
       L.pop(); V[i]=0
     }
}