function solution(phone_book) {
  let list = Array.from({ length: 21 }, () => []);
  for (let no of phone_book)
    list[no.length].push(no);
  let set = new Set();
  for (let size = 1; size <= 20; ++size)
    for (let no of list[size]) {
      for (let i = 1; i < size; ++i)
        if (set.has(no.substring(0, i)))
          return false;
      set.add(no);
    }
  return true;
}

console.log(solution(["119", "97674223", "1195524421"]));
console.log(solution(["123", "456", "789"]));
console.log(solution(["12", "123", "1235", "567", "88"]));
`