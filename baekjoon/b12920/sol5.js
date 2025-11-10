A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[N,W]=A.shift();
A.sort((a,b)=>b[1]/b[0]-a[1]/a[0]);
for(let i=0,ww=W;i<N;++i){
  let [w,,c]=A[i];
  if(w*c<ww) ww = ww - w*c;
  else { A[i][2]=ww/w|0; ww %= w; }
} 
console.log(N,W,A);
return;

P=Array(W+1).fill(0);
Q=Array(W+1).fill(0);
for(let i=0;i<N;++i){
 let [w,p,c]=A[i];
 for(let j=1;j<=c;++j){
  let wj=w*j,pj=p*j;
  if(wj>W)break;
  for(let k=W;k>=wj;--k)
    Q[k]=Math.max(P[k],Q[k],P[k-wj]+pj);}
 [P,Q]=[Q,P];
}
console.log(P[W])