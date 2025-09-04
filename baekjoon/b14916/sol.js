let N = +require('fs').readFileSync(0).toString();
for (let i=Math.floor(N/5); i>=0; --i)
  if ((N-i*5) % 2 == 0) {
    console.log(i + (N-i*5)/2);
    return;
  }
console.log(-1);