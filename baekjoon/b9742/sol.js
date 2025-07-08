let D=require('fs').readFileSync(0).toString().split(/[\r\n]+/);
let A, N, S, V, CNT, cnt, OUT=[];
for (let d of D) {
  let da = d.split(' ');
  if (da.length < 2) break;
  A = da[0].split(''); // 이미 사전순
  CNT = +da[1]; cnt = 0; N = A.length; S = []; V = [];
  OUT.push(d + ' = ' + (DFS(0) || 'No permutation'));
}
console.log(OUT.join('\n'));

function DFS(n) {
  if (n == N)
    return ++cnt == CNT ? S.join('') : null;
  for (let i=0; i<N; ++i)
    if (!V[i]) {
      S.push(A[i]); V[i] = true;
      let s = DFS(n+1);
      if (s) return s;
      S.pop(); V[i] = false;
    }
  return null;
}