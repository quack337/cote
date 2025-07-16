let data = require('fs').readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => parseInt(data[idx++]);
let colors = [], N = getInt(), 답=Infinity;
for (let i=0; i < N; ++i) {
  let red = getInt(), green = getInt(), blue = getInt();
  colors[i] = [red, green, blue];
}
let red = getInt(), green = getInt(), blue = getInt();
let rgbGom = [red, green, blue];

DFS(0,0,0,0,0)
console.log(답)

function DFS(index, count, redSum, greenSum, blueSum) {
  if (count > 7) return
  if (N-index + count < 2) return
  if (count==7 || index==N) {
    let diff = calc(count, redSum, greenSum, blueSum);
    if (diff < 답) 답 = diff;
    return
  }

  DFS(index+1, count+1,
      redSum + colors[index][0],
      greenSum + colors[index][1],
      blueSum+colors[index][2]);

  DFS(index+1, count, redSum, greenSum, blueSum)
}

function calc(count, redSum, greenSum, blueSum) {
  let rgb = [redSum, greenSum, blueSum];
  let diff = 0;
  for (let i=0; i < 3; ++i) {
    let avg = Math.floor(rgb[i] / count);
    diff += Math.abs(rgbGom[i] - avg);
  }
  return diff;
}
