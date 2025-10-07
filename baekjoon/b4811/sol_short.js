A=(require('fs').readFileSync(0)+'').split('\n').map(e=>+e);
M=Array(31).fill().map(_=>Array(31)),X='';
M[0][0]=1;
BT=(w,h)=>{
 if(M[w][h])return M[w][h];
 return M[w][h]=(w&&BT(w-1,h+1))+(h&&BT(w,h-1));
}
for(i=0;A[i];++i)X+=BT(A[i],0)+'\n';
console.log(X);