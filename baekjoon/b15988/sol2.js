let M=[0,1,2,4];
for (let i=4; i<=20; ++i)
  M[i]=M[i-1]+M[i-2]+M[i-3];
console.log(M);
