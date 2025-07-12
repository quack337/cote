let A=require('fs').readFileSync(0).toString().split(/[\n\r ]+/).map(e=>+e),
S=[], V=[], C=Infinity;
DFS(0,0,0);
console.log(C);

function DFS(n,cost,sum) {
  if (n==3 && sum!=15) return;
  else if (n==6 && sum!=30) return;
  if (n==9) {
    if (valid() && cost<C) C=cost;
    return;
  }
  for (let i=1; i<=9; ++i)
    if (!V[i]) {
      let c = A[n]-i;
      S.push(i); V[i]=1;
      DFS(n+1, cost+(c<0 ? -c:c), sum+i);
      S.pop(); V[i]=0;
    }
}

function valid() {
  let [a,b,c,d,e,f,g,h,i] = S;
  return a+b+c==15 && d+e+f==15 && g+h+i==15 &&
    a+d+g==15 && b+e+h==15 && c+f+i==15 &&
    a+e+i==15 && c+e+g==15;
}
