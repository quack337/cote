S='abc'.split('');
X=new Set();
R=(s,p,q)=>{for(let i=0;p+i<q-i;++i)[s[p],s[q]]=[s[q],s[p]];return s;}
F=(s,p,q)=>{
 //console.log(p,q);
 if(p==q){X.add(s.join(''));return}
 let m=(p+q)/2|0;
 F(R([...s],m+1,q),p,m);
 F(R([...s],p,m),m+1,q);
 if((p+q)%2==0){
   F(R([...s],m,q),p,m-1);
   F(R([...s],p,m-1),m,q)}}
F(S,0,2);
console.log(X);