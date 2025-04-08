function binarySearch(a, value) {
  let start = 0, end = a.length - 1, middle;
  while (start <= end) {
    middle = (start + end) >> 1;
    if (a[middle] < value)
      start = middle + 1;
    else if (a[middle] > value)
      end = middle - 1;
    else {
      if (start != middle) start = middle;
      else if (a[end] == value) return end;
      else return start;
    }
  }
  return -1;
}

function test_binarySearch() {
  let a = [];
  for (let i = 0; i <= 100; ++i) {
    a.push(i);
    a.push(i);
  }
  let r = [];
  for (let i = 0; i <= 100; ++i) {
    let index = binarySearch(a, i);
    r.push(index);
  }
  console.log(r);
}

test_binarySearch();
