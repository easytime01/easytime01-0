
/******************************************************************************/
/* 
 * Package fr.easytime.tools                                                  
 * Ensenble des outils de l'application.
*/ 
/******************************************************************************/
/* 
 * Cr�ation : 23 mai 2015                  
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

public class Check {
	
	public static boolean check; //Etat du control.
	public static String erreur; // message d'erreur suite au controle KO.

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
		erreur = "";
	}
	
	/***************************************************************************/
	/* 
	 * Methode : CheckMail                         
	 * Objet : Control d'une chaine mail.
	 * Par : Peter HOWSE                                  
	 * In  : chaine de caract�re
	 * Out : boul�en true -> mail correct 
	 *              false -> mail incorrect                                                                   
	 */ 
	/***************************************************************************/

	public boolean CheckMail(String mail) {
		
		// Mail pr�sent ?
		if (mail == "") {
			check = false;
			erreur ="Mail absent.";
		}
     return check;
  } // fin CheckMail
	
	/***************************************************************************/
	/* 
	 * Methode : CheckMdp                         
	 * Objet : Control d'une chaine mot de passe.
	 * Par : Peter HOWSE                                  
	 * In  : chaine de caract�re
	 * Out : boul�en true -> mail correct 
	 *              false -> mail incorrect                                                                   
	 */ 
	/***************************************************************************/

	public boolean CheckMdp(String mdpsai, String mdpbase) {
		
		// Mail pr�sent ?
		if (mdpsai  == "") {
			check = false;
			erreur ="Mot de passe absent.";
		}
		if (mdpsai != mdpbase) {
			check = false;
			erreur ="Mot de passe incorrecte.";
		}
     return check;
  } // fin CheckMail
	
	
} // fin Check

