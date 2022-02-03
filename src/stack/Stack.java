/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import listaGenericaArreglos.Lista;

/**
 *
 * @author folke
 */
public class Stack<T> {
    private Lista<T> stack;
    
    public Stack(){
        stack= new Lista();        
    }  
    
    public Stack(int n){
        stack= new Lista(n);        
    }  
     
    public boolean isEmpty(){
        return stack.isEmpty();
    }   
    public boolean push(T e){
        return stack.add(e);
    }
    
    public T pop(){
        return stack.remove();
    }
    
//    public String toString(){
//        return stack.toString();
//    }  
    
    public String toString(){
        Stack<T> aux= new Stack();
        StringBuilder s= new StringBuilder();
        T e;
        while (!this.isEmpty()){
            e=this.pop();
            s.append(e.toString()+"\n");
            aux.push(e);
        }
        //Restaurar el Stack original
        while(!aux.isEmpty()){
            e= aux.pop();
            this.push(e);
        }
        
        return s.toString();
    }
}
