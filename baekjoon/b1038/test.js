let A = [ 1, 1, -2, 3, -10 ];
let N = A.length, R = [];
for (let i=0; i<N; ++i)
  for (let j=i; j<N; ++j) {
    let t = A.slice(i,j+1).reduce((r,e)=>r+e);
    let s = t>0 ? '+' : (t<0 ? '-' : '0');
    R.push(s);
  }
console.log(R.join(''));

