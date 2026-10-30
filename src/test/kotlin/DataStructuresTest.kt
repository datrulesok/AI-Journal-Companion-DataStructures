import org.example.datastructures.BinarySearchTree
import org.example.datastructures.DoublyLinkedList
import org.example.datastructures.HashMapObject
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DataStructuresTest {

    @Test
    fun testLinkedList() {

        val list = DoublyLinkedList<String>()

        list.addLast("Apple")
        list.addLast("Banana")
        list.addLast("Cherry")

        assertEquals(
            listOf("Apple", "Banana", "Cherry"),
            list.toList()
        )
    }

    @Test
    fun testHashMap() {

        val map = HashMapObject<String, String>()

        map.add("fruit", "Apple")
        map.add("fruit", "Banana")

        assertTrue(map.contains("fruit"))

        assertEquals(
            listOf("Apple", "Banana"),
            map.search("fruit")
        )
    }

    @Test
    fun testBinaryTree() {

        val tree = BinarySearchTree<Int>()

        tree.add(50)
        tree.add(30)
        tree.add(70)
        tree.add(20)
        tree.add(40)
        tree.add(60)
        tree.add(80)

        assertEquals(
            listOf(20, 30, 40, 50, 60, 70, 80),
            tree.toList()
        )

        assertTrue(tree.contains(60))
    }
}