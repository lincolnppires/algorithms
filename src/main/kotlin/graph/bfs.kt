package graph

import java.util.LinkedList
import java.util.Queue

//https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

class Graph(nodeNumber: Int) {
    private val adjacentNodes = Array(nodeNumber) { mutableListOf<Int>() }

    fun addEdge(node: Int, child: Int) {
        adjacentNodes[node].add(child)
    }

    fun bfs(node: Int) {
        var visited = BooleanArray(adjacentNodes.size)
        var queue: Queue<Int> = LinkedList<Int>()
        var node = node

        visited[node] = true
        queue.add(node)

        while (queue.size != 0) {
            node = queue.poll()
            println("Visiting $node ")
            adjacentNodes[node].forEach {
                if (visited[it].not()) {
                    visited[it] = true
                    queue.add(it)
                }
            }
        }
    }
    fun printGraph() {
        for (i in 0 until adjacentNodes.size) {
            var node = i
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
    var graph = Graph(4)
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 2)
    graph.addEdge(2, 0)
    graph.addEdge(2, 3)
    graph.addEdge(3, 3)
    // graph.printGraph()
    graph.bfs(2)
}
