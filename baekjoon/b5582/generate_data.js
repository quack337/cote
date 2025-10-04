let A='ABCDEFGHIJKLMNOPQRSTUVWXYZ'.split('');
for (let a=0; a<2; ++a) {
  let S = [], n = 3;
  for (let b=0; b<3000/n; ++b) {
    let ch = A[Math.floor(Math.random() * A.length)];
    for (let c=0; c<n; ++c)
      S.push(ch);
  }
  console.log(S.join(''));
}
