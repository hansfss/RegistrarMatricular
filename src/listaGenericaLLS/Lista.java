/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaGenericaLLS;

import java.util.Iterator;

/**
 *
 * @author folke
 */
public class Lista<T> implements Iterable<T> {
    private Nodo<T> lista;
    
    public Lista(){
        lista= null;
    }
    
     public Lista(int n){
        lista= null;
    }
     
     
    public boolean add(T e){
        Nodo<T> p;
        p= new Nodo(e);
        p.setLink(lista);
        lista=p;
        return true;
    }
    
    public String toString(){
        StringBuilder s= new StringBuilder();
        Nodo<T> p;
        p= lista;
        while (p!=null){
            s.append(p.toString()+"\n");
            p= p.getLink();
        }
      
        return s.toString();
    }
    
    //Elimina el "primer elemento"
    public T remove(){
        T e= lista.getInfo();
        if (lista!=null){
            lista=lista.getLink();
            return e;
        }
        return null;
    }
    
    public boolean addLast(T e){
        Nodo<T> p;
        Nodo<T> q;
        Nodo<T> t;
        
        p= new Nodo(e);
        
        if(lista==null){
            lista=p;
        }
        else{
            t=lista;
            q=t;
            while (t!=null){
                q=t;
                t=t.getLink();
            }
            
            q.setLink(p);
        }
        return true;
        
    }
    
    public boolean remove(T e){
        Nodo<T> q, t;
        boolean encontrado=false;
        t= lista;
        q=t;
        while (t!=null && !encontrado){
            if(!t.getInfo().equals(e)){
                q=t;
                t=t.getLink();
            }
            else{
                encontrado=true;
                if (q==t){
                    lista= q.getLink();
                }
                else{
                    q.setLink(t.getLink());
                }
            }
            
        }
        return encontrado;
    }
    
    public int total(T e){
        int n=0;
        Nodo<T> p= lista;
        while (p!=null){
            if(p.getInfo().equals(e)){
                n++;
            }
            p= p.getLink();
        }
        
        return n;
    }
    
    public int removeAll(T e){
        int total=0;
        Nodo<T> q, t;

        t= lista;
        q=t;
        while (t!=null){
            if(t.getInfo().equals(e)){
                total++;
                if (q==t){
                    lista= q.getLink();
                    t= lista;
                    q=t;
                }
                else{
                    q.setLink(t.getLink());
                    q=t;
                    t=t.getLink();
                }
            }
            else{
                q=t;
                t=t.getLink();
            }
            
            
        }
        
        return total;
    }
    
    public boolean isEmpty(){
        return lista == null;
    }
    
    public void reset(){
        lista=null;
    }
    
    
    public Iterator<T> iterator(){
        return new MiClase();
    }

    private class MiClase implements Iterator<T>{
        private Nodo<T> actual;
        
        public MiClase(){
            actual= lista;
        }
        public boolean hasNext(){
            return actual!=null;
        }
        public T next(){
            T e= actual.getInfo();
            actual= actual.getLink();
            return e;       
        }
    }   
}
