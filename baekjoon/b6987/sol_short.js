let fs = require('fs');
let data = fs.readFileSync(0).toString().split(/[ \n\r]+/), ii=0;
let getInt = () => +data[ii++];
let G = [[0,1],[0,2],[0,3],[0,4],[0,5],[1,2],[1,3],[1,4],[1,5],[2,3],[2,4],[2,5],[3,4],[3,5],[4,5]];
let 승, 무, 패, 승합=0, 무합=0, 패합=0, ans = ''
for (let t = 0; t < 4; ++t) {
  승=[]; 무=[]; 패=[];
  for (let i = 0; i < 6; ++i) {
    승.push(getInt()); 무.push(getInt()); 패.push(getInt());
  }
  ans += check(0)+'\n';
}
console.log(ans);

function check() {
  for (let i = 0; i < 5; ++i)
    if (승[i]+무[i]+패[i] != 5) return 0;
  let 승수 = 승.reduce((r,e) => r+e);
  let 무수 = 무.reduce((r,e) => r+e);
  let 패수 = 패.reduce((r,e) => r+e);
  if (승수 != 패수 || 15-승수 != 무수/2) return 0;
  return DFS(0);
}

function DFS(n) {
  if (n == 15)
    return 승.reduce((r,e) => r+e) == 0 &&
      무.reduce((r,e) => r+e) == 0 &&
      패.reduce((r,e) => r+e) == 0;
  else
    for (let g = 0; g < 3; ++g) {
      if (!valid(n, g)) continue;
      push(n, g);
      if (DFS(n + 1)) return 1;
      pop(n, g);
    }
  return 0;
}

function valid(n, g) {
  let [a, b] = G[n];
  return (
   (g == 0 && 승[a] > 0 && 패[b] > 0) ||
   (g == 1 && 무[a] > 0 && 무[b] > 0) ||
   (g == 2 && 패[a] > 0 && 승[b] > 0));
}

function push(n, g) {
  let [a, b] = G[n];
  if (g==0) { 승[a]--; 패[b]--; }
  else if (g==1) { 무[a]--; 무[b]--; }
  else { 패[a]--; 승[b]--; }
}

function pop(n, g) {
  let [a, b] = G[n];
  if (g==0) { 승[a]++; 패[b]++; }
  else if (g==1) { 무[a]++; 무[b]++; }
  else { 패[a]++; 승[b]++; }
}