let A=require('fs').readFileSync(0).toString().split('\n')[1].trim().split('')
 .map(e=> (e>='0' && e<='9') ? +e : e), N=A.length, ANS=-Infinity, F=Array(N).fill(0);
DFS(1);
console.log(ANS);

function DFS(n) {
  if (n>=N) {
    ANS = Math.max(ANS, calc(A));
    return;
  }
  if ((n==1 || !F[n-2]) && (n==N-2 || !F[n+2])) { // 좌우 연산자에 괄호가 없어야 함
    F[n] = 1; DFS(n + 2);
  }
  F[n] = 0; DFS(n + 2);
}

function calc(A) {
  let B=[...A];
  for (let i=1; i<N; i+=2)
    if (F[i]) {
      B[i-1] = '('+B[i-1];
      B[i+1] = B[i+1]+')';
    }
  return eval(B.join(''));
}