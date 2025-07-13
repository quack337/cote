function compare(middle) {
  let count = 1;
  let prev = A[0];
  for (let i = 1; i < A.length; ++i)
    if (A[i] - prev >= middle) {
      ++count;
      prev = A[i];
  }
  return C - count;
}

let A = [1, 2, 3]; // 집의 위치
let C = 2; // 공유기 2개 설치 목표
console.log(compare(1) < 0); // 1이상 간격으로 공유기를 설치하면 3개 설치 가능. 너무 많다.
                             // 간격 1은 너무 좁다. 음수 리턴
console.log(compare(2) == 0); // 2이상 간격으로 공유기를 설치하면 2개 설치 가능.
                             // ok 0 리턴.
console.log(compare(3) > 0); // 3이상 간격으로 공유기를 설치하면 1개 설치 가능.
                             // 간격 3은 너무 넓다. 양수 리턴
