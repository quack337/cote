let N = +require('fs').readFileSync(0).toString();
let M = [0,0,1,1];
for (let i=4; i<=N; ++i) {
  let min = M[i-1];
  if (i % 3 == 0) min = Math.min(min, M[i/3]);
  if (i % 2 == 0) min = Math.min(min, M[i/2]);
  M[i] = min + 1;
}
let n = N, X=[]
while (n > 0) {
  X.push(n);
  if (n%3==0 && M[n]==M[n/3]+1) n /= 3;
  else if (n%2==0 && M[n]==M[n/2]+1) n /= 2;
  else --n;
}
console.log(M[N] +'\n'+ X.join(' '));