A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
M=A.pop();N=A.shift();
BT=(n,m)=>{
  if(n<0||!m)return "";
  let x="";
  for(let p=A[n],pp=0,s="";pp<=m;pp+=p,s+=n) {
    if (n==0) console.log("pp:%d s:%s", pp, s);
    let t = s+BT(n-1,m-pp);
    if (+t>+x)x=t;
  }
  return x;
}
console.log(BT(N-1,M));
