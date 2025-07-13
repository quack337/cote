let rd=require('readline').createInterface({input:process.stdin,output:process.stdout}), IN=[];
rd.on('line', s=>IN.push(s));
console.log(IN);