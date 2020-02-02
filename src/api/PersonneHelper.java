/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Personne;

/**
 *
 * @author boujnah
 */
public class PersonneHelper {
        public static ArrayList<Personne> getPersonne(ResultSet rs) throws SQLException {
        ArrayList<Personne> Personnes = new ArrayList<>();

        while(rs.next()) {

            String cin=rs.getString("cin");
            int emprunts=rs.getInt("emprunts");
            String nom = rs.getString("nom");
            String password = rs.getString("password");
            String prenom = rs.getString("prenom");
            int seuilMax = rs.getInt("seuilMax");
            Personne personne;
            personne = new Personne(cin,nom,prenom,seuilMax,password);
            Personnes.add(personne);
        }
        return Personnes;
    }
    
}
