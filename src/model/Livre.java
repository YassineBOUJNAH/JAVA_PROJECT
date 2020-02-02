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
public class Livre extends Document {
    private int pages;
    private int tomes;
    private String type;
    
    public Livre(String isbn,String titre, String[] auteur,String editeur,int edition,int exemplaires,int pages,int tomes,String type){
        super( isbn, titre, auteur, editeur, edition, exemplaires);
        this.pages=pages;
        this.tomes=tomes;
        this.type=type;
    }

    public String toString(){
        return  "Il s'agit d'un livre "+ super.toString()+
                "nombre de pages"+pages+
                "nombre de tomes"+tomes+
                "type du livre: "+type;
    }
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTomes() {
        return tomes;
    }

    public void setTomes(int tomes) {
        this.tomes = tomes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
