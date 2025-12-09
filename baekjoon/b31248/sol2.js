N=+(require('fs').readFileSync(0)+'');
X=[];O=(a,b)=>X.push(a+' '+b);
F=(n,a,b,c)=>n<2?!n?0:O(a,c):(F(n-1,a,c,b),O(a,c),F(n-1,b,a,c));
P=(n,a,b,c)=>n<2?!n?0:O(a,'D'):(F(n-2,a,c,b),O(a,c),O(a,'D'),O(c,'D'),P(n-2,b,a,c));
P(N,'A','B','C');
console.log(X.length+'\n'+X.join('\n'))