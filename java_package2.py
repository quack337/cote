import os
import re

for dirpath, dirnames, filenames in os.walk('.'):
  for java in filter(lambda fn : fn.endswith('.java'), filenames):
    filepath = f'{dirpath}/{java}'
    f = open(filepath, encoding='UTF8')
    body = f.read().strip()
    f.close()
    match = re.compile('^package +[^;]+;').match(body);
    package = 'package ' + dirpath.replace('.\\', '').replace('\\', '.') + ';'
    if not match or match.group() != package:
      body = re.sub(r'^package +[^;]+;\n+', '', body)
      f = open(filepath, mode='w', encoding='UTF8')
      f.write(package)
      f.write('\n')
      f.write(body)
      f.close()
