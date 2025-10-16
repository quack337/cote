let A=Array(10).fill().map((e,i)=>i+1);
for (let i=0; i<10; ++i) {
  let a = (Math.random()*10)|0;
  [A[0],A[a]] = [A[a],A[0]];
}
console.log(A.join(' '));

