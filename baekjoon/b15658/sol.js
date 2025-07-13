let IN = require('fs').readFileSync(0).toString().split('\n'),
N=+IN[0], A=IN[1].split(' ').map(e=>+e), OP=IN[2].split(' ').map(e=>+e),
S=[], MAX=0, MIN=Infinity
DFS()
console.log(MAX + '\n' + MIN)
console.log(OP)

function DFS() {
  if (S.length==N-1) {
    let val=A[0]
    for (let i=0; i<N-1; ++i)
      switch (S[i]) {
        case 0: val += A[i+1]; break;
        case 1: val -= A[i+1]; break;
        case 2: val *= A[i+1]; break;
        case 3: val = Math.floor(val / A[i+1]); break;
      }
    if (val>MAX) MAX=val
    if (val<MIN) MIN=val
    return
  }
  for (let i=0; i<4; ++i)
    if (OP[i] > 0) {
      S.push(i); OP[i]--
      DFS()
      S.pop(); OP[i]++
    }
}