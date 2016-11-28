class BinHeap:
  def __init__(self):
    self.heapList = [0]
    self.currentSize = 0

  def percUp(self, i):
    while i/2 > 0:
      if self.heapList[i] < self.heapList[i/2]:
        tmp = self.heapList[i/2]
        self.heapList[i/2] = self.heapList[i]
        self.heapList[i] = tmp
      i = i / 2

  def insert(self,k):
    self.heapList.append(k)
    self.currentSize = self.currentSize + 1
    self.percUp(self.currentSize)

  def percDown(self, i):
    while i*2 <= self.currentSize:
      mc = self.minChild(i)
      if self.heapList[i] > self.heapList[mc]:
        tmp = self.heapList[i]
        self.heapList[i] = self.heapList[mc]
        self.heapList[mc] = tmp
      i = mc

  def minChild(self, i):
    if i*2 + 1 > self.currentSize:
      return i*2
    else:
      if self.heapList[i*2] < self.heapList[i*2+1]:
        return i*2
      else:
        return i*2 + 1

  def delMin(self):
    retval = self.heapList[1]
    self.heapList[1] = self.heapList[self.currentSize]
    self.currentSize = self.currentSize - 1
    self.heapList.pop()
    self.percDown(1)
    return retval

  def buildHeap(self, alist):
    i = len(alist) // 2
    self.currentSize = len(alist)
    self.heapList = [0] + alist[:]
    while (i > 0):
      self.percDown(i)
      i = i - 1
      
  def drawHeap(self):
    h = int(math.log(len(self.heapList))/math.log(2)) + 1
    pre = 2 ** (h - 1) - 1
    mid = 2 ** h - 1
    for i in range(0, len(self.heapList)):
      if math.log(i+1)/math.log(2) in range(0, h):
        sys.stdout.write(' ' * pre)
        pre = (pre + 1) / 2  - 1
      else:
        sys.stdout.write(' ' * mid)

      sys.stdout.write('%4d' % self.heapList[i])
      
      if math.log(i+2)/math.log(2) in range(1, h+1):
        mid = (mid + 1) / 2 - 1
        sys.stdout.write('\n')
    print



myBinHeap = BinHeap()
myBinHeap.buildHeap([1,2,39,3,4,5,33,6,7,821,8,9])
print myBinHeap.heapList

myBinHeap.insert(10)
print myBinHeap.heapList

myBinHeap.delMin()
print myBinHeap.heapList

