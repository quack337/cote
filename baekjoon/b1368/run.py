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

testFS("data1", "9")
testFS("data2", "6")

testSS("2\n1 1\n0 2\n2 0", "2")
testSS("2\n1 2\n0 2\n2 0", "3")
testSS("2\n2 2\n0 2\n2 0", "4")
testSS("2\n3 2\n0 2\n2 0", "4")
testSS("3\n3 5 7\n0 4 6\n4 0 5\n6 5 0", "12")
testSS("3\n3 5 7\n0 4 8\n4 0 8\n8 8 0", "14")
testSS("3\n3 5 7\n0 8 8\n8 0 8\n8 8 0", "15")
testSS("4\n2 3 4 2\n0 3 5 4\n3 0 9 3\n5 9 0 3\n4 3 3 0", "10")
testSS("4\n2 2 2 2\n0 1 1 1\n1 0 1 1\n1 1 0 1\n1 1 1 0", "5")
