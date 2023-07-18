import java.util.List;

import org.junit.jupiter.api.Test;

class GraphTester {

    @Test
    void test() {
        DGraph graph = new DGraph(3);

        graph.addEdge(0, 3, 2.0);
        graph.addEdge(1, 2, 1.0);
        graph.addEdge(0, 3, 2.0);
        graph.addEdge(7, 0, 6.0);
        graph.addEdge(1, 2, 1.0);
        graph.addEdge(3, 0, 6.0);
        graph.addEdge(4, 0, 6.0);
        graph.addEdge(5, 0, 6.0);
        graph.addEdge(6, 0, 6.0);

        System.out.println(graph.toDotString());
    }

    @Test
    void testGetWeight() {
        DGraph graph = new DGraph(10);

        graph.addEdge(0, 3, 2.0);
        graph.addEdge(7, 0, 6.0);
        graph.addEdge(1, 2, 1.0);
        graph.addEdge(3, 0, 6.0);
        graph.addEdge(4, 0, 6.0);
        graph.addEdge(5, 0, 6.0);
        graph.addEdge(6, 0, 6.0);


        List<Integer> x = graph.getNeighbors(0);
        System.out.println(x.toString());

        // assertEquals();
    }

}
