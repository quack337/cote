A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
[N,W]=A.shift();
map=[];
for(let i=0;i<N;++i){
  let [w,p,c] = A[i];
  if(!map[w]) map[w]=[];
  map[w].push(A[i]);
}
for(let i=0;i<map.length;++i)
  if(map[i]){
    map[i].sort((a,b)=>b[1]-a[1]);
    for(let j=0,w=0;j<map[i].length; ++j){
      w += map[i][j][0] * map[i][j][2];
      if (w>=W){
        let p=map[i][j][1];
        for(let k=j+1;k<map[i].length;++k) map[i][k][2]=0;
        for(let k=i*2;k<map.length;k+=i)
          if(map[k])
            for(let h=0;h<map[k].length;++h)
              if(map[k][h][1]<=p) map[k][h][2] = 0;
        break;  
      }
    }
  }
//console.log(N,W,A);return;
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