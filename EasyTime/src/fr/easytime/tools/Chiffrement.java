/******************************************************************************/
/* 
 * Package fr.easytime.tools                                                  
 * Ensenble des outils de l'application.
*/ 
/******************************************************************************/
/* 
 * Création : 6 juin 2015                  
 *  Auteur   : Peter HOWSE                  
 *  But      :   Rassemble tous methode de cryptage (MD5 ...).                            
 *  Classe   : Chiffrement        
 */	
/******************************************************************************/
/* 
 * Modifier le :                             
 * Par :                                   
 * classe :                                                                   
 * Objet : 
*/ 
/******************************************************************************/
package fr.easytime.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/***************************************************************************/
/* 
 * Methode : Chiffrement (constructeur)                         
 * Objet : initialisation de la classe
 * Par : Peter HOWSE                                  
 * In  :  RAS
 * Out :  RAS
*/ 
/***************************************************************************/	

public class Chiffrement {
	
	public static String resultat; //  Résultat du chiffrement.
	public static String erreur; // message d'erreur suite au controle KO.
	
	public Chiffrement() {
		resultat = ""; 
		erreur = "";
	}
	
	/***************************************************************************/
	/* 
	 * Methode : encodeMd5                         
	 * Objet : encodegage alogorythme MD5
	 * Par : Peter HOWSE                                  
	 * In  :  chaine à encoder
	 * Out :  RAS
	*/ 
	/***************************************************************************/	
	  public  String encodeMd5(String password)
	    {
	        byte[] uniqueKey = password.getBytes();
	        byte[] hash      = null;

	        try
	        {
	            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
	        }
	        catch (NoSuchAlgorithmException e)
	        {
	        	erreur = "No MD5 support in this VM.";
	        	throw new Error("No MD5 support in this VM.");
	        }

	        StringBuilder hashString = new StringBuilder();
	        for (int i = 0; i < hash.length; i++)
	        {
	            String hex = Integer.toHexString(hash[i]);
	            if (hex.length() == 1)
	            {
	                hashString.append('0');
	                hashString.append(hex.charAt(hex.length() - 1));
	            }
	            else
	                hashString.append(hex.substring(hex.length() - 2));
	        }
	        resultat = hashString.toString();
	        return hashString.toString();
	    } //encodeMd5 

}
