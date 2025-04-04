function solution(clothes) {
  const map = new Map();
  for (const [_, type] of clothes)
    map.set(type, (map.get(type) || 0) + 1);
  let answer = 1;
  for (const count of map.values())
    answer *= (count + 1);
  return answer - 1;
}

console.log(solution([["yellowhat", "headgear"], ["bluesunglasses", "eyewear"],
  ["green_turban", "headgear"]]));
console.log(solution([["crowmask", "face"], ["bluesunglasses", "face"],
  ["smoky_makeup", "face"]]));
