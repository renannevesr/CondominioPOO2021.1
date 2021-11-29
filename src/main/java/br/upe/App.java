package br.upe;

import java.util.ArrayList;

import br.upe.dao.CondominioDAO.JPACondominioDAO;
import br.upe.model.Condominio;


public class App {
    public static void main(String[] args) {
        System.out.println("Condomínio UPE");
        JPACondominioDAO jpacond1 = new JPACondominioDAO ();
         
    // Condominio c1 = new Condominio (null, "Ultra Gas", "123456789-0001/98","Av. Aracati, 119, Universitario, Caruaru/PE");
     
    // jpacond1.salva(c1);
        System.out.println(jpacond1.lista());
        
    }
    
}
