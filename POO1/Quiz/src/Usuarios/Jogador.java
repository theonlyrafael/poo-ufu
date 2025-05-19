package Usuarios;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class Jogador extends Usuarios implements Comparable<Jogador>{
    private int pontos;
    
    public Jogador(String n){
        super(n);
        this.pontos = 0;

    }
    
    public Jogador(String n, int p){
        super(n);
        this.pontos = p;
    }
    
    
    public int getPontos(){
        return pontos;
    }
    
    //Atualiza os pontos do jogador de acordo com o valor passado como parametro.
    public void atuPontos(int p){
        pontos = p;
    }
    
    //Mostra o jogador, isto eh, o nome a os pontos dele
    public String mostrarJogador(){
        return "NOME: "+getNome()+" PONTUACAO: "+pontos;
    }

    
    //Escreve no arquivo jogadores.txt o nome e os pontos de um jogador.
    public void salvaJogador()
    {
        try{
            BufferedWriter saida = new BufferedWriter(new FileWriter("jogadores.txt", true));
            
            saida.write(getNome()+"#");
            saida.write(pontos+"#");
            
            
            saida.newLine();  
            saida.close();
  
        }catch(IOException e){ 
            e.printStackTrace();
        }
    }
    
    
    //Compara os pontos dos jogadores em ordem decrescente para ordenar dessa forma na hora do verRanking().
    @Override
     public int compareTo(Jogador outroJogador) {
       
        return Integer.compare(outroJogador.pontos, this.pontos);
    }
    
    
}
