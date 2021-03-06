import api.DbConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import static java.lang.Math.random;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Personne;
import model.Document;
import java.util.LinkedList;
import java.util.Random;
import model.Emprunt;
import model.Etudiant;
import model.Livre;
import model.Professeur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cours
 */
public class Bibliotheque implements Serializable{
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    LinkedList<Document> documents;
    LinkedList<Personne> emprunteurs;
    LinkedList<Emprunt> emprunts;
    
    
    Bibliotheque(){
        documents=new LinkedList<Document>();
        emprunteurs=new  LinkedList<Personne>();
        emprunts=new  LinkedList<Emprunt>();
    }
    public String toString(){
        String description="";
        for(Emprunt e:emprunts ){
            description= description+e.toString()+"\n";  
        }
        return description;
    }
    LinkedList<Document> getDocumentByEditeur( String editeur){
         LinkedList<Document> documentsByEditeur=new LinkedList<Document>();
         for(Document d:documents ){
            if(d.getEditeur().equals(editeur)){
                documentsByEditeur.add(d);
            }
        }
         return documentsByEditeur;
       
   } 
    Document getDocumentByISBN( String isbn){
        
         for(Document d:documents ){
            if(d.getIsbn().equals(isbn)){
                return d;
            }
        }
         return null;
   }
    LinkedList<Document> getDocumentByAuteur( String auteur){
         LinkedList<Document> documentsByAuteur=new LinkedList<Document>();
         for(Document d:documents ){
            for (int i=0;i<d.getAuteur().length;i++)
                if (d.getAuteur()[i].equals(auteur)){
                      documentsByAuteur.add(d);
            }
        }
         return documentsByAuteur;
       
   }
    LinkedList<Document> getDocumentsByTitre(String titre){
    LinkedList<Document> documentsByTitre=new LinkedList<Document>();
     for(Document d:documents ){
            if(d.getTitre().equals(titre)){
                 documentsByTitre.add(d);
            }
            
}
     return documentsByTitre; 
}
    Etudiant getEtudiantByCne(String cne){
    for(Personne p:emprunteurs ){
            if( (p instanceof Etudiant) && ((Etudiant)p).getCne().equals(cne)){
                return (Etudiant)p;
            }
            }
    return null;
}
    Professeur getProfesseurByCin(String cin){
    for(Personne d:emprunteurs ){
            if( (d instanceof Professeur) && ((Professeur)d).getCin().equals(cin)){
                return (Professeur)d;
            }
            }
    return null;
}
    void SupprimerDocument(String titre){
    
    LinkedList<Document> liste=getDocumentsByTitre(titre);
    documents.removeAll(liste);
}
    void SupprimerEtudiant(String cne){
    emprunteurs.remove(getEtudiantByCne(cne));
}
    void SupprimerProfesseur(String cin){
    emprunteurs.remove(getProfesseurByCin(cin));
    
}
    void AjouterDocument(Document d){
    documents.add(d);
}
    void AjouterAdherent(Personne a){
    emprunteurs.add(a);
}
    boolean inscription(){
        //demander les informations sur l'adherent
        return true;
    }
    private String password(){
        char[] alpha={'A','B','C','D','E'};
        char[] num={'0','1','2','3','4'};
        char[] spe={'{','}'};
        String pass="";
        
        Random r =new Random();
        for(int i=0;i<5;i++){
            pass=pass+alpha[r.nextInt(alpha.length)];
          
        }
          for(int i=0;i<3;i++){
            pass=pass+alpha[r.nextInt(num.length)];
          
        }
        pass=pass+spe[r.nextInt(num.length)];
        return pass;
    }
    boolean  connexion(String login, String password ,String type) throws SQLException{
        
        /*  con = DbConnection.getConnection();

         String sql = "SELECT * FROM personne Where cin = ? and password = ?";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                  System.out.println("failed");
                  return false;
                } else {
                  System.out.println("succesfull");
                  return true ;
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        return true; */  
          if (type.equalsIgnoreCase("etudiant")){
         Etudiant e = null;
        for(Personne p : this.emprunteurs){
            if(p.getClass().getName().equals("model.Etudiant")) {
                e=(Etudiant) p;
                if(e.getCne().equals(login) && e.getPassword().equals(password))
                    return true;
            }
                    
        }
      }
      if (type.equalsIgnoreCase("professeur")){
         Professeur e = null;
        for(Personne p : this.emprunteurs){
         
            if(p.getClass().getName().equals("model.Professeur")) {
                e=(Professeur) p;
                if(e.getCin().equals(login) && e.getPassword().equals(password))
                    return true;
            }
                    
        }
      }
        return false;
         
            
    }

   
    public static void main(String[] args) throws IOException, SQLException {
       
       Bibliotheque b = new Bibliotheque();
       String[] auteur={"auteur"}; 
       //First Document
       Document d1= new Livre("111","java",auteur,"editeur",2019,3,300,4,"science");
       d1.setPdf("http://dotprojectmiola.rf.gd/pdf");
       //Second Document   
       Document d2 = new Livre("222","java2",auteur,"talhi",2019,3,300,4,"science");
       d2.setPdf("https://pdfhost.io/v/HoJS6rrF_CH_1.pdf"); 
       Document d3 = new Livre("333","java2",auteur,"talhi",2019,3,300,4,"science");   
       d3.setPdf("https://pdfhost.io/v/HoJS6rrF_CH_1.pdf");  
       
       
       
       b.AjouterDocument(d1); 
       b.AjouterDocument(d2); 
       b.AjouterDocument(d3);
       
       Personne p=new Professeur("1111","nom","prenom","matiere","123456");
       b.AjouterAdherent(p);
        Etudiant p2=new Etudiant("555","Boujnah","yassine","matier","555");
      b.AjouterAdherent(p2);
        int port=8889;
        ServerSocket sersoc = new ServerSocket (port) ;
        while (true)
        {   
            System.out.println(1);
            Socket soc = sersoc.accept();
            System.out.println("2" + soc);
            InputStream flux1 = soc.getInputStream ();
            System.out.println("3" + flux1);
            BufferedReader entree = new BufferedReader (new InputStreamReader (flux1)) ; 
            System.out.println("4"+entree );
          OutputStream flux2 = soc.getOutputStream() ;
           OutputStreamWriter sortie = new OutputStreamWriter (flux2) ;
           ObjectOutputStream sortieObject=new ObjectOutputStream(flux2);
                String type = entree.readLine() ;
            System.out.println("type "+type+"recu");
            String login = entree.readLine() ;
            System.out.println("login "+login+"recu");
            String pass = entree.readLine() ;
            System.out.println("password "+pass+"recu");
            if(b.connexion(login,pass,type)){
                sortie.write("ok\n");
                
                sortie.flush();
                while(true){
                String choix=entree.readLine();
                if(choix.equals("isbn")){
                    String isbn=entree.readLine();
                    System.out.println(isbn);
                    Document doc= b.getDocumentByISBN(isbn);
                    sortieObject.writeObject(doc);
       
                    sortieObject.flush();
                }
                else if(choix.equals("titre")){ 
                    
                    String titre = entree.readLine(); 
                    System.out.print(titre);    
                    LinkedList<Document> doc = b.getDocumentsByTitre(titre);  
                    sortieObject.writeObject(doc);   
                    sortieObject.flush();
                }
                 else if(choix.equals("editeur")){ 
                     
                    String editeur=entree.readLine(); 
                    System.out.print(editeur);
                    LinkedList<Document> docs=b.getDocumentByEditeur(editeur);
                    sortieObject.writeObject(docs); 
                    sortieObject.flush();
                    
                    
                }
                 else if(choix.equals("auteur")){
                    String isbn=entree.readLine();
                    LinkedList<Document> docs=b.getDocumentByAuteur(isbn);
                    sortieObject.writeObject(docs);
                }
                }
            }
       }
}
}