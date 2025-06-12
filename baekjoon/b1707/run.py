import subprocess

command = "node sol.js"
#command = "java Main.java"
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

testFS("data1", "YES\nNO")

testSS("1\n1 1\n1 1", "YES")
testSS("1\n2 1\n1 2", "YES")
testSS("1\n2 2\n1 2\n2 1", "YES")
testSS("1\n2 3\n1 2\n2 1\n1 1", "YES")
testSS("1\n2 4\n1 2\n2 1\n1 1\n2 2", "YES")
testSS("1\n3 1\n1 2", "YES")
testSS("1\n3 2\n1 2\n2 2", "YES")
testSS("1\n3 2\n1 2\n2 3", "YES")
testSS("1\n3 3\n1 2\n2 3\n3 1", "NO")
testSS("1\n4 4\n1 2\n2 3\n3 4\n4 1", "YES")
testSS("1\n4 3\n2 3\n3 4\n4 2", "NO")
testSS("1\n5 4\n1 2\n3 4\n4 5\n5 3", "NO")
testSS("1\n5 4\n1 2\n3 4\n4 5\n5 1", "YES")
