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

testFS("data1", "3")
testFS("data2", "2")
testFS("data3", "0")
testFS("data4", "4")
testFS("data5", "6")
testFS("data6", "3")
testFS("data7", "3")
testFS("data8", "8")
testFS("data9", "0")

