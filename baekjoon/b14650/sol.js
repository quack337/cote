let N = +require('fs').readFileSync(0).toString().trim(),답=0
DFS(0,0)
console.log(답)

function DFS(n, x) {
  if (n==N)
    답 += (x%3==0 ? 1 : 0)
  else
    for (let i=0; i<=2; ++i)
      if (n+i > 0) DFS(n+1, x*10 + i)
}
