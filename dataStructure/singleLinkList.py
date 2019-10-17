class Node(object):
    def __init__(self, elem):
        self.elem = elem
        self.next = None


class SingleLinkList(object):
    def __init__(self, node=None):
        if node is not None:
            self.__headNode = Node(node)
        else:
            self.__headNode = None

    def is_empty(self):
        return self.__headNode is None

    def length(self):
        count = 0
        curNode = self.__headNode
        while curNode is not None:
            count += 1
            curNode = curNode.next
        return count

    def trave(self):
        curNode = self.__headNode
        while curNode is not None:
            print(curNode.elem, end='\t')
            curNode = curNode.next
        print()

    def search(self, elem):
        curNode = self.__headNode
        while curNode is not None:
            if curNode.elem == elem:
                return True
            curNode = curNode.next
        return False

    def add(self, item):
        node = Node(item)
        node.next = self.__headNode
        self.__headNode = node

    def append(self, item):
        node = Node(item)
        if self.is_empty():
            self.__headNode = node
        else:
            curNode = self.__headNode
            while curNode.next is not None:
                curNode = curNode.next
            curNode.next = node

    def insert(self, pos, item):
        if pos <= 0:
            self.add(item)
        elif pos > self.length() - 1:
            self.append(item)
        else:
            node = Node(item)
            preNode = self.__headNode
            count = 0
            while count < (pos - 1):
                count += 1
                preNode = preNode.next
            node.next = preNode.next
            preNode.next = node

    def remove(self, item):
        curNode = self.__headNode
        preNode = None
        while curNode is not None:
            if curNode.elem == item:
                if preNode is None:
                    self.__headNode = curNode.next
                else:
                    preNode.next = curNode.next
                break
            else:
                preNode = curNode
                curNode = curNode.next


if __name__ == '__main__':
    single_link_list = SingleLinkList(20)
    print(single_link_list.is_empty())
    print(single_link_list.length())