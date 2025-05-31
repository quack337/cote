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

testFS("data1", "8")
testFS("data2", "24")
testFS("data3", "5")

testSS("1 0\n0 1 1", "0")
testSS("2 1\n0 1 1\n1 2 1", "0")
testSS("2 1\n0 1 1\n1 2 0", "0")
testSS("3 3\n0 1 1\n1 2 0\n1 3 0\n2 3 1\n", "3")
testSS("3 3\n0 1 0\n1 2 0\n1 3 0\n2 3 1\n", "5")
