for (N=1; N<=10; ++N) {
  console.log(N, BT(0));
}
function BT(n) {
  if (n==N) return 1;
  let a = BT(n+1); // 악수 안하기
  let b = n<N-1 ? BT(n+2) : 0; // 오른쪽과 악수
  return a+b;
}