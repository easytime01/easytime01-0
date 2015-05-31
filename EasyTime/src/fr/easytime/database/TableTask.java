/******************************************************************************/
/* 
 * Package fr.easytime.database                                                  
 * Gestion de la base de donn�es.
*/ 
/******************************************************************************/
/* 
 * Cr�ation : 20 mai 2015                  
 *  Auteur   : Peter HOWSE                  
 *  But      : Cr�ation des tables.
 *  Classe   : Table        
 */	
/******************************************************************************/
/* 
 * Modifier le :                             
 * Par :                                   
 * classe :                                                                   
 * Objet : 
*/ 
/******************************************************************************/

package fr.easytime.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TableTask {

	// Table de la base de donn�es
	
	public static final String TABLE_TASK = "TASK";
	public static final String COLUMN_TASK_ID = "_id";
	public static final String COLUMN_TASK_REF = "TASREF";
	public static final String COLUMN_TASK_DES = "TASDESC";
	public static final String COLUMN_TASK_ETAT = "TASETAT";
	public static final String COLUMN_TASK_MIN = "TASDURMIN";

	// Instruction SQL de cr�ation de la base de donn�es
	private static final String DATABASE_CREATE = "create table " 
		+ TABLE_TASK
		+ "(" 
		+ COLUMN_TASK_ID + " integer primary key autoincrement, " 
		+ COLUMN_TASK_REF + " text not null, " 
		+ COLUMN_TASK_DES + " text not null"    
		+ COLUMN_TASK_ETAT + " text not null"  
		+ COLUMN_TASK_MIN + " text not null"  
		+ ");";

	/***************************************************************************/
	/* 
	 * Methode : onCreate                     
	 * Objet : Cr�ation des tables.
	 * Par : Peter HOWSE                                  
	 * In  : Context  Environnement de l'appelant.
	 * Out : Ras                                                               
	 */ 
	/***************************************************************************/
	
	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}//onCreate
	
	/***************************************************************************/
	/* 
	 * Methode : onUpgrade                         
	 * Objet : Modification des tables de la base.
	 * Par : Peter HOWSE                                  
	 * In  : Context  Environnement de l'appelant.
	 * Out : Ras                                                               
	 */ 
	/***************************************************************************/
	
	public static void onUpgrade(SQLiteDatabase database, int oldVersion,
				int newVersion) {
		Log.w(TableTask.class.getName(), "Mise � jour de la base de la version "
				+ oldVersion + " � " + newVersion
				+ ", avec destruction de toutes les donn�es");
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
		onCreate(database);
	} //onCreate
  
} //