/**
 * 
 */
package towerofhanoi;

import stack.StackInterface;
import java.util.EmptyStackException;
//Virginia Tech Honor Code Pledge:
//
//Project 3
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I
//accept the actions of those who do.
//-- linda (lindahlee)

/**
* this is the LinkedStack class
* 
* @author linda
* @version 2024.03.01
* @param <T>
*/
public class LinkedStack<T> implements StackInterface<T> {

    private int size;
    private Node<T> topNode;

    /**
     * linked stack constructor
     */
    public LinkedStack() {
        size = 0;
        topNode = null;
    }

    /**
     * this is the clear()
     */
    @Override
    public void clear() {
        topNode = null;
        size = 0;
    }

    /**
     * this is the isEmpty()
     * @return size to 0 
     */
    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    /**
     * this is the peek()
     * @return top nodes data
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();

    }

    /**
     * this is the pop()
     * @return data from top
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node<T> top = topNode;
        topNode = topNode.next;
        size--;
        return top.getData();

    }

    /**
     * this is the push()
     * @param anEntry is T
     */
    @Override
    public void push(T anEntry) {
        Node<T> node = new Node<T>(anEntry);
        node.setNextNode(topNode);
        topNode = node;
        size++;

    }


    /**
     * this is the size()
     * @return size 
     */
    public int size() {
        return size;
    }


    /**
     * this is the toString()
     * @return result
     */
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("[");
        if (isEmpty())
        {
            build.append("]");
            return build.toString();
        }
        Node nodeTemp = topNode;
        while (nodeTemp != null)
        {
            build.append(nodeTemp.getData());
            if (nodeTemp.getNextNode() != null)
            {
                build.append(", ");
            }
            nodeTemp = nodeTemp.getNextNode();
        }
        build.append("]");
        return build.toString();
        
    }

    /**
     * this is the Node<T> class within
     * the main method
     */
    private class Node<T>
    {
        private T data;
        private Node<T> next;

        /**
         * this is the constructor
         * 
         * @param entry is T
         * @param node is Node<T>
         */
     
        public Node(T data) {
            this.data = data;
        }


        public void setNextNode(Node<T> node) {
            this.next = node;
        }
        
        public Node getNextNode()
        {
            return next;
        }



        public T getData() {
            return data;
        }

    }
}
