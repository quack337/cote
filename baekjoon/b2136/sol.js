let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let index = 0;
let N = parseInt(input[index++]);
let L = parseInt(input[index++]);
let ar = [];
for (let i = 0; i < N; ++i) {
  let p = parseInt(input[index++]);
  let ant = {no: i + 1, dir: p < 0 ? -1 : 1, position: Math.abs(p)};
  ant.seconds = ant.dir < 0 ? ant.position : L - ant.position;
  ar.push(ant);
}
let ar1 = ar.slice().sort((a, b) => {
  if (a.dir != b.dir) return a.dir - b.dir;
  return a.dir == -1 ? a.seconds - b.seconds : b.seconds - a.seconds;
});
let maxSeconds = 0, maxIndex = 0;
ar1.forEach((ant, index) => {
  if (ant.seconds > maxSeconds) {
    maxSeconds = ant.seconds;
    maxIndex = index;
  }
});
ar.sort((a, b) => a.position - b.position);
console.log(ar[maxIndex].no, maxSeconds);

