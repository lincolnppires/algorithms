package graph

import java.util.LinkedList
import java.util.Queue

class Graph(nodeNumber: Int) {
    private val adjacentNodes = Array(nodeNumber - 1) { mutableListOf<Int>() }

    fun addEdge(node: Int, child: Int) {
        adjacentNodes[node - 1].add(child)
    }

    fun bfs(node: Int) {
        var visited = BooleanArray(adjacentNodes.size)
        var queue: Queue<Int> = LinkedList<Int>()
        var node = node

        visited[node - 1] = true
        queue.add(node)

        while (queue.size != 0) {
            node = queue.poll()
            println("Visiting $node ")
            adjacentNodes[node - 1].forEach {
                if (visited[it - 1].not()) {
                    visited[it - 1] = true
                    queue.add(it)
                }
            }
        }
    }
    fun printGraph() {
        for (i in 0 until adjacentNodes.size) {
            var node = i + 1
            print("$node -> ")
            adjacentNodes[i].forEach {
                print(" |$it ")
            }
            println()
        }
    }
}

fun main() {
    println("BFS")
    var graph = Graph(7)
    graph.addEdge(1, 2)
    graph.addEdge(1, 3)
    graph.addEdge(2, 4)
    graph.addEdge(2, 5)
    graph.addEdge(3, 6)
    // graph.printGraph()
    graph.bfs(1)
}
