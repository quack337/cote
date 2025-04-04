function solution(fees, records) {
  let [기본시간, 기본요금, 단위시간, 단위요금] = fees;
  let 주차시각 = new Map();
  let 누적시간 = new Map();

  records.forEach(record => {
    let [시각, 차번호, 상태] = record.split(' ');
    let [시, 분] = 시각.split(':').map(Number);
    if (상태 === 'IN')
      주차시각.set(차번호, 시 * 60 + 분);
    else {
      let 시간 = 시 * 60 + 분 - 주차시각.get(차번호);
      누적시간.set(차번호, (누적시간.get(차번호) || 0) + 시간);
      주차시각.delete(차번호);
    }
  });

  주차시각.forEach((시각, 차번호) => {
    let 시간 = (23 * 60 + 59) - 시각;
    누적시간.set(차번호, (누적시간.get(차번호) || 0) + 시간);
  });

  let list = [];
  Array.from(누적시간.keys()).sort().forEach(차번호 => {
    let 시간 = Math.max(0, 누적시간.get(차번호) - 기본시간);
    let 요금 = 기본요금 + Math.ceil(시간 / 단위시간) * 단위요금;
    list.push(요금);
  });
  return list;
}

let f1 = [180, 5000, 10, 600];
let r1 = ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"];
console.log(solution(f1, r1));

let f2 = [120, 0, 60, 591];
let r2 = ["16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"];
console.log(solution(f2, r2));

let f3 = [1, 461, 1, 10];
let r3 = ["00:00 1234 IN"];
console.log(solution(f3, r3));
