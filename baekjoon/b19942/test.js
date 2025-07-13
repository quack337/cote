let A = [[1,2,3],[10,20,30]];
let C = [].reduce((r,a) => a.map((e,i) => e+r[i]),[0,0,0]);
console.log(C);