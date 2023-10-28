package ec.edu.espol.eddproyecto.clases;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<E> implements java.util.List<E> {
    
    Node<E> first;
    
    private class Node<E>{
        E content;
        Node <E> next;
        
        public Node(E e){
            content = e;
            next = null;
        }
    }
    
    public LinkedList(){
        first = null;
    }

    @Override
    public int size() {
        int n = 0;
        Node<E> it=this.first;
        while(it!=null){
            it = it.next;
            n++;
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public String toString(){
        String new_string = "";
        Node<E> tempNode = this.first;
            while(tempNode!=null){
                new_string += (tempNode.content.toString() + " ");
                tempNode = tempNode.next;  
            }
        return new_string; 
    }

    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if (this.first == null) {
            this.first = newNode;
        } else {
            Node<E> tempNode = this.first;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        return true;
    }
    
    public LinkedList<E> joinList(LinkedList<E> linkedList2){
        LinkedList<E> join_LinkedList = new LinkedList<>();
        
        if(this.first!=null){
            Node<E> nodelist1 = this.first;
            while(nodelist1 != null){
                join_LinkedList.add(nodelist1.content);
                nodelist1 = nodelist1.next;
            }   
        }

        if(linkedList2.first != null){
            Node<E> nodelist2 = linkedList2.first;
            while(nodelist2 != null){
                join_LinkedList.add(nodelist2.content);
                nodelist2 = nodelist2.next;
            }
        }
        return join_LinkedList;
    }
    
    public LinkedList<E> reverseList(){
        LinkedList<E> reverse_LinkedList = new LinkedList<>();
        
        if (this.first == null) {
            throw new NullPointerException("Se produjo una NullPointerException");  
        } else {
            Node<E> tempNode = this.first;
            while(tempNode!=null){
                E elemento = tempNode.content;
                Node<E> nuevoNodo = new Node<>(elemento);
                nuevoNodo.next = reverse_LinkedList.first;
                reverse_LinkedList.first = nuevoNodo;
                tempNode = tempNode.next;  
            }
        }
        return reverse_LinkedList;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public Iterator<E> iterator() {
        
        Iterator<E> it = new Iterator<E>() {
            Node<E> cursor = this.first;
            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public E next() {
                E e = cursor.content;
                cursor = cursor.next.next;
                return e;
            }
        };
        
        return it;
        
        
    }
}
