let [N,M,K]=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
F1(N,M,[]);

function F1(n,m,s) {
  if (!n && !m) { console.log(s.join('')); return;}
  if (n) { s.push(0); F1(n-1,m,s); s.pop();}
  if (m) { s.push(1); F1(n,m-1,s); s.pop();}
}