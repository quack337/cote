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

testFS("data1", "1")
testFS("data2", "1")
testFS("data3", "0")
testFS("data4", "1")

testSS("5 1\n0 1", "0")
testSS("5 2\n0 1\n1 2", "0")
testSS("5 3\n0 1\n1 2\n2 3", "0")
testSS("5 4\n0 1\n1 2\n2 3\n3 4", "1")
testSS("5 4\n0 1\n1 2\n2 3\n3 0", "0")
