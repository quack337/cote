import os

for dirpath, dirnames, filenames in os.walk('.'):
  for java in filter(lambda fn : fn.endswith('.java'), filenames):
    f = open(f'{dirpath}/{java}', mode='r', encoding='UTF8')
    body = f.read().strip()
    f.close()
    if not body.startswith('package'):
      package = 'package ' + dirpath.replace('.\\', '').replace('\\', '.') + ';\n\n'
      f = open(f'{dirpath}/{java}', mode='w', encoding='UTF8')
      f.write(package)
      f.write(body)
      f.close()
