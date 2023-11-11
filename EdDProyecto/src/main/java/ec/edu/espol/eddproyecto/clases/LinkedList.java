package ec.edu.espol.eddproyecto.clases;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<E> implements List<E>, Serializable{

    public static void main(String[] args) {
        /*
        LinkedList<Person> miLinkedList1 = new LinkedList<>();
        LinkedList<String> photos = new LinkedList<>();
        photos.add("photo 1 ");
        photos.add("photo 2 ");
        photos.add("photo 3 ");
        String contactNumber = "+593961443453";
        String workNumber = "+593963931234";
        String email = "jorgeherrerapro2019@gmail.com";
        String workEmail = "joheniet@espol.edu.ec";
        ArrayList<String> address = new ArrayList<>();
        address.add("194 Timberline Dr");
        address.add("Brentwood");
        address.add("NY 11717");
        ArrayList<String> workAddress = new ArrayList<>();
        workAddress.add("1777 Fish Camp Rd");
        workAddress.add("Mariposa");
        workAddress.add("CA 93623");
        Person persona1 = new Person("Peter","Miranda",contactNumber, workNumber, email, workEmail, photos, address, workAddress);
        miLinkedList1.add(persona1);
        System.out.println(miLinkedList1.toString());
        */
    }
    
    Node<E> first;
    Node<E> last;
    private int size;

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    private class Node<E> implements Serializable{
        E content;
        Node<E> next, previus;
        
        public Node(E e){
            content = e;
            next = null;
            previus = null;
        }
    }
    
    public LinkedList(){
        first = null;
        last = null;
        size = 0;
    }
    
    @Override
    public int size() {
        return this.size;
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
        
        Iterator<E> it = new Iterator<E>() {
            Node<E> cursor = first;
            @Override
            public boolean hasNext() {
                System.out.println("hola");
                return cursor.next != first;
            }

            @Override
            public E next() {
                E e = cursor.content;
                cursor = cursor.next;
                return e;
            }
        };
        
        return it;
    }
    
    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if (this.first == null){
            this.first = newNode;
            this.last = newNode;
        } else{
            this.last.next = newNode;
            newNode.previus = this.last;
            this.last = newNode;
        }
        this.last.next = this.first;
        this.first.previus = this.last;
        this.size++;
        return true;
    }
    */
    
    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if (this.first == null) {
            // La lista está vacía
            this.first = newNode;
            this.last = newNode;
            newNode.next = newNode;  // Conexión circular para un único elemento
            newNode.previus = newNode;
        } else {
            // La lista no está vacía
            this.last.next = newNode;
            newNode.previus = this.last;
            this.last = newNode;

            // Conectar el último elemento con el primero para mantener la lista circular
            this.last.next = this.first;
            this.first.previus = this.last;
        }

        this.size++;
        return true;
    }

    @Override
    public String toString(){
        Node<E> it = this.first;
        String str = "";
        while(it!=this.last){
            str += (it.content.toString()+" ");
            it = it.next;
        }
        System.out.println(this.last.content);
        str += (this.last.content+" ");
        return str;
    }

    public LinkedList<E> joinList(LinkedList<E> o){
        LinkedList<E> newList = new LinkedList();
        Node<E> it = this.first;
        Node<E> itNewList = newList.first;
        if (it!=null){
            newList.first = new Node(it.content);
            itNewList = newList.first;
            newList.last = newList.first;
            this.size++;
            while(it.next!=null){
                it = it.next;
                itNewList.next = new Node(it.content);
                itNewList.next.previus = itNewList;
                itNewList = itNewList.next;
                this.last = itNewList;
                this.size++;
            }
        }
        it = o.first;
        if (it!=null){
            if(itNewList==null){
                newList.first = new Node(it.content);
                itNewList = newList.first;
                newList.last = newList.first;
                it=it.next;
                this.size++;
            }
            while(it!=null){
                itNewList.next = new Node(it.content);
                itNewList.next.previus = itNewList;
                itNewList = itNewList.next;
                this.last = itNewList;
                it = it.next;
                this.size++;
            }
        }
        return newList;
    }
    
    public LinkedList<E> reverse(){
        LinkedList<E> linkedListReverse = new LinkedList<>();
        if (this.first == null) {
            return linkedListReverse;
        } else {
            Node<E> tmp = this.last;
            linkedListReverse.first = new Node<>(tmp.content);
            linkedListReverse.last = linkedListReverse.first;
            tmp = tmp.previus;
            while(tmp!=null){
                Node<E> it = new Node<>(tmp.content);
                it.previus = this.last;
                this.last.next = it;
                tmp = tmp.previus;
            }

        }
        linkedListReverse.last.next = this.first;
        linkedListReverse.first.previus = this.last;
        linkedListReverse.size = this.size;
        return linkedListReverse;
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
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException(index);
        }

        Node<E> it;
        if (index <= (this.size - 1) / 2) {
            it = this.first;
            for (int i = 0; i < index; i++) {
                it = it.next;
            }
        } else {
            it = this.last;
            for (int i = this.size - 1; i > index; i--) {
                it = it.previus;
            }
        }

        return it.content;
    }
    
    public E getLast() {
        if (this.isEmpty())
            throw new IllegalStateException();
        return this.last.content;
    }

    @Override
    public void add(int index, E element) {
        if(index<0 || index>=this.size()){
            throw new IndexOutOfBoundsException(index);
        }
        Node<E> it = this.first;
        Node<E> tmp;
        if (index == 0){
            tmp = it;
            this.first = new Node(element);
            it = this.first;
            it.next = tmp;
            return;
        }
        
        if(index<=(this.size-1)/2){
            it = this.first;
            for(int i = 0; i < index-1; i++){
                it = it.next;
            }
            tmp = it.next;
            it.next = new Node(element);
            it.next.previus = it;
            it = it.next;
            it.next = tmp;
            it.next.previus = it;
        } else {
            it = this.last;
            for(int i = this.size - 1; i > index; i--){
                it = it.previus;
            }
            tmp = it.previus;
            it.previus = new Node(element);
            it.previus.next = it;
            it = it.previus;
            it.previus = tmp;
            it.previus.next = it;
        }
        this.last.next = this.first;
        this.first.previus = this.last;
        this.size++;
    }
    

    @Override
    public E remove(int index) {
        if(index<0 || index>=this.size()){
            throw new IndexOutOfBoundsException(index);
        }
        Node<E> it = this.first;
        Node<E> tmp;
        if (index == 0){
            tmp = it;
            this.first = it.next;
            this.size--;
            return tmp.content;
        }
        for(int i = 0; i < index-1; i++){
            it = it.next;
        }
        tmp = it.next;
        //previus
        it.next.previus = it;
        it.next = tmp.next;
        this.size--;
        return tmp.content;
    }
    
    public E removeLast() {
        if (this.isEmpty())
            throw new IllegalStateException();
        Node<E> tmp;
        if (this.size == 1){
            tmp = this.first;
            this.first = null;
            this.last = null;
            size--;
            return tmp.content;
        }
        Node<E> it = this.last;
        tmp = it;
        it = this.last.previus;
        it.next = null;
        size--;
        this.last.next = this.first;
        return tmp.content;
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
    
    
    public E find(Comparator<E> comparator, E elementoBuscado){
        for (E current : this) {
            if (comparator.compare(current,elementoBuscado) == 0) {
                return current;
            }
        }
        return null; 
    }
    public LinkedList<E> findAll(Comparator<E> comparator, E elementoBuscado){
        LinkedList<E> listAll = new LinkedList<>();
        for (E current : this) {
            if (comparator.compare(current,elementoBuscado) == 0) {
                listAll.add(current);
            }
        }
        return listAll; 
    }
    
}

