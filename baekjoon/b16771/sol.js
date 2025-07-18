IN=(require('fs').readFileSync(0)+'').split('\n')
A=map(IN[0])
B=map(IN[1])
set=new Set()
BT(0,A,1000,B,1000)
console.log(set.size)

function map(s) {
  let map = new Map()
  s.split(' ').map(e=>+e).forEach(e=> map.set(e, 1+(map.get(e)||0)))
  return map
}

function BT(n,a,xa,b,xb) {
  if (n==4) {set.add(xa); return}
  for (let [s,c] of a)
    if (c>0) {
      a.set(s,c-1); b.set(s, 1+(b.get(s)||0))
      BT(n+1,b,xb+s,a,xa-s);
      a.set(s,c); b.set(s, b.get(s)-1)
    }
}