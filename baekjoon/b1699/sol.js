N=+require('fs').readFileSync(0)
a=1
b=2
for(i=3; i<=N; ++i) {
  c = (a + b) % 15746
  b = c
  a = b
}
console.log(c)