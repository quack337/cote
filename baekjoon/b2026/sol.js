let rd=require('readline').createInterface({input:process.stdin});
let IN=[],K,N,F,A=[];
rd.on('line', s=>IN.push(s)).on('close', ()=>{
 [K,N,F] = IN[0].split(' ').map(e=>+e);
 for (let i=1; i<=N; ++i) {
   A[i] = new Set();
   A[i].add(i);
 }
 for (let i=0; i<F; ++i) {
   let [a, b] = IN[i+1].split(' ').map(e=>+e);
   A[a].add(b);
   A[b].add(a);
 }

 let ANS=null;
 for (let a=1; a<=N; ++a) {
   let g = group(a);
   if (g.size >= K) {
     ANS = [...g].sort((a,b)=>a-b).join('\n');
     break;
   }
 }
 console.log(ANS ? ANS : '-1');
});

function group(a) {
  let set = A[a];
  for (let b of A[a])
    set = set.intersection(A[b]);
  return set;
}