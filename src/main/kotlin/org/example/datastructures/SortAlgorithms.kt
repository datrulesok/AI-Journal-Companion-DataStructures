package org.example.datastructures

object SortAlgorithms {

    fun <T> bubbleSort(
        items: List<T>,
        comparator: (T, T) -> Int
    ): List<T> {

        val result = items.toMutableList()

        for (end in result.lastIndex downTo 1) {

            var swapped = false

            for (i in 0 until end) {

                if (comparator(result[i], result[i + 1]) > 0) {

                    val temp = result[i]
                    result[i] = result[i + 1]
                    result[i + 1] = temp

                    swapped = true
                }
            }

            if (!swapped) {
                break
            }
        }

        return result
    }

    fun <T> insertionSort(
        items: List<T>,
        comparator: (T, T) -> Int
    ): List<T> {

        val result = items.toMutableList()

        for (i in 1 until result.size) {

            val current = result[i]
            var j = i - 1

            while (
                j >= 0 &&
                comparator(result[j], current) > 0
            ) {

                result[j + 1] = result[j]

                j--
            }

            result[j + 1] = current
        }

        return result
    }

    fun <T> selectionSort(
        items: List<T>,
        comparator: (T, T) -> Int
    ): List<T> {

        val result = items.toMutableList()

        for (i in 0 until result.lastIndex) {

            var smallest = i

            for (j in (i + 1)..result.lastIndex) {

                if (
                    comparator(
                        result[j],
                        result[smallest]
                    ) < 0
                ) {

                    smallest = j
                }
            }

            if (smallest != i) {

                val temp = result[i]

                result[i] = result[smallest]
                result[smallest] = temp
            }
        }

        return result
    }
}