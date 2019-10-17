class Node(object):
    def __init__(self, elem):
        self.elem = elem
        self.lchild = None
        self.rchild = None


class Tree(object):
    def __init__(self):
        self.root = None

    def add(self, elem):
        node = Node(elem)
        if self.root is None:
            self.root = node
        else:
            queue = list()
            queue.append(self.root)
            while queue:
                curNode = queue.pop(0)
                if curNode.lchild is None:
                    curNode.lchild = node
                    return
                elif curNode.rchild is None:
                    curNode.rchild = node
                    return
                else:
                    queue.append(curNode.lchild)
                    queue.append(curNode.rchild)

    def trave(self):
        if self.root is None:
            return
        queue = list()
        queue.append(self.root)
        while queue:
            curNode = queue.pop(0)
            print(curNode.elem, end='\t')
            if curNode.lchild:
                queue.append(curNode.lchild)
            if curNode.rchild:
                queue.append(curNode.rchild)
        print()

    def preOrder(self, root):
        if root is None:
            return
        else:
            print(root.elem, end='\t')
            self.preOrder(root.lchild)
            self.preOrder(root.rchild)

    def inOrder(self, root):
        if root is None:
            return
        self.inOrder(root.lchild)
        print(root.elem, end='\t')
        self.inOrder(root.rchild)

    def postOrder(self, root):
        if root is None:
            return
        self.postOrder(root.lchild)
        self.postOrder(root.rchild)
        print(root.elem, end='\t')


if __name__ == '__main__':
    tree = Tree()
    tree.add(0)
    tree.add(1)
    tree.add(2)
    tree.add(3)
    tree.add(4)
    tree.add(5)
    tree.add(6)
    tree.add(7)
    tree.add(8)
    tree.add(9)
    tree.trave()
    tree.preOrder(tree.root)
    print()
    tree.inOrder(tree.root)
    print()
    tree.postOrder(tree.root)
