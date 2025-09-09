
function DFS(n) {
  if (n<0) return 0;
  if (n==0) return 1;
  return DFS(n-1) + DFS(n-2) + DFS(n-3);
}