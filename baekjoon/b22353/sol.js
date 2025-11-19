[T,W,K]=(require('fs').readFileSync(0)+'').split(' ').map(e=>+e);
W/=100;F=1-W;K=K/100+1;
t=T;X=0;P=W;
for(;;){
 X+=t*P;
 if(W>=1)break;
 W*=K;if(W>1)W=1;
 P=F*W;F*=1-W;
 t+=T;
}
console.log(X)