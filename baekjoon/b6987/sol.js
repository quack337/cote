let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), idx = 0;
let getInt = () => +data[idx++];
let ncr = [[0,1],[0,2],[0,3],[0,4],[0,5],[1,2],[1,3],[1,4],[1,5],
 [2,3],[2,4],[2,5],[3,4],[3,5],[4,5]];
let 승, 무, 패, result = [];
for (let t = 0; t < 4; ++t) {
  승 = []; 무 = []; 패 = [];
  for (let i = 0; i < 6; ++i) {
    승.push(getInt());
    무.push(getInt());
    패.push(getInt());
  }
  result.push(check(0) ? 1 : 0);
}
console.log(result.join(' '));

function check() {
  for (let i = 0; i < 5; ++i)
    if (승[i]+무[i]+패[i] != 5) return false;
  let 승수 = 승.reduce((r,e) => r+e);
  let 무수 = 무.reduce((r,e) => r+e);
  let 패수 = 패.reduce((r,e) => r+e);
  if (승수 != 패수 || 15-승수 != 무수/2) return false;
  return DFS(0);
}

function DFS(index) {
  if (index == 15)
    return 승.reduce((r,e) => r+e) == 0 &&
      무.reduce((r,e) => r+e) == 0 &&
      패.reduce((r,e) => r+e) == 0;
  else
    for (let g = 0; g < 3; ++g) {
      if (!possible(index, g)) continue;
      push(index, g);
      if (DFS(index + 1)) return true;
      pop(index, g);
    }
  return false;
}

function possible(index, g) {
  let [a, b] = ncr[index];
  return (
   (g == 0 && 승[a] > 0 && 패[b] > 0) ||
   (g == 1 && 무[a] > 0 && 무[b] > 0) ||
   (g == 2 && 패[a] > 0 && 승[b] > 0));
}

function push(index, g) {
  let [a, b] = ncr[index];
  if (g == 0) { 승[a]--; 패[b]--; }
  else if (g == 1) { 무[a]--; 무[b]--; }
  else { 패[a]--; 승[b]--; }
}

function pop(index, g) {
  let [a, b] = ncr[index];
  if (g == 0) { 승[a]++; 패[b]++; }
  else if (g == 1) { 무[a]++; 무[b]++; }
  else { 패[a]++; 승[b]++; }
}