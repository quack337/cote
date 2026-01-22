G=(a,p,b,q)=>Math.sqrt((a-b)**2+(p-q)**2);
D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
I=0;C=[];T=D[I++];
for(t=0;t<T;++t){
 [x0,y0,x1,y1]=D[I++];
 N=D[I++][0];c=0;
 for(i=0;i<N;++i){
  [x,y,r]=D[I++];
  if(G(x,y,x0,y0)<r ^ G(x,y,x1,y1)<r)++c}
 C.push(c)}
console.log(C.join('\n'))