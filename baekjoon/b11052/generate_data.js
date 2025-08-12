N=30;
A=[];
for (let i=0; i < N; ++i)
  A.push(Math.floor(Math.random() * 10000) + 1);
console.log(N);
console.log(A.join(' '));