let set1 = new Set();

set1.add('a');
set1.add('b');
set1.add('c');

console.log(set1.size); // 3
console.log(set1.has('a')); // true
console.log(set1.has('d')); // false

set1.delete('a');
console.log(set1.size); // 2
console.log(set1.has('a')); // false

let set2 = new Set(['a', 'b', 'c', 'd']);
console.log(set2.size); // 4

let set3 = set1.intersection(set2);
console.log(set3); // Set { 'b', 'c' }
