package org.example.datastructures

class BinaryTreeObject<T, K : Comparable<K>> {

    private inner class Node(
        val key: K,
        val items: MutableList<T> = mutableListOf(),
        var left: Node? = null,
        var right: Node? = null
    )

    private var root: Node? = null

    // Adds an object using the supplied key
    fun add(key: K, item: T) {
        root = insert(root, key, item)
    }

    // Returns all objects matching the key
    fun search(key: K): List<T> {

        var current = root

        while (current != null) {

            val comparison = key.compareTo(current.key)

            current = when {

                comparison == 0 -> {
                    return current.items.toList()
                }

                comparison < 0 -> {
                    current.left
                }

                else -> {
                    current.right
                }
            }
        }

        return emptyList()
    }

    // Returns true if the key exists
    fun contains(key: K): Boolean {

        var current = root

        while (current != null) {

            val comparison = key.compareTo(current.key)

            when {

                comparison == 0 -> {
                    return true
                }

                comparison < 0 -> {
                    current = current.left
                }

                else -> {
                    current = current.right
                }
            }
        }

        return false
    }

    // Returns all objects
    fun toList(): List<T> {

        val result = mutableListOf<T>()

        inOrder(root, result)

        return result
    }

    // Clears the tree
    fun clear() {
        root = null
    }

    // Checks whether the tree is empty
    fun isEmpty(): Boolean {
        return root == null
    }

    private fun insert(
        node: Node?,
        key: K,
        item: T
    ): Node {

        if (node == null) {

            return Node(
                key = key,
                items = mutableListOf(item)
            )
        }

        val comparison = key.compareTo(node.key)

        when {

            comparison == 0 -> {
                node.items.add(item)
            }

            comparison < 0 -> {
                node.left = insert(
                    node.left,
                    key,
                    item
                )
            }

            else -> {
                node.right = insert(
                    node.right,
                    key,
                    item
                )
            }
        }

        return node
    }

    private fun inOrder(
        node: Node?,
        result: MutableList<T>
    ) {

        if (node == null) {
            return
        }

        inOrder(node.left, result)

        result.addAll(node.items)

        inOrder(node.right, result)
    }
}