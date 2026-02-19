function F(n) {
  if (n==1) return 0;
  if (n==2) return 0.5;
  let x1 = F(n-1);
  let x2 = x1 + (n-1)/2;
  return x2;
}

for (let n=1; n<=10; ++n)
  console.log(n, F(n));