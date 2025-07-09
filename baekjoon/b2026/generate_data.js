function generate(ok) {
  let K=62, N=600;
  let OUT = [''];

  for (let a=1; a<N; ++a)
    for (let i=1; i<=9 && a+i<=N; ++i)
      OUT.push(a + ' ' + (a+i));

  // a=540 이면 답 없음 (600-540+1) = 61명 K
  // a=539 이면, 539 부터 600까지가 답 (600-539+1) = 62명 K
  for (let a=ok ? 539 : 540; a<600; ++a)
    for (let b=a+1; b<=600; ++b)
      OUT.push(a + ' ' + b);

  OUT[0] = '' + String(K) + ' ' + String(N) + ' ' + String(OUT.length-1);
  return OUT.join('\n');
}

exports.generate_false = function() {
  return generate(false);
}

exports.generate_true = function() {
  let out = [];
  for (let a=539; a<=600; ++a)
    out.push(a);
  return {in:generate(true), out:out.join('\n')};
}