import fs from 'fs';

if (!fs.existsSync('old')) fs.mkdirSync('old');
let files = fs.readdirSync('.');
files.forEach(f => {
  if (!f.endsWith('.java')) return;
  console.log(f);
  let s = fs.readFileSync(f).toString().trim();
  s = s.replaceAll(/^(package .+);/g, '$1.old;');
  fs.writeFileSync('old/' + f, s)
  fs.rmSync(f);
});