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
F2=a=>{
 if(a<1)return;
 if(V[a])return a;
 V[a]=1;
 return F2(P[a]);
}
X=[];
for(i=N;i<N+M;++i){
 [a,b]=I[i];
 V=[];
 F2(a);
 p=F2(b);
 X.push(D[a]+D[b]-D[p]*2);
}
console.log(X.join('\n'))