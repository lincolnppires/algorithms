package tree

// https://www.geeksforgeeks.org/introduction-to-binary-search-tree-data-structure-and-algorithm-tutorials/
data class Node(var key: Int, var left: Node?, var right: Node?)

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

    // function that return the node with minimum key value found in that tree
    fun minValueNode(node: Node): Node {
        var current = node
        while (current != null && current.left != null) {
            current = current.left!!
        }
        return current
    }

    // function that deletes the key and returns the new root
    fun deleteNode(root: Node?, key: Int): Node? {
        // base case
        if (root == null) {
            return root
        }

        if (key < root.key) {
            root.left = deleteNode(root.left, key)
        } else if (key > root.key) {
            root.right = deleteNode(root.right, key)
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right
            } else if (root.right == null) {
                return root.left
            }

            // node with two children
            // get the inorder successor (smallest in the right subtree
            var temp = minValueNode(root.right!!)
            root.key = temp.key

            root.right = deleteNode(root.right, temp.key)
        }

        return root
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
    bst.insert(root, 30)
    bst.insert(root, 20)
    bst.insert(root, 40)
    bst.insert(root, 70)
    bst.insert(root, 60)
    bst.insert(root, 80)

    bst.inorder(root)
    println()

    bst.deleteNode(root, 60)
    bst.inorder(root)
    println("\nend")
}
