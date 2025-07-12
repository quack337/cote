let IN=require('fs').readFileSync(0).toString().split('\n'),
[N,M,FROM,TO,MONEY]=IN[0].split(' ').map(e=>+e), A=Array(N+1).fill().map(_=>[]);
let V=[], ANS=Infinity, S=[];
for (let i=0; i<M; ++i) {
  let [a,b,c] = IN[i+1].split(' ').map(e=>+e);
  A[a].push([b,c]); A[b].push([a,c]);
}
DFS(FROM,MONEY,0);
console.log(ANS==Infinity? -1 : ANS);

function DFS(a,money,ans) {
  if (a==TO) {
    if (ans<ANS) ANS=ans;
    return;
  }
  for (let [b,c] of A[a])
    if (!V[b]) {
      V[b]=1; S.push(b);
      if (c <= money && c < ANS)
        DFS(b, money-c, c>ans?c:ans);
      V[b]=0; S.pop();
    }
}