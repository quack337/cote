function solution(phone_book) {
  let list = Array.from({ length: 21 }, () => []);
  for (let no of phone_book)
    list[no.length].push(no);
  for (let size1 = 1; size1 <= 20; ++size1)
    for (let s1 of list[size1])
      for (let size2 = size1 + 1; size2 <= 20; ++size2)
        for (let s2 of list[size2])
          if (s2.startsWith(s1)) 
            return false;
  return true;
}

console.log(solution(["119", "97674223", "1195524421"]));
console.log(solution(["123", "456", "789"]));
console.log(solution(["12", "123", "1235", "567", "88"]));
