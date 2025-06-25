import subprocess

#command = "node sol1.js"
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
    print(tag, False)
    print(inputString)
    print(outputString)
    print(result)
    exit()

testFS("data1", "1 2")

testSS("1 0", "1")
testSS("1 1\n1 1", "1")
testSS("2 0", "1 2")
testSS("2 1\n1 2", "2")
testSS("2 2\n1 1\n2 2", "1 2")
testSS("2 2\n1 2\n1 1", "2")
testSS("2 2\n1 2\n2 1", "1 2")
testSS("2 3\n1 2\n2 1\n1 1", "1 2")
testSS("2 4\n1 2\n2 1\n1 1\n2 2", "1 2")
testSS("3 0", "1 2 3")
testSS("3 1\n1 1", "1 2 3")
testSS("3 1\n1 2", "2")
testSS("3 2\n1 1\n2 2", "1 2 3")
testSS("3 2\n1 2\n1 3", "2 3")
testSS("3 2\n1 2\n3 1", "2")
testSS("3 3\n1 1\n2 2\n3 3", "1 2 3")
testSS("3 3\n1 2\n2 3\n3 1", "1 2 3")
testSS("3 3\n1 2\n2 1\n3 3", "1 2")
testSS("3 3\n1 2\n2 1\n1 3", "3")
testSS("3 3\n1 2\n2 1\n3 1", "1 2")
testSS("4 0", "1 2 3 4")
testSS("4 1\n1 1", "1 2 3 4")
testSS("4 1\n1 2", "2")
testSS("4 2\n1 2\n3 4", "2 4")
testSS("4 2\n1 2\n2 3", "3")
testSS("4 3\n1 2\n2 3\n3 1", "1 2 3")
testSS("4 4\n1 2\n2 3\n3 1\n3 4", "4")
testSS("4 4\n1 2\n2 3\n3 4\n4 1", "1 2 3 4")
testSS("4 5\n1 2\n2 3\n3 4\n4 1\n4 2", "1 2 3 4")
testSS("4 5\n1 2\n2 4\n4 1\n3 2\n3 4", "1 2 4")
testSS("4 3\n1 2\n3 2\n2 4", "4")
testSS("4 3\n1 2\n3 2\n4 2", "2")
testSS("4 4\n1 2\n2 1\n3 1\n4 2", "1 2")
testSS("4 4\n1 2\n2 1\n1 3\n2 4", "3 4")
testSS("4 4\n1 2\n2 1\n1 3\n3 4", "4")
testSS("4 4\n1 2\n2 1\n3 1\n4 3", "1 2")
testSS("4 4\n1 2\n2 1\n3 4\n4 3", "1 2 3 4")

testSS("5 5\n3 1\n4 3\n5 3\n5 4\n2 5", "1")
testSS("7 7\n3 1\n4 3\n5 3\n5 4\n2 5\n3 6\n6 7", "7")
