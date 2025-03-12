function solution(genres, plays) {
    let 장르정보맵 = new Map();
    for (let i = 0; i < genres.length; i++) {
        let 장르명 = genres[i], 재생수 = plays[i];
        if (!장르정보맵.has(장르명))
            장르정보맵.set(장르명, { 총재생수: 0, 곡목록: [] });
        let 장르정보 = 장르정보맵.get(장르명);
        장르정보.총재생수 += 재생수;
        장르정보.곡목록.push({ 번호: i, 재생수: 재생수 });
    }
    let 장르목록 = Array.from(장르정보맵.values());
    장르목록.sort((a, b) => b.총재생수 - a.총재생수);
    for (let 장르정보 of 장르목록)
        장르정보.곡목록.sort((a, b) => b.재생수 - a.재생수);
    var answer = [];
    for (let 장르정보 of 장르목록) {
        let { 곡목록 } = 장르정보;
        answer.push(곡목록[0].번호);
        if (곡목록.length > 1) answer.push(곡목록[1].번호);
    }
    return answer;
}

console.log(solution(["classic", "pop", "classic", "classic", "pop"],
    [500, 600, 150, 800, 2500])); // [4, 1, 3, 0]