import subprocess

command = "node sol.js"
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

testFS("data1", "3")

testSS("2 2\n1 3", "2")
testSS("2 2\n1 4", "3")
testSS("3 2\n0 1 3", "3")
testSS("3 3\n0 1 3", "1")
testSS("4 2\n1 2 4 7", "6")
testSS("4 3\n1 2 4 7", "3")
testSS("4 4\n1 2 4 7", "1")
testSS("5 2\n1 2 3 4 5", "4")
testSS("5 3\n1 2 3 4 5", "2")
testSS("5 4\n1 2 3 4 5", "1")
testSS("5 5\n1 2 3 4 5", "1")

