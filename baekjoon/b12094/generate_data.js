function generateData() {
  let N=10, A=Array(N).fill().map(e=>[]);

  for (let r=0; r<N; ++r)
    for (let c=0; c<N; ++c) {
      let i = Math.random()*N;
      if (i<2) A[r][c] = 0;
      else A[r][c] = 1 << (i-2);
    }
  return A;
}

function print(A) {
  console.log(A.length);
  for (let row of A)
    console.log(row.join(' '));
}

//print(generateData());

exports.generate = function() {
  let A = generateData();
  let out = [];
  out.push(A.length);
  for (let row of A)
    out.push(row.join(' '));
  return out.join('\n');
}