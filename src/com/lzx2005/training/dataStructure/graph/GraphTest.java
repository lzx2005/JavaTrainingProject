package com.lzx2005.training.dataStructure.graph;

import com.lzx2005.training.dataStructure.graph.impl.AdjacencyListGraph;
import com.lzx2005.training.dataStructure.graph.impl.AdjacencyMatrixGraph;

import java.util.Iterator;

/**
 * Created by hzlizx on 2019/3/21
 */
public class GraphTest {

    public static void main(String[] args) {
        System.out.println("adjacencyMatrixGraph : ");
        AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph(10, true);
        doTest(adjacencyMatrixGraph);
        System.out.println();
        System.out.println("adjacencyListGraph : ");
        AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(10, true);
        doTest(adjacencyListGraph);
    }

    private static void doTest(Graph graph) {
        graph.connect(1, 2);
        graph.connect(2, 3);
        graph.connect(3, 4);
        graph.connect(1, 2);
        graph.connect(6, 7);
        graph.print();

        System.out.println("迭代器遍历:");
        Iterator iterator = graph.iterator(1);
        iterator.forEachRemaining(a -> {
            System.out.print(a + "\t");
        });
    }
}
