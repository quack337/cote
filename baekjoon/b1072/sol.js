let fs = require('fs');
let input = fs.readFileSync(0).toString().split(/[ \n\r]+/);
let ii = 0, getInt = () => parseInt(input[ii++]);
let X = getInt(), Y = getInt();

let r = 파라매트릭서치_최소값(1, 1_000_000_000)
console.log(r > 1_000_000_000 ? -1 : r);

function compare(g) {
  let p1 = Math.floor(Y * 100 / X);
  let p2 = Math.floor((Y + g) * 100 / (X + g));
  return p1 == p2 ? -1 : 1;
}

function 파라매트릭서치_최소값(left, right) {
  while (left <= right) {
    let middle = Math.floor((left + right) / 2);
    let r = compare(middle);
    if (r >= 0)
      right = middle - 1;
    else
      left = middle + 1;
  }
  return left;
}