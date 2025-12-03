A=(require('fs').readFileSync(0)+'').trim();
S=[];x=0;
for(let i=0;i<A.length;++i){
 if(A[i]=='('){S.push([+A[i-1],x-1]);x=0}
 else if(A[i]==')'){s=S.pop();x=s[0]*x+s[1]}
 else ++x;}
console.log(x)