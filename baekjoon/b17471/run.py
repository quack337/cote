import subprocess

#command = "node sol.js"
command = "java Main.java"
run = 1

def testFS(inputFile, outputString):
  cmd = command + " < " + inputFile
  result = subprocess.check_output(cmd, shell=True, text=True)
  if result.strip() == outputString:
    print(inputFile, True)
  else: print(inputFile, False, result);

def testSS(inputString, outputString):
  global run
  with open("data_temp", "w") as f:
    f.write(inputString)
  cmd = command + " < data_temp"
  result = subprocess.check_output(cmd, shell=True, text=True)
  tag = "input" + str(run)
  run = run + 1
  if result.strip() == outputString:
    print(tag, True)
  else: print(tag, False, result);

testFS("data1", "1")
testFS("data2", "0")
testFS("data3", "-1")
testFS("data4", "9")

testSS("2\n1 1\n0 0", "0");
testSS("2\n2 1\n0 0", "1");
testSS("2\n3 1\n0 0", "2");

testSS("3\n1 1 1\n0 0 0", "-1");
testSS("3\n1 1 1\n1 2\n1 1\n0", "1");
testSS("3\n2 1 1\n1 2\n1 1\n0", "2");
testSS("3\n1 2 3\n2 2 3\n2 1 3\n2 1 2", "0");
testSS("3\n1 2 3\n2 2 3\n1 1\n1 1", "0");
testSS("3\n3 2 1\n2 2 3\n1 1\n1 1", "2"); # 아! 연결그래프 확인이 아니고, 선택된 노드들만 통과해서 연결되어야 하는군!!