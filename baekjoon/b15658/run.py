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
  else:
    print(tag, False, result)
    exit()

testFS("data1", "30\n30")
testFS("data2", "35\n17")
testFS("data3", "54\n-24")

testSS("2\n1 1\n1 1 1 1", "2\n0")
testSS("2\n2 1\n1 1 1 1", "3\n1")
testSS("3\n1 2 3\n1 1 1 1", "9\n-3")
