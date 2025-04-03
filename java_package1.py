import os
import re

for dirpath, dirnames, filenames in os.walk('.'):
  for java in filter(lambda fn : fn.endswith('.java'), filenames):
    filepath = f'{dirpath}/{java}'
    f = open(filepath, encoding='UTF8')
    body = f.read().strip()
    f.close()
    if not body.startswith('package'):
      print(filepath)
      package = 'package ' + dirpath.replace('.\\', '').replace('\\', '.') + ';\n\n'
      f = open(filepath, mode='w', encoding='UTF8')
      f.write(package)
      f.write(body)
      f.close()
