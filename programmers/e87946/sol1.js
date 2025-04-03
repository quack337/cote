function solution(k, dungeons) {
  let 답 = 0;
  순서선택(dungeons.length, []);  
  return 답;

  function 순서선택(N, 선택된순서) {
    if (선택된순서.length == N) {
      답찾기(선택된순서);
      return;
    }
    for (let i = 0; i < N; ++i)
      if (선택된순서.includes(i) == false)
        순서선택(N, [...선택된순서, i]);
  }

  function 답찾기(선택된순서) {
    const 필요 = 0, 소모 = 1;
    let 현재피로도 = k, 방문수 = 0;
    for (let i = 0; i < 선택된순서.length; ++i) {
      let 방문할던전 = 선택된순서[i];
      if (dungeons[방문할던전][필요] > 현재피로도) 
        break;
      ++방문수;
      현재피로도 -= dungeons[방문할던전][소모];
    }
    답 = Math.max(답, 방문수);
  }
}

console.log(solution(80, [[80,20],[50,40],[30,10]]));