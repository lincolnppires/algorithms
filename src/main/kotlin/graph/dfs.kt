package graph

// https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/

class GraphDFS(nodeNumber: Int) {
    private val adjacentNodes = Array(nodeNumber) { mutableListOf<Int>() }

    fun addEdge(node: Int, child: Int) {
        adjacentNodes[node].add(child)
    }

    fun bfs(node: Int) {
        val visited = BooleanArray(adjacentNodes.size)
        var node = node

        DFSUtil(node, visited)
    }

    private fun DFSUtil(node: Int, visited: BooleanArray) {
        visited[node] = true
        println("Visiting $node")
        adjacentNodes[node].forEach {
            var next = it
            if (visited[next].not()) {
                DFSUtil(next, visited)
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
    println("DFS")
    var graph = GraphDFS(4)
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 2)
    graph.addEdge(2, 0)
    graph.addEdge(2, 3)
    graph.addEdge(3, 3)
    // graph.printGraph()
    graph.bfs(2)
}
