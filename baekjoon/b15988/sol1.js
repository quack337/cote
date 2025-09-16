for (let i=1; i<=20; ++i)
  console.log(i, DFS(i));

function DFS(n) {
  if (n<0) return 0;
  if (n==0) return 1;
  return DFS(n-1) + DFS(n-2) + DFS(n-3);
}