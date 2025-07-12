let IN=require('fs').readFileSync(0).toString().trim();
N=+IN, ANS=0, A=[], V=[]
for (let ch of IN.split('')) {
  let i=+ch;
  if (!V[i]) { V[i]=1; A.push(i); }
}
DFS('');
console.log(ANS);

function DFS(s) {
  if (IN.indexOf(s)<0) return;
  let val = +s;
  if (val==N) { ++ANS; return; }
  if (val > N || s.length>=IN.length) return;
  for (let i of A) {
    let s1 = i+s, s2 = s+i;
    DFS(s1);
    if (s1 != s2) DFS(s2);
  }
}
