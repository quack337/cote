I=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[N,M]=I[0];
E=Array(N+1).fill().map(_=>[]);
for(i=1;i<N;++i){
 [a,b,c]=I[i];
 E[a].push([b,c]);
 E[b].push([a,c]);
}
P=[];D=[];
F1=(a,p,d)=>{
 if(P[a])return;
 P[a]=p;D[a]=d;
 for(let [b,c] of E[a])
  F1(b,a,c+d);
}
F1(1,-1,0);
console.log(E);
console.log(P);
console.log(D);
