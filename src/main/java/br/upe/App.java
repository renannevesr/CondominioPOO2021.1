package br.upe;

import br.upe.dao.MoradorDAO.JPAMoradorDAO;
import br.upe.model.Morador;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Condomínio UPE");
        

        JPAMoradorDAO jpacond1 = new JPAMoradorDAO ();
     
        Morador m1 = new Morador();
        
        System.out.println(jpacond1.listar(m1));
        
    }
    
}
