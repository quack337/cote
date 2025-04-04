function binarySearch(a, value) {
  let start = 0;
  let end = a.length - 1;
  while (start <= end) {
      let middle = (end + start) >> 1;
      if (value > a[middle])
          start = middle + 1;
      else if (value < a[middle])
          end = middle - 1;
      else
          return [true, middle];
  }
  return [false, start];
}

let a = [1, 10, 20, 30, 40, 50, 60, 70, 80, 90];

for (let value of a) {
  let i = binarySearch(a, value);
  console.log(value, a[i], i);
}
for (let value of a) {
  let i = binarySearch(a, value - 1);
  console.log(value, i);
}
let i = binarySearch(a, 100);
console.log(100, i);

