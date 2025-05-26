import subprocess

command = "node sol.js"

def testFS(inputFile, outputString):
  cmd = command + " < " + inputFile
  result = subprocess.check_output(cmd, shell=True, text=True)
  if result.strip() == outputString:
    print(inputFile, True)
  else: print(inputFile, False, result);

def testSS(tag, inputString, outputString):
  with open("data_temp", "w") as f:
    f.write(inputString)
  cmd = command + " < data_temp"
  result = subprocess.check_output(cmd, shell=True, text=True)
  if result.strip() == outputString:
    print(tag, True)
  else: print(tag, False, result);

testFS("data1", "200")
testSS("data2", "1 1\n100", "100")
testSS("data3", "1 1\n200", "200")
testSS("data4", "1 2\n200", "100")
testSS("data5", "1 3\n200", "66")
testSS("data6", "1 4\n200", "50")
testSS("data7", "1 1\n1", "1")
testSS("data8", "1 1\n2147483647", "2147483647")
testSS("data9", "2 2\n2147483647 2147483647", "2147483647")
testSS("data10", "2 4\n2147483647 2147483647", "1073741823")
testSS("data11", "1 100\n100", "1")
testSS("data12", "1 99\n100", "1")
