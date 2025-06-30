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

testFS("data1", "2\n4")
testFS("data2", """1 7
1 9
7 1
7 9
9 1
9 7
9 9""")
testFS("data3", "1 1 1 1")

#testSS("2 2\n1 3", "2")
