function solution(distance, rocks, n) {
}   


function sol(value) {
  let start = 0, end = 1_000_000_000;
  while (start <= end) {
    let middle = (start + end) >> 1;
    if (middle < value)
      start = middle + 1;
    else if (middle > value)
      end = middle - 1;
    else
      return middle;
  }
  return -1;
}

for (let i = 0; i <= 1_000_000_000; ++i) {
  if (sol(i) == i) {
    if (i % 10_000_000 == 0)
      console.log(i);
  } else {
    console.log("error", i, sol(i));
    break;
  }
}



