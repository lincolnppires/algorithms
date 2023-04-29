package tree

// https://www.geeksforgeeks.org/introduction-to-binary-search-tree-data-structure-and-algorithm-tutorials/
data class Node(val key: Int, var left: Node?, var right: Node?)

class BinarySearchTree() {

    var root: Node? = null

    constructor(key: Int) : this() {
        root = Node(key, null, null)
    }

    fun newNode(key: Int): Node {
        return Node(key, null, null)
    }

    fun insert(node: Node?, key: Int): Node {
        if (node == null) {
            return newNode(key)
        }

        if (key < node.key) {
            node.left = insert(node.left, key)
        } else if (key > node.key) {
            node.right = insert(node.right, key)
        }

        return node
    }

    fun inorder(root: Node?) {
        if (root != null) {
            inorder(root.left)
            print(" ${root.key}")
            inorder(root.right)
        }
    }
}

fun main() {
    var bst = BinarySearchTree()

    var root: Node? = null

    root = bst.insert(root, 50)
    root = bst.insert(root, 30)
    root = bst.insert(root, 20)
    root = bst.insert(root, 40)
    root = bst.insert(root, 70)
    root = bst.insert(root, 60)
    root = bst.insert(root, 80)

    bst.inorder(root)
}
