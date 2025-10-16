let D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
let T=D.shift()[0];
for (let t=0; t<T; ++t){
  [N,W] = D[t*3];
  A=[D[t*3+1],D[t*3+2]];
  console.log(N,W,A);
}

function BT(n,p,e){
  if(n==0){
  }
  else if(n==N-1){
  }
  else if(n==N-2){
  }
  else{
    let a = A[n][0]+A[n][1]<=W;
    let b = A[n][0]+A[n+1][0]<=W;
    let c = A[n][1]+A[n+1][1]<=W;
    if(p==0)
      return Math.max(
        a && BT(n+1,0,e)+1,
        b && c && BT(n+2,0,e)+2,
        b && BT(n+1,1,e)+1,
        c && BT(n+1,2,e)+1);
    else if(p==1)
      return 

    }
  }
}
