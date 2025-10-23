D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
for(;;){
 if(!(N=D.shift()[0]))break;
 A=D.splice(0,N);
 console.log(N,A);
}

function BT(r,c){
  if(r==N-1){
    if(c==1)return A[r][1];
    
  }
}