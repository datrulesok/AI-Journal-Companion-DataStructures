package org.example.datastructures

class DoublyLinkedList<T> {

    // Inner class representing each node in the list
    private inner class Node(
        var data: T,
        var prev: Node? = null,
        var next: Node? = null
    )

    private var head: Node? = null
    private var tail: Node? = null
    private var current: Node? = null
    private var size = 0

    // Adds an element to the end of the list
    fun addLast(data: T) {

        val newNode = Node(data)

        if (tail == null) {

            head = newNode
            tail = newNode
            current = newNode

        } else {

            tail!!.next = newNode
            newNode.prev = tail
            tail = newNode
        }

        size++
    }

    // Adds an element to the beginning of the list
    fun addFirst(data: T) {

        val newNode = Node(data)

        if (head == null) {

            head = newNode
            tail = newNode
            current = newNode

        } else {

            newNode.next = head
            head!!.prev = newNode
            head = newNode
        }

        size++
    }

    // Inserts an element at the specified index
    fun addAt(index: Int, data: T) {

        if (index <= 0) {
            addFirst(data)
            return
        }

        if (index >= size) {
            addLast(data)
            return
        }

        var temp = head
        var i = 0

        while (temp != null && i < index) {
            temp = temp.next
            i++
        }

        if (temp != null) {

            val newNode = Node(data)
            val previousNode = temp.prev

            newNode.next = temp
            newNode.prev = previousNode

            previousNode?.next = newNode
            temp.prev = newNode

            size++
        }
    }

    // Moves to the next node
    fun moveNext(): T? {
        current = current?.next
        return current?.data
    }

    // Moves to the previous node
    fun movePrevious(): T? {
        current = current?.prev
        return current?.data
    }

    // Returns current value
    fun getCurrent(): T? {
        return current?.data
    }

    // Returns value at index
    fun get(index: Int): T? {

        if (index < 0 || index >= size) {
            return null
        }

        var temp = head
        var i = 0

        while (temp != null && i < index) {
            temp = temp.next
            i++
        }

        return temp?.data
    }

    // Removes value at index
    fun removeAt(index: Int): T? {

        if (index < 0 || index >= size) {
            return null
        }

        var temp = head
        var i = 0

        while (temp != null && i < index) {
            temp = temp.next
            i++
        }

        if (temp != null) {

            if (temp.prev != null) {
                temp.prev!!.next = temp.next
            } else {
                head = temp.next
            }

            if (temp.next != null) {
                temp.next!!.prev = temp.prev
            } else {
                tail = temp.prev
            }

            if (current == temp) {
                current = temp.next ?: temp.prev
            }

            size--

            return temp.data
        }

        return null
    }

    // Removes first matching value
    fun remove(data: T): Boolean {

        var temp = head

        while (temp != null) {

            if (temp.data == data) {

                if (temp.prev != null) {
                    temp.prev!!.next = temp.next
                } else {
                    head = temp.next
                }

                if (temp.next != null) {
                    temp.next!!.prev = temp.prev
                } else {
                    tail = temp.prev
                }

                if (current == temp) {
                    current = temp.next ?: temp.prev
                }

                size--

                return true
            }

            temp = temp.next
        }

        return false
    }

    // Clears the list
    fun clear() {

        head = null
        tail = null
        current = null
        size = 0
    }

    // Number of elements
    fun size(): Int {
        return size
    }

    // Returns true if empty
    fun isEmpty(): Boolean {
        return size == 0
    }

    // Converts list to standard Kotlin List
    fun toList(): List<T> {

        val result = mutableListOf<T>()

        var temp = head

        while (temp != null) {

            result.add(temp.data)

            temp = temp.next
        }

        return result
    }

    // Performs action on every item
    fun forEach(action: (T) -> Unit) {

        var temp = head

        while (temp != null) {

            action(temp.data)

            temp = temp.next
        }
    }

    // Finds first matching object
    fun findFirst(predicate: (T) -> Boolean): T? {

        var temp = head

        while (temp != null) {

            if (predicate(temp.data)) {
                return temp.data
            }

            temp = temp.next
        }

        return null
    }

    // Finds index of matching object
    fun findIndex(predicate: (T) -> Boolean): Int {

        var temp = head
        var index = 0

        while (temp != null) {

            if (predicate(temp.data)) {
                return index
            }

            temp = temp.next
            index++
        }

        return -1
    }

    // Returns current index
    fun getCurrentIndex(): Int {

        var temp = head
        var index = 0

        while (temp != null) {

            if (temp == current) {
                return index
            }

            temp = temp.next
            index++
        }

        return -1
    }

    // Reverses the list
    fun reverse() {

        var temp = head
        var previousNode: Node? = null

        while (temp != null) {

            val next = temp.next

            temp.next = previousNode
            temp.prev = next

            previousNode = temp
            temp = next
        }

        val oldHead = head

        head = tail
        tail = oldHead

        current = head
    }

    // Finds all matching objects
    fun findAll(predicate: (T) -> Boolean): List<T> {

        val results = mutableListOf<T>()

        var temp = head

        while (temp != null) {

            if (predicate(temp.data)) {
                results.add(temp.data)
            }

            temp = temp.next
        }

        return results
    }
}