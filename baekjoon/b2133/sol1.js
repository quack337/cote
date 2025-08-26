let N, A;
for (N = 1; N <= 24; ++N) {
  A = [[],[],[]];
  console.log(N, DFS(0, 0));
}

function DFS(r, c) {
  if (c == N) {
    c = 0;
    if (++r==3) return 1;
  }
  if (A[r][c]) 
    return DFS(r, c+1);
  else {
    let sum = 0;
    if (c < N-1 && !A[r][c+1]) { 
      A[r][c] = A[r][c+1] = 1; 
      sum += DFS(r, c+1); 
      A[r][c] = A[r][c+1] = 0; 
    }
    if (r < 2 && !A[r+1][c]) {
      A[r][c] = A[r+1][c] = 1;
      sum += DFS(r, c+1);
      A[r][c] = A[r+1][c] = 0;
    }
    return sum;
  }
}