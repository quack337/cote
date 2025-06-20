import subprocess

#command = "node sol.js"
command = "java Main2.java"
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

testFS("data1", "4")

testSS("1 1\n0", "0")
testSS("2 2\n0 0\n0 1", "1")
testSS("4 4\n0 0 0 0\n0 1 1 0\n0 1 1 0\n0 0 0 0", "1")
testSS("""5 5
0 0 0 0 0
0 1 0 1 0
0 1 0 1 0
0 1 1 1 0
0 0 0 0 0""", "1")
testSS("""5 5
0 0 0 0 0
0 1 1 1 0
0 1 0 1 0
0 1 1 1 0
0 0 0 0 0""", "2")
testSS("""5 5
0 0 0 0 0
0 1 1 1 0
0 1 1 1 0
0 1 1 1 0
0 0 0 0 0""", "3")


