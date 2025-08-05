let X = require('fs').readFileSync(0).toString().trim();
let M=[];
M[1] = 0;
for (let x=2; x <= X; ++x) {
  let a = Infinity, b = Infinity, c= Infinity;
  if (x % 3 == 0) a = M[x/3];
  if (x % 2 == 0) b = M[x/2];
  c = M[x-1];
  M[x] = Math.min(a, b, c) + 1;
}
console.log(M[X])
