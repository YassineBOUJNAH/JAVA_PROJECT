package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cours
 */
public class Etudiant extends Personne{
    final private String cne;
    
   public Etudiant(String cin,String nom,String prenom,String matiere,String cne){
       super(cin,nom,prenom,3,"passwd");
       this.cne=cne;
    }

    public String getCne() {
        return cne;
    }
    
    
}
