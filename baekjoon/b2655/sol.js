A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=A.shift()[0];
for(let i=0;i<N;++i)A[i].push(i+1);
A.sort((a,b)=>b[0]-a[0]);
M=Array(N).fill().map(_=>[]);
BT=(n,w)=>{
  if(n==N)return [0,0];
  if(M[n][w]!=undefined)return M[n][w];
  let a=BT(n+1,w), b=[0,0];
  if (w>A[n][2]) { 
    let t = BT(n+1,A[n][2]); 
    b[0] = t[0] + A[n][1]; b[1] = t[1] + 1;
  }
  return M[n][w] = a[0]>b[0] ? a : b;
}
BT(0,10001);
X=[];
BR=(n,w)=>{
  if(n==N) return true;
  let c = M[n][w];
  
  let a = n<N-1 ? M[n+1][w] : [0,0];
  if(a && a[0]==c[0] && a[1]==c[1])
    if (BR(n+1,w)) return true;

  let t = n<N-1 ? M[n+1][A[n][2]] : [0,0];
  if(t && t[0]==c[0]-A[n][1] && t[1]==c[1]-1) {
    X.push(A[n][3]);
    if(BR(n+1,A[n][2])) return true;
    X.pop();
  }
  return false;
}
BR(0,10001);
X.push(X.length);
console.log(X.reverse().join('\n'))