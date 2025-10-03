let IN=require('fs').readFileSync(0).toString().split(/\s/).map(e=>+e);
let [N,M] = IN;
let mems=IN.slice(2, 2+N), costs=IN.slice(2+N);
let DP=Array(N).fill().map(_=>[]);
console.log(paraSrchMin(0,10000));

// cost이하 금액으로 확보할 수 있는 메모리 최대값
function DFS(n,cost) {
  if (cost<0 || n==N) return 0;
  if (DP[n][cost]!=undefined) return DP[n][cost];
  let a = DFS(n+1, cost);
  let b = costs[n] <= cost ? DFS(n+1, cost-costs[n]) + mems[n] : 0;
  return DP[n][cost] = Math.max(a, b);
}

function compare(mid) {
  let mem = DFS(0, mid);
  //console.log('cost:%d  mem:%d', mid, mem);
  return mem - M;
}

function paraSrchMin(left, right) {
  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    let r = compare(mid);
    if (r >= 0)
      right = mid - 1;
    else
      left = mid + 1;
  }
  return left;
}
