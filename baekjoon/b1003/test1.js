// 0, 1 출력 확인하기
let count
for (let i=0; i<=13; ++i) {
  count = [0,0]
  console.log("%d: %d, zero=%d, one=%d", i, fibonacci(i), count[0], count[1])
}

function fibonacci(n) {
  if (n==0) {
    ++count[0]
    return 0
  } else if (n==1) {
    ++count[1]
    return 1
  } else 
    return fibonacci(n-1) + fibonacci(n-2)
}