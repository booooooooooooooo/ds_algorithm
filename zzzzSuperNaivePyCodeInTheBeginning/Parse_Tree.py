
class Stack():
  def __init__(self):
    self.items = []

  def push(self, item):
    self.items.append(item)

  def pop(self):
    return self.items.pop()

  def peak(self):
    return self.items[len(self.items) - 1]

  def size(self):
    return len(self.items)

  def isEmpty(self):
    return len(self.items) == 0


class BinaryTree:
  def __init__(self, root):
    self.key = root
    self.left = None
    self.right = None

  def insertLeft(self, newNode):
    t = BinaryTree(newNode)
    t.left = self.left
    self.left = t

  def insertRight(self, newNode):
    t = BinaryTree(newNode)
    t.right = self.right
    self.right = t

  def getRight(self):
    return self.right

  def getLeft(self):
    return self.left

  def setRootVal(self, obj):
    self.key = obj

  def getRootVal(self):
    return self.key


def buildParseTree(fpexp):
  fList = fpexp.split()
  eTree = BinaryTree('')

  pStack = Stack()
  pStack.push(None)

  current = eTree

  # the peak of pStack is parent of current, keep this true before and after each iteration. The parent of eTree should be None. 

  for token in fList:
    if token == '(':
      current.insertLeft('')
      pStack.push(current)
      current = current.getLeft()
    elif token not in ['+','-','*','/',')']:
      current.setRootVal(token)
      current = pStack.pop()

    elif token in ['+','-','*','/']:
      current.setRootVal(token)
      current.insertRight('')
      pStack.push(current)
      current = current.getRight()

    elif token == ')':
      current = pStack.pop()

  return eTree


pt = buildParseTree("( ( 10 + 5 ) * 3 )")

print pt.getRootVal()
print pt.getLeft().getRootVal()
print pt.getRight().getRootVal()
print pt.getLeft().getLeft().getRootVal()
print pt.getLeft().getRight().getRootVal()







