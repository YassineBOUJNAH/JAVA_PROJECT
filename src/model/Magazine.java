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
public class Magazine extends Document {
    private String periodicite;
    private int mois_ediion;
    private int jour_edition;
    
    Magazine(String isbn,String titre, String[] auteur,String editeur,int edition,int exemplaires,String periodicite,int mois_ediion,int jour_edition){
        super( isbn, titre, auteur, editeur, edition, exemplaires);
        this.periodicite=periodicite;
        this.mois_ediion=mois_ediion;
        this.jour_edition=jour_edition;
    }

    public String toString(){
        return  "Il s'agit d'un Magazine "+ super.toString()+
                "nombre de periodicite"+periodicite+
                "Le moisd'ediion"+mois_ediion+
                "Le jour d'edition: "+jour_edition;
    }
    public String getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(String periodicite) {
        this.periodicite = periodicite;
    }

    public int getMois_ediion() {
        return mois_ediion;
    }

    public void setMois_ediion(int mois_ediion) {
        this.mois_ediion = mois_ediion;
    }

    public int getJour_edition() {
        return jour_edition;
    }

    public void setJour_edition(int jour_edition) {
        this.jour_edition = jour_edition;
    }
    
    
    
}
