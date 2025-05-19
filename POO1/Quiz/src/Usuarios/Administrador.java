package Usuarios;

import Pergunta.Pergunta;
import Resposta.Resposta;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Administrador extends Usuarios{
    private String id, senha;

    public Administrador(String n, String id, String s){
        super(n);
        this.id = id;
        this.senha = s;
    }
    
    public String getID(){
        return id;
    }
    
    public String getSenha(){
        return senha;
    }
    
    //Mostra o administrador, isto eh, o nome, o id e a senha.
    public String mostraAdm(){
        return getNome()+" "+id+" "+senha;
    }
    
    
    //Escreve no arquivo administradores.txt o nome, o id e a senha do administrador.
    public void salvaAdministrador(){
        try{
            BufferedWriter saida = new BufferedWriter(new FileWriter("administradores.txt", true));
            
            saida.write(mostraAdm());
            saida.newLine();
                
            saida.close();
                
            
        }catch(IOException e){ 
            System.out.println("Erro");
        }
    }
    
    
    //Cria uma nova instacia de Resposta e a retorna.
    public Resposta criarResposta(int rC,String alt1,String alt2,String alt3,String alt4){
        
        Resposta r = new Resposta(rC,alt1,alt2,alt3,alt4);
        
        return r;
    }    
          
    //Cria uma nova instacia de Pergunta e a retorna.
    public Pergunta criarPergunta(String a, String d, String e){
        
        Pergunta per = new Pergunta(a,d,e);
        
        return per;
    }
    
    
}
