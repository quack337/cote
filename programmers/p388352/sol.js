function check(q, ans, a, b, c, d, e)  {
    for (let i = 0; i < q.length; ++i) {
        let count = 0;
        for (let j = 0; j < 5; ++j) {
            let v = q[i][j];
            if (v == a || v == b || v == c || v == d || v == e)
                ++count;
        }
        if (count != ans[i]) return false;
    }
    return true;
}

function solution(n, q, ans) {
    let answer = 0;
    for (let a = 1; a <= n - 4; ++a)
    for (let b = a + 1; b <= n - 3; ++b)
    for (let c = b + 1; c <= n - 2; ++c)
    for (let d = c + 1; d <= n - 1; ++d)
    for (let e = d + 1; e <= n; ++e)
        if (check(q, ans, a, b, c, d, e))
            ++answer;
    return answer;
}

let n = 10;
let q = [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [3, 7, 8, 9, 10], [2, 5, 7, 9, 10], [3, 4, 5, 6, 7]];
let ans = [2, 3, 4, 3, 3];
let answer = solution(n, q, ans);
console.log(answer);

n = 15;
q = [[2, 3, 9, 12, 13], [1, 4, 6, 7, 9], [1, 2, 8, 10, 12], [6, 7, 11, 13, 15], [1, 4, 10, 11, 14]];
ans = [2, 1, 3, 0, 1];
answer = solution(n, q, ans);
console.log(answer);
