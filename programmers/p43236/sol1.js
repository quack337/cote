// 중단
// function solution(distance, rocks, n) {
  rocks.push(distance);
  rocks.sort((a, b) => a - b);
  let dummy = { value: 9_999_999_999 }, nodes = [ ];
  dummy.prev = dummy.next = dummy;
  for (let i = 0; i < rocks.length; ++i) {
    let node = { value: rocks[i] - (i == 0 ? 0 : rocks[i - 1]),
        prev: dummy.prev, next: dummy };
    node.prev.next = node;
    dummy.prev = node;
    nodes.push(node);
  }
  for (let node = dummy.next; node != dummy; node = node.next)
    console.log(node.value);
  nodes.sort((a, b) => a.value - b.value);
  for (let node of nodes) {
    if (node.prev.value < node.next.value) {
    }
  }
}

solution(25, [2, 14, 11, 21, 17], 2);