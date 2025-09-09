let IN=require('fs').readFileSync(0).toString().split('\n').map(e=>+e);
let T=IN.shift();
for (let t=0; t<T; ++t) {
  let N = IN[t];
  let M = [0,1,2,4];
  for (let i=4; i<=N; ++i) {
    M[i] = M[i-1] + M[i-2]*2 + M[i-3];
  }
}
