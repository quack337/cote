function solution(id) {
  id = id.toLowerCase(); // 1
  id = id.replace(/[^a-z0-9_.-]+/g, ""); // 2
  id = id.replace(/\.+/g, "."); // 3
  id = id.replace(/^\.|\.$/g, ""); // 4
  if (id === "") id = "a"; // 5
  if (id.length >= 16) { // 6
    id = id.substring(0, 15);
    id = id.replace(/\.$/, "");
  }
  while (id.length <= 2) // 7
    id += id.charAt(id.length - 1);
  return id;
}

const a = [
  "!@BaT#*..y.abcdefghijklm", "z-+.^.", "=.=",
  "123_.def", "abcdefghijklmn.p", "." ];
for (let s of a)
  console.log(solution(s));
