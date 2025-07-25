// 답
let A=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e),
N=A.shift(), M=[[],[]]
console.log(Math.max(BT(0,0), N==1 ? 0 : BT(1,0)))

function BT(n, prev, dp) {
  if (n==N-1) return A[n]
  if (M[prev][n]) return M[prev][n]
  let a=-Infinity, b=-Infinity // 둘 다 이렇게 초기화 하지 않고 0으로 초기화하면
                               // n-2 칸에서 A[n-2] 점수를 리턴하게됨
  if (!prev) a=BT(n+1, 1)
  if (n<N-2) b=BT(n+2, 0)
  return M[prev][n] = Math.max(a,b) + A[n]
}