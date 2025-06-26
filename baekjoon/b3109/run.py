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

testFS("data1", "2")
testFS("data2", "5")
testFS("data3", "4")

testSS("""2 2
..
..
""", "2")

testSS("""3 3
...
...
...
""", "3")

testSS("""3 3
.x.
...
...
""", "2")

testSS("""3 3
.x.
.x.
...
""", "1")

testSS("""3 3
.x.
.x.
.x.
""", "0")

testSS("""4 4
....
....
....
....
""", "4")

testSS("""4 4
.x..
..x.
.x..
..x.
""", "2")

testSS("""5 5
.x...
..x..
...x.
..x..
.x...
""", "3")

testSS("""5 5
.x...
..x..
.x.x.
..x..
.x...
""", "2")

testSS("""5 5
.x...
.x...
.x...
..x..
..x..
""", "1")

testSS("""5 5
.x...
.x...
.xx..
..x..
..x..
""", "0")


testSS("""5 5
.....
.....
.....
.....
.....
""", "5")

testSS("""5 5
.....
.....
..x..
.....
.....
""", "4")

testSS("""5 7
.....x.
....x..
...x...
..x....
.x.....
""", "4")

