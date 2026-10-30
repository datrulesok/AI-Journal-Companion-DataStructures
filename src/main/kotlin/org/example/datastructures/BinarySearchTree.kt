package org.example.datastructures

class BinarySearchTree<T : Comparable<T>> {

    private inner class Node(
        var data: T,
        var left: Node? = null,
        var right: Node? = null
    )

    private var root: Node? = null

    private var size = 0

    // Adds an item to the tree
    fun add(data: T) {

        if (root == null) {

            root = Node(data)
            size++

            return
        }

        var current = root

        while (current != null) {

            when {

                data < current.data -> {

                    if (current.left == null) {

                        current.left = Node(data)
                        size++

                        return
                    }

                    current = current.left
                }

                data > current.data -> {

                    if (current.right == null) {

                        current.right = Node(data)
                        size++

                        return
                    }

                    current = current.right
                }

                else -> {
                    // Duplicate values are ignored
                    return
                }
            }
        }
    }

    // Checks whether an item exists
    fun contains(data: T): Boolean {

        return search(data) != null
    }

    // Searches for an item
    fun search(data: T): T? {

        var current = root

        while (current != null) {

            when {

                data < current.data -> {
                    current = current.left
                }

                data > current.data -> {
                    current = current.right
                }

                else -> {
                    return current.data
                }
            }
        }

        return null
    }

    // Returns the smallest value
    fun min(): T? {

        var current = root ?: return null

        while (current.left != null) {
            current = current.left!!
        }

        return current.data
    }

    // Returns the largest value
    fun max(): T? {

        var current = root ?: return null

        while (current.right != null) {
            current = current.right!!
        }

        return current.data
    }

    // Returns items in sorted order
    fun toList(): List<T> {

        val result = mutableListOf<T>()

        inOrder(root, result)

        return result
    }

    private fun inOrder(
        node: Node?,
        result: MutableList<T>
    ) {

        if (node == null) {
            return
        }

        inOrder(node.left, result)

        result.add(node.data)

        inOrder(node.right, result)
    }

    // Pre-order traversal
    fun preOrder(): List<T> {

        val result = mutableListOf<T>()

        preOrder(root, result)

        return result
    }

    private fun preOrder(
        node: Node?,
        result: MutableList<T>
    ) {

        if (node == null) {
            return
        }

        result.add(node.data)

        preOrder(node.left, result)

        preOrder(node.right, result)
    }

    // Post-order traversal
    fun postOrder(): List<T> {

        val result = mutableListOf<T>()

        postOrder(root, result)

        return result
    }

    private fun postOrder(
        node: Node?,
        result: MutableList<T>
    ) {

        if (node == null) {
            return
        }

        postOrder(node.left, result)

        postOrder(node.right, result)

        result.add(node.data)
    }

    // Returns number of items
    fun size(): Int {
        return size
    }

    // Returns true if the tree is empty
    fun isEmpty(): Boolean {
        return size == 0
    }

    // Clears the tree
    fun clear() {

        root = null

        size = 0
    }
}