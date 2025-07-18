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

testFS("data1", "4")

testSS("1 1 1\n.", "1")
testSS("1 1 2\n.", "0")
testSS("1 2 2\n..", "1")
testSS("1 2 3\n..", "0")
testSS("1 3 3\n...", "1")
testSS("1 3 2\n...", "0")
testSS("1 3 4\n...", "0")
testSS("1 3 3\n.T.", "0")
testSS("""2 2 3
..
..
""", "2")

testSS("""2 2 3
..
.T
""", "1")

testSS("""2 2 3
T.
..
""", "1")

testSS("""3 3 5
...
...
...
""", "6")

testSS("""3 3 5
...
.T.
...
""", "2")

testSS("""3 3 5
...
..T
...
""", "3")

testSS("""3 3 7
...
...
...
""", "4")
