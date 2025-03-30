function solution(arr)
{
  const answer = [];
  answer.push(arr[0]);
  for (let value of arr)
    if (value != answer[answer.length - 1])
      answer.push(value);
    return answer;
}

console.log(solution([1,1,3,3,0,1,1]));
console.log(solution([4,4,4,3,3]));