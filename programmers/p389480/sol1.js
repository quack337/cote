const A = 0, B = 1;

function B금액계산(가격목록, A금액) {
    console.log("-", A금액)
    let B금액 = 0;
    for (let 가격 of 가격목록)
        if (가격[A] <= A금액) A금액 -= 가격[A];
        else B금액 += 가격[B];
    console.log(" ", A금액, B금액);
    return B금액;
}

function solution(가격목록, A파산금액, B파산금액) {
    가격목록.sort((가격1, 가격2) => {
        가중치1 = 가격1[B] / 가격1[A];
        가중치2 = 가격2[B] / 가격2[A];
        if (가중치2 != 가중치1) return 가중치2 - 가중치1;
        return 가격1[A] - 가격2[A];
    });
    console.log(가격목록);
    for (let A금액 = 0; A금액 < A파산금액; ++A금액)
        if (B금액계산(가격목록, A금액) < B파산금액)
            return A금액
    return -1;
}

let info = [[1, 2], [2, 3], [2, 1]];
console.log(solution(info, 4, 4));
