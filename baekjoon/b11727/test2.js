let P=[0,1]
for (let i=2; i<=20; ++i) {
  P[i] = P[i-1]*2 + (i%2 ? -1 : 1)
  console.log("%d: %d", i, P[i]);
}
