let M=['A'];
for (let n=1; n<=20; ++n) {
  let N = [];
  for (let i=0; i<M.length; ++i) {
    if (M[i]=='A') N.push('B');
    else { N.push('B'); N.push('A'); }
  }
  console.log(n, N.filter(e=>e=='A').length, N.filter(e=>e=='B').length);
  M = N;
}
