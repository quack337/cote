E=(a,b)=>b?E(b,a%b):a;
for(a=1;a<=20;++a)
  for(b=1;b<=20;++b)
    console.log(a, b, E(a,b))
console.log(E(12,18))
console.log(E(18,12))