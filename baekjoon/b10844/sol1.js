// BT  구현
N=+require('fs').readFileSync(0)
let sum=0
for (let p=1; p<=9; ++p)
  sum += BT(N-1, p)
console.log(sum)

function BT(n,p) {
  if (n==0) return 1
  let a=0, b=0
  if (p<9) a=BT(n-1, p+1)
  if (p>0) b=BT(n-1, p-1)
  return a+b
}