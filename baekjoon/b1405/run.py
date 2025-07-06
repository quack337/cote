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

testSF("2 25 25 25 25", 0.75)
testSF("1 25 25 25 25", 1.0)
testSF("7 50 0 0 50", 1.0)
testSF("14 50 50 0 0", 0.0001220703125)
testSF("14 25 25 25 25", 0.008845493197441101)