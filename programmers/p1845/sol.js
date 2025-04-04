function solution(nums) {
    return Math.min(nums.length / 2, new Set(nums).size);
}

console.log(solution([3,1,2,3])); // 2
console.log(solution([3,3,3,2,2,4])); // 3
console.log(solution([3,3,3,2,2,2])); // 2

