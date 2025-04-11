let a = {};
const N = 200;
for (let i = 0; i < N; ++i) {
  let key = Math.floor(Math.random() * N);
  a[key] = i;
}

console.log(a)
console.log(Object.keys(a).join(' '))