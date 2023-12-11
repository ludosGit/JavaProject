''' In Python, generators are a way to create iterators in a more concise and memory-efficient manner.
Generators are commonly used in scenarios where you have a large dataset or when you want 
to generate a sequence of values dynamically without precomputing them. 
They provide a convenient and memory-efficient (they don't generate the entire sequence of values at once) 
way to work with sequences in Python.
yield keyword to produce a value and temporarily suspend the function's state.
The next time the generator is called, it resumes execution from where it was suspended.'''

def gen(words):
    for word in words:
      yield word

x = gen(['zozza', 'troia'])
print(next(x))
print(next(x))
y = (x for x in range(5))
print(next(y))
print(next(y))
print(next(y))

def gen1(word):
   yield word
   print('letsssgo')
   yield 5

x = gen1('Friseur')
print(next(x))
print(next(x))
