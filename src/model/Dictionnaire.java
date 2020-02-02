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
public class Dictionnaire extends Document {
    
    private String langue; 
    private int tomes;
    
    Dictionnaire(String isbn,String titre, String[] auteur,String editeur,int edition,int exemplaires,String langue,int tomes ){
        super( isbn, titre, auteur, editeur, edition, exemplaires);
        this.langue=langue;
        this.tomes=tomes;
    }
    
    public String toString(){
        return  "Il s'agit d'un dictionnaire "+ super.toString()+
                " La langue: "+langue+
                "Le nombre de tomes: "+tomes;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public int getTomes() {
        return tomes;
    }

    public void setTomes(int tomes) {
        this.tomes = tomes;
    }
    
    
}
