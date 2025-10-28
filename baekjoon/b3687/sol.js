D=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
C=[6,2,5,5,4,5,6,3,7,6]
T=D[0];
P=Array(101).fill().map(e=>[]);
Q=Array(101).fill().map(e=>[]);
X='';INF=BigInt(10n**30n);
for(let t=1;t<=T;++t)
  X+=BN(D[t],0)+' '+BX(D[t],0)+'\n';
console.log(X);

function BX(n,z){
  let x=-1n;
  if(P[n][z]!=undefined)return P[n][z];
  for(let i=z?0n:1n; i<10n; ++i) {
    if (n==C[i]) {if(i>x)x=i;}
    else if(n>C[i]) {
      let t = BX(n-C[i], z||i?1:0);
      if (t>=0n) {
        let w = BigInt(''+i+''+t);
        if (w>x)x=w;
      }
    }
  }
  return P[n][z]=x;
}

function BN(n,z){
  let x=INF;
  if(Q[n][z]!=undefined)return Q[n][z];
  // 앞자리 0을 보존하기 위해서 문자열로.
  // '001' 보다 '88' 이 작아야 함. 그래서 앞에 1을 붙여서 비교.
  for(let i=z?0:1; i<10; ++i) {
    if (n==C[i]) { if(BigInt(i)<BigInt(x)) x=i; }
    else if(n>C[i]) {
      let t = BN(n-C[i], z||i?1:0);
      if (t<INF) {
        t = i+''+t;
        if(BigInt('1'+t)<BigInt('1'+x)) x=t;
      }
    }
  }
  return Q[n][z]=x;
}
