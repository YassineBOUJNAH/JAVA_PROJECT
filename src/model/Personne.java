package model;

public class  Personne {
    private final String cin;
    private final String nom;
    private final String prenom;
    private String password;
    final private int seuilMax;
    private int emprunts=0;
    
    
    public Personne(String cin,String nom,String prenom,int seuilMax, String password){
        this.cin=cin;
        this.nom=nom;
        this.prenom=prenom;
        this.seuilMax=1;
        this.password=password;
    }
    
    public String toString(){
        return "cin: "+cin+
                "nom: "+nom+
                "prenom"+prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    public int getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(int emprunts) {
        this.emprunts = emprunts;
    }

    public String getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    
    
}
