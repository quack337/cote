import subprocess

#command = "node sol3.js"
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

testFS("data1", "3\n1 7 13")
testFS("data2", "1\n1")
testFS("data3", "2\n1 1")
testFS("data4", "1\n7")
testFS("data5", "1\n8")
testFS("data6", "1\n10000")
testFS("data7", "1\n9996")
