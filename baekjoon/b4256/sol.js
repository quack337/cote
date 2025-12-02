D=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.trim().split(' ').map(e=>+e));
F=(a,b)=>{
 let l=a.length;
 if(l<2) return l&&[,a[0]];
 let r=a[0],n=b.indexOf(r);
 return [F(a.slice(1,n+1),b.slice(0,n)),r,F(a.slice(n+1),b.slice(n+1))];
}
P=a=>!a ? '' : P(a[0])+P(a[2])+a[1]+' ';
T=D[0][0];t=1;
while(T--){
 N=D[t++];A=D[t++];B=D[t++];
 console.log(P(F(A,B)).trim());
}