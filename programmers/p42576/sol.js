function solution(participant, completion) {
  const map = new Map();
  for (const p of participant)
    map.set(p, (map.get(p) || 0) + 1);
  for (const c of completion) {
    map.set(c, map.get(c) - 1);
    if (map.get(c) === 0)
      map.delete(c);
  }
  return map.keys().next().value;
}

console.log(solution(["leo", "kiki", "eden"], ["eden", "kiki"]));
console.log(solution(["marina", "josipa", "nikola", "vinko", "filipa"], ["josipa", "filipa", "marina", "nikola"]));
console.log(solution(["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]));
