import subprocess

command = "node sol.js"
#command = "java Main3.java"
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

testFS("data1", "3\n0")

testSS("1\n1\n1", "0")   # 1명 자신
testSS("1\n2\n1 2", "0") # 2명 자신
testSS("1\n2\n2 1", "0") # 2명 사이클
testSS("1\n3\n2 1 3", "0") # 2명 사이클, 1명 자신
testSS("1\n3\n2 1 1", "1") # 2명 사이클, 1명 다른 팀
testSS("1\n3\n1 2 3", "0") # 3명 자신
testSS("1\n4\n1 2 3 4", "0") # 4명 자신
testSS("1\n8\n1 2 3 4 5 6 7 8", "0") # 8명 자신
testSS("1\n8\n2 3 4 5 6 7 8 1", "0") # 8명 사이클
testSS("1\n8\n2 3 4 5 6 7 8 8", "7") # 마지막 1명 사이클
testSS("1\n8\n2 3 4 5 5 5 6 7", "7") # 중간 1명 사이클
