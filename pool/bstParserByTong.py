
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
  parent = eTree
  current = eTree
  

  for token in fList:
    if token == '(':
      current.insertLeft('')
      parent = current
      current = current.getLeft()
    elif token not in ['+','-','*','/',')']:
      current.setRootVal(token)
      current = parent

    elif token in ['+','-','*','/']:
      current.setRootVal(token)
      current.insertRight('')
      parent = current
      current = current.getRight()

    elif token == ')':
      current = parent

  return eTree


pt = buildParseTree("( ( 10 + 5 ) * 3 )")

print pt.getRootVal()
print pt.getLeft().getRootVal()
print pt.getRight().getRootVal()
print pt.getRight().getLeft()
print pt.getRight().getRight()







