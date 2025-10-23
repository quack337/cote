D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
X='';
for(let i=1;;++i){
 if(!(N=D.shift()[0]))break;
 A=D.splice(0,N);
 a=A[N-1];a[0]+=a[1];a[2]=Infinity;
 for(let r=N-2;r>=0;--r){
  a=A[r];b=A[r+1];
  a[2]+=Math.min(b[1],b[2]);
  a[1]+=Math.min(b[0],b[1],b[2],a[2]);
  a[0]+=Math.min(b[0],b[1],a[1]);
 }
 X+=i+'. '+A[0][1]+'\n';
}
console.log(X);