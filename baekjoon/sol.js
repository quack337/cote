let A=(require('fs').readFileSync(0)+'').split('\n').map(s=>s.split(' ').map(e=>+e));
let A=(require('fs').readFileSync(0)+'').split(/\s/).map(e=>+e);
