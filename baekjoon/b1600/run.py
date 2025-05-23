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

testFS("data1", "4")
testFS("data2", "-1")
testFS("data3", "2")
testFS("data4", "2")
testFS("data5", "2")
testFS("data6", "2")
testFS("data7", "-1")
testFS("data8", "2")
testFS("data9", "2")
testFS("data10", "4")
testFS("data11", "4")
testFS("data12", "4")
testFS("data13", "6")
testFS("data14", "8")
testFS("data15", "16")
testFS("data16", "8")
testFS("data17", "14")
