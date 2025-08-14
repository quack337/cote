let IN=(require('fs').readFileSync(0)+'').split(/\s+/).map(e=>+e);
let [N, K] = IN;
let W = IN.filter((e,i) => i%2==0 && i>1);
let V = IN.filter((e,i) => i%2==1 && i>1);
console.log(N, K, W, V);
