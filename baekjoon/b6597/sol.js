F=(a,b)=>{let n=a.length,r=a[0],i=b.indexOf(r);return n<2?n?[,r]:0:[F(a.slice(1,1+i),b.slice(0,i)),r,F(a.slice(1+i),b.slice(i+1))]}
P=a=>a?P(a[0])+P(a[2])+a[1]:''
for([A,B]of(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ')))if(A)console.log(P(F(A,B)))