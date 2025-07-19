// 백준은 통과, 그런데 로컬 실행은 stack overflow
// 더구나 이상한 점은, sol_stackoverflow.js 와 무슨 차이라서 백준 통과이지?????
// 내일 탐구하자 ㅎㅎㅎ
// 아! x/3 x/3 부분 재귀 호출이 먼저 걸려서 DP에 기록되어서, -
//    1재귀 호출은 계속되지 않아서 sol.js는 통과, 그럼에도 보통의 stack 크기는 부족
// 백준 node.js stack 크기 튜닝을 햇겠고, 그래서 node.js 버전업을 안하고 있는 거겠군!
X=+(require('fs').readFileSync(0)+'').trim()
M=[]
DP=(x,d)=>{
  if (x==1) return 0
  if (M[x]) return M[x]
  console.log(d,x)
  let r = x-1
  if (x%3==0) r=Math.min(r,DP(x/3,d+1)+1)
  if (x%2==0) r=Math.min(r,DP(x/2,d+1)+1)
  r=Math.min(r,DP(x-1,d+1)+1)
  return M[x]=r
}
console.log(DP(X,0))
console.log("DONE")