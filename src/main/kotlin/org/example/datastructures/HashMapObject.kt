package org.example.datastructures

class HashMapObject<T, K> {

    private val map = mutableMapOf<K, MutableList<T>>()

    // Adds an object using the supplied key
    fun add(key: K, item: T) {

        if (!map.containsKey(key)) {
            map[key] = mutableListOf()
        }

        map[key]?.add(item)
    }

    // Returns true if the key exists
    fun contains(key: K): Boolean {
        return map.containsKey(key)
    }

    // Returns all objects matching the key
    fun search(key: K): List<T> {
        return map[key]?.toList() ?: emptyList()
    }

    // Returns all objects
    fun toList(): List<T> {
        return map.values.flatten()
    }

    // Clears the HashMap
    fun clear() {
        map.clear()
    }

    // Returns number of different keys
    fun size(): Int {
        return map.size
    }

    // Checks whether the HashMap is empty
    fun isEmpty(): Boolean {
        return map.isEmpty()
    }
}