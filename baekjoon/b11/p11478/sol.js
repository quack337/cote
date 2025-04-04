const fs = require('fs');
const s = fs.readFileSync(0).toString().trim();
const set = new Set();
for (let a = 0; a < s.length; a++)
    for (let b = a + 1; b <= s.length; b++)
        set.add(s.substring(a, b));
console.log(set.size);