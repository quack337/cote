function 최대공약수(a, b) {
  while (b != 0) {
      let t = a % b;
      a = b;
      b = t;
  }
  return a;
}

let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let N = parseInt(input[0]);
let a = parseInt(input[1]);
for (let i = 0; i < N - 1; ++i) {
  let b = parseInt(input[i + 2]);
  let gcd = 최대공약수(a, b);
  console.log(`${a/gcd}/${b/gcd}`);
}