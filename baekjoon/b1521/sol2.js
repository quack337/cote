D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
N=D[0][0];A=D[1];D=[];
BT=_=>{
 let x=0,y=0,k=A.reduce((a,e)=>a*10+e,0);
 if(D[k])return D[k];
 for(let i=0;i<N-1;++i)
 for(let j=i+1;j<N;++j)
  if(A[i]>A[j]){
    [A[i],A[j]]=[A[j],A[i]];
    x+=BT()+1;++y;
    [A[i],A[j]]=[A[j],A[i]];}
  return D[k]=y&&x/y;}
console.log(BT())