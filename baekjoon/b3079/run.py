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

testSS("2 6\n7 10", "28")
testSS("7 10\n3 8 3 6 9 2 4", "8")
testSS("1 1\n1", "1")
testSS("1 6\n1", "6")
testSS("1 100000\n1000000000", "100000000000000")
testSS("2 100000\n1000000000\n1000000000", "50000000000000")
testSS("3 6\n1 7 8", "6")
testSS("3 6\n1 4 4", "4")
testSS("3 6\n1 3 4", "4")
testSS("4 6\n1 3 4 5", "4")

