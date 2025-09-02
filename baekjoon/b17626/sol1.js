// 1로 계속 빼는 것을 해봐야 하기 때문에, stack overflow
let N = +require('fs').readFileSync(0).toString();
console.log(DFS(N));

function DFS(n) {
  console.log(n)
  if (n==0) return 0;
  let e = Math.floor(Math.sqrt(n));
  let r = Infinity;
  for (let i=1; i<=e; ++i)
    r = Math.min(r, DFS(n - i*i) + 1);
  return r;
}