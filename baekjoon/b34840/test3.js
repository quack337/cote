function F(n) {
  if (n==1) return [1,0];
  if (n==2) return [2,0.5];
  let [count1, x1] = F(n-1);
  let count2 = count1 * n;
  let x2 = x1 + (n-1)/2;
  return [count2, x2];
}

for (let n=1; n<=10; ++n)
  console.log(n, F(n));