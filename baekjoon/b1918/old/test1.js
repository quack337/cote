A='A*B+C*D/E-C'.split('');
B=[];
for(let i=0;i<A.length;++i)
  if(A[i]=='*'||A[i]=='/')
    B.push([B.pop(), A[i], A[++i]]);
  else
    B.push(A[i]);
console.log(B)