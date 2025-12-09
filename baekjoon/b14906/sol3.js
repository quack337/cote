D=(require('fs').readFileSync(0)+'').trim().split('\n');
N=+D.shift();
F=s=>{
 if(s=='AH'||/^A([DE]F+)+GC$/.test(s))return 1;
 let m=s.match(/^AB(.+)C$/);
 return m&&F(m[1])}
console.log('SLURPYS OUTPUT\n'+
D.map(d=>(m=d.match(/([DE]F+)+G$/),m&&F(d.slice(0,m.index))?'YES\n':'NO\n')).join('')+'END OF OUTPUT')