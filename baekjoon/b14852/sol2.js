for(N=1; N<=15; ++N){
  A=Array(2).fill().map(_=>[]);
  console.log(N, BT(0,0,0));
}

function BT(c,p){
  if (c==N) return 1;
  let x = 0;
  if (p==0) { // c열 2칸 empty
    // 세로 2칸 채우기 2가지 방법
    x += BT(c+1,0) * 2;
    // 1행:2칸 2행:1칸 채우기
    if (c<N-1) x += BT(c+1,1);
    // 1행:1칸 2행:2칸 채우기
    if (c<N-1) x += BT(c+1,2);
    // 1행:2칸 2행:2칸 채우기
    if (c<N-1) x += BT(c+2,0);
  }
  else if (p == 1) { // c열 첫칸만 채워짐
    // 둘째칸만 채우기 한가지 방법
    x += BT(c+1,0);
    // 둘째칸 가로2칸 채우기
    if (c<N-1) x += BT(c+1,2);
  }
  else if (p == 2) { // c열 둘째칸만 채워짐
    // 첫째칸만 채우기 한가지 방법
    x += BT(c+1,0);
    // 첫째칸 가로2칸 채우기
    if (c<N-1) x += BT(c+1, 1);
  }
  return x;
}