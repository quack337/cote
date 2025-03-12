let a1 = [];
let a2 = new Map();
for (let i = 0; i < 10; ++i) {
  a1[i] = i * 10;
  a2.set(i, i * 10);
}

for (let i = 0; i < 10; ++i)
  console.log(a1[i], a2.get(i));

