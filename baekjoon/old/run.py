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
  else:
    print(tag, False, result)
    exit()

def testSF(inputString, output):
  global run
  with open("data_temp", "w") as f:
    f.write(inputString)
  cmd = command + " < data_temp"
  result = subprocess.check_output(cmd, shell=True, text=True)
  tag = "input" + str(run)
  run = run + 1
  if float(result.strip()) == output:
    print(tag, True)
  else:
    print(tag, False, result)
    exit()

testFS("data1", "3")

testSS("2 2\n1 3", "2")
testSS("2 2\n1 4", "3")
testSS("3 2\n1 2 3", "2")
testSS("3 3\n1 2 3", "1")
