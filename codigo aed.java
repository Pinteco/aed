/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;

/**
 *
 * @author USER
 */
class PilhaIngenua {
	protected final int MAX = 10000000;
	protected Integer[] pilha;

	PilhaIngenua() { pilha = new Integer[MAX];}

	void add(int a){
            int i;
            for(i=0; pilha[i]!= null; i++);
            pilha[i] = a;
            //System.out.println(pilha[i]);
        }

	int remove(){
            int i;
            for(i=0; pilha[i]!=null;i++);
            //System.out.println(pilha[i-1]);
            int tmp = pilha[i-1];
            pilha[i-1]=null;
            return tmp;
        }
}

class Estrutura{
    protected int value;
    protected Estrutura next;
    
    Estrutura(int v) {value = v;}
}

class Pilha{
    protected Estrutura inicio;
    

void add(int a){
    Estrutura tmp = new Estrutura(a);
    Estrutura aux = inicio;
    
    if(aux==null){
        inicio = tmp;
        return;
    }
    
    inicio = tmp;
    tmp.next = aux;
          
    //System.out.println(inicio.value);
}

int remove(){
    Estrutura aux = inicio;
    int ret;
    
    if(aux == null)
        return -1;
    
    
    //System.out.println(aux.value);
    
    ret = aux.value;
    inicio = aux.next;   

    return ret;   
}

void print(File F) throws IOException{
    Estrutura aux = inicio;
  
    
    FileWriter writer = new FileWriter(F);
    
    if(aux==null){
        System.out.println("Pilha vazia");
        return;
    }
    
    if(aux.next==null){
        //System.out.println(aux.value);
        writer.write(aux.value);
        return;
    }
    
    while(aux.next!=null){
       //System.out.println(aux.value);
        writer.write(aux.value+"\n");
        aux = aux.next;
    }
    
    
    
    
    //System.out.println(aux.value); 
    writer.write(aux.value+"\n");
}
    
}


public class AED {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int count = 0;
        LinkedList<Long> timestamps = new LinkedList<>();
        long timeStart = System.currentTimeMillis();
        int iterator = 1000;
        Pilha x = new Pilha();
        PilhaIngenua y = new PilhaIngenua();
        
        
        while(iterator<=99000){
            LinkedList<Integer> ordem = new LinkedList<>();
        try {
            PrintWriter out = new PrintWriter("output"+iterator+".txt");
            FileReader Reader = new FileReader("tarefas"+iterator+".txt");
            //FileReader Reader = new FileReader("./main/tarefas"+iterator+".txt");
            BufferedReader Input = new BufferedReader(Reader);
            
            
            String linha = Input.readLine();
            
            while(linha!=null){
                if(linha.isEmpty()){
                    //ordem.add(x.remove());                  
                    ordem.add(y.remove());
                    count++;
                }
                else{             
                //x.add(Integer.parseInt(linha));               
                y.add(Integer.parseInt(linha));
                }
                linha = Input.readLine();
                
                int aux = count%100;
                if(count!=0&&aux==0)
                timestamps.add(System.currentTimeMillis()-timeStart);
                
            }
            
            while(!ordem.isEmpty()){
                out.println(ordem.getFirst());
                //System.out.println(ordem.getFirst());
                ordem.removeFirst();
            }
            
            out.flush();
            out.close();
            Reader.close();
            System.out.println("Arquivo output"+iterator+".txt criado");
            
            
            
            //ordem.print(Output);
            
            iterator += 1000;
            
            
        }
        
        
        catch(IOException a){
            System.out.println("Arquivo não encontrado");
            return;
        }
        
        }
        
        long timeEnd = System.currentTimeMillis() - timeStart;
        
        count = 100;
        try{
            PrintWriter out = new PrintWriter("timestamps.txt");
            while(!timestamps.isEmpty()){
                
                out.println(timestamps.getFirst());
                timestamps.removeFirst();
                
                count+=100;
                    
            }
            out.flush();
            out.close();
        }
        catch(IOException a){
        }
        
        System.out.println(timeEnd);
        
    }
    
}
