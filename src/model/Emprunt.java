/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Cours
 */
public class Emprunt {
    int Kindle_number;
    int num_adherent;
    Date date_emprunt;
    private final int numero;
    static private int nb=0;
    
    Emprunt(int Kindle_number, int num_adherent){
        numero=++nb;
        this.Kindle_number=Kindle_number;
        this.num_adherent=num_adherent;
    }
    
    
}
