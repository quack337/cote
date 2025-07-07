let N = +require('fs').readFileSync(0).toString().trim(),
 S = [];
 DFS(9,0);
 S.sort((a,b) => a-b);
 console.log(N < S.length ? S[N] : -1);

function DFS(d, s) {
  S.push(s);
  for (let i = d; i >= 0; --i)
    DFS(i-1, s*10+i);
}