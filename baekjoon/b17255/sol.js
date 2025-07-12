let IN=require('fs').readFileSync(0).toString().trim(),
N=+IN, X=0, A=IN.split('').reduce((r,e)=>r.includes(e)?r:[...r,e],[])
DFS('')
console.log(X)

function DFS(s) {
  if (IN.indexOf(s)<0) return
  let val= +s
  if (val==N) {++X; return;}
  if (val>N || s.length>=IN.length) return
  for (let i of A) {
    let s1= i+s, s2= s+i
    DFS(s1)
    if (s1!=s2) DFS(s2)
  }
}
