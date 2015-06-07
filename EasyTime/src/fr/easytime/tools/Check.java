
/******************************************************************************/
/* 
 * Package fr.easytime.tools                                                  
 * Ensenble des outils de l'application.
*/ 
/******************************************************************************/
/* 
 * Création : 23 mai 2015                  
 *  Auteur   : Peter HOWSE                  
 *  But      :   Rassemble tous les controles de l'application.                            
 *  Classe   : Check        
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

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import fr.easytime.tools.Chiffrement;

public class Check {
	
	public static boolean check; //Etat du control.
	private String erreur; // message d'erreur suite au controle KO.

	/***************************************************************************/
	/* 
	 * Methode : Check (constructeur)                         
	 * Objet : initialisation des variables de la classe 
	 * Par : Peter HOWSE                                  
	 * In  :  RAS
	 * Out :  RAS
	*/ 
	/***************************************************************************/	
	
	public Check() {
		check = true; 
		setErreur("");
	}
	
	/***************************************************************************/
	/* 
	 * Methode : CheckMail                         
	 * Objet : Controle d'une chaine mail.
	 * Par : Peter HOWSE                                  
	 * In  : chaine de caractère
	 * Out : bouléen true -> mail correct 
	 *              false -> mail incorrect                                                                   
	 */ 
	/***************************************************************************/

	public boolean CheckMail(String mail) {
		
		// Mail présent ?
		if (mail.length()==0 ) {
			check = false;
			setErreur("Mail absent.");
		}
		
		// Mail au bon fomat
		else if (!isEmailAdress(mail)) {
			check = false;
			setErreur("Mail incorrecte.");
				
		}
     return check;
  } // fin CheckMail
	
	/***************************************************************************/
	/* 
	 * Methode : CheckMdp                         
	 * Objet : Control d'une chaine mot de passe.
	 * Par : Peter HOWSE                                  
	 * In  : chaine de caractère
	 * Out : bouléen true -> mail correct 
	 *              false -> mail incorrect                                                                   
	 */ 
	/***************************************************************************/

	public boolean CheckValidityMdp(String mdpsai, String mdpencode) {
		Chiffrement Md5 = new Chiffrement() ;
		// mode passe présent ?
		if (mdpsai  == "") {
			check = false;
			setErreur("Mot de passe absent.");
		}
		if (Md5.encodeMd5(mdpsai).compareTo(mdpencode) !=0) {
			check = false;
			setErreur("Mot de passe incorrecte.");
		}
     return check;
  } // fin CheckValidityMdp
	
	
	/***************************************************************************/
	/* 
	 * Methode : CheckMdp                         
	 * Objet : Control d'une chaine mot de passe.
	 * Par : Peter HOWSE                                  
	 * In  : chaine de caractère
	 * Out : bouléen true -> mail correct 
	 *              false -> mail incorrect                                                                   
	 */ 
	/***************************************************************************/

	public boolean CheckMdp(String mdpsai1, String mdpsai2) {
		 
		// mode passe présent ?
		if (mdpsai1.length()==0  || mdpsai2.length()==0  ) {
			check = false;
			setErreur("Mot de passe obligatoire.");
		} else if (mdpsai1.compareTo(mdpsai2)!=0) {
			check = false;
			setErreur("Confirmation de mot de passe différente.");
		}
     return check;
  } // fin CheckMail
	
	/***************************************************************************/
	/* 
	 * Methode : isEmailAdress                         
	 * Objet : Control d'une chaine est au format mail.
	 * Par : Peter HOWSE                                  
	 * In  : chaine de caractère
	 * Out : bouléen true -> mail correct 
	 *              false -> mail incorrect                                                                   
	 */ 
	/***************************************************************************/
	
	public static boolean isEmailAdress(String email){
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
		Matcher m = p.matcher(email.toUpperCase(Locale.getDefault()));
		return m.matches();
		}

	public String getErreur() {
		return erreur;
	}

	public void setErreur(String erreur) {
		this.erreur = erreur;
	}
	
	
	
	
} // fin Check

