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
public class Professeur extends Personne {
    private String matiere;
    
    public Professeur(String cin,String nom,String prenom,String matiere,String password){
       super(cin,nom,prenom,5,password);
       this.matiere=matiere;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    
    
}
