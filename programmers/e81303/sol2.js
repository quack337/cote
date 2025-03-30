function solution(크기, 현재, 명령목록) {
  const 삭제목록 = [];
  for (const 명령 of 명령목록) {
    const 이동 = 명령.length < 2 ? 0 : parseInt(명령.substring(2));
    let index = 0;
    switch (명령.charAt(0)) {
      case 'U': 현재 = Math.max(0, 현재 - 이동); break;
      case 'D': 현재 = Math.min(현재 + 이동, 크기 - 1); break;
      case 'C': 삭제목록.push(현재);
                --크기;
                if (현재 === 크기) --현재;
                break;
      case 'Z': index = 삭제목록.pop();
                if (index <= 현재) ++현재;
                ++크기;
                break;
    }
  }
  const result = new Map();
  for (let i = 0;
  const result = Array(크기).fill('O');
  while (삭제목록.length > 0) {
    const index = 삭제목록.pop();
    result.splice(index, 0, 'X');
  }
  return result.join('');
}

const s1 = ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"];
console.log(solution(8, 2, s1));
const s2 = ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"];
console.log(solution(8, 2, s2));
