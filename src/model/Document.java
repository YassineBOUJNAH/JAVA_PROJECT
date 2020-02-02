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
public abstract class Document {
    
    final private String isbn;
    final private String titre;
    final private String[] auteur;
    final private String editeur;
    final private int edition;
    private int exemplaires;
    private final int numero;
    static private int nb=0;
    
    Document(String isbn,String titre, String[] auteur,String editeur,int edition,int exemplaires  ){
        this.isbn=isbn;
        this.titre=titre;
        this.auteur=auteur;
        this.editeur=editeur;
        this.edition=edition;
        this.exemplaires=exemplaires;
        this.numero=nb++; 
    }
   
    
    public String toString(){
        
        return  "Numero: "+numero+
                "ISBN: "+isbn+
                "Titre: "+titre+
                "Premier auteur: "+auteur[0]+
                "Editeur: "+editeur+
                "Edition: "+edition+
                "Nombre d'exemplaires: "+exemplaires;
                
    }
    
    void incrementer(){
        exemplaires++;
    }
    
    void decrementer(){
        exemplaires--;
    }
    
    protected void finalize(){
        System.out.println("Le document "+this.toString()+"est en cours de destruction");
    }
    public void setExemplaires(int exemplaires) {
        this.exemplaires = exemplaires;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitre() {
        return titre;
    }

    public String[] getAuteur() {
        return auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public int getEdition() {
        return edition;
    }

    public int getExemplaires() {
        return exemplaires;
    }

    public int getNumero() {
        return numero;
    }
    
    
    
}
