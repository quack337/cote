C=[,[1,3,2],[2,1,1],[2,3,2]];
F=(n,x,i)=>{
  if(n<2) return n?C[x][i]:x;
  let u=3**(n-1);
  return F(n-1,C[x][i/u|0],i%u)}
O=[];
for(i=0;i<27;++i)
  O.push(F(3,2,i));
console.log(O.join())