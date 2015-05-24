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

public class Table {

	// Table de la base de donn�es
	public static final String TABLE_USER = "USER";
	public static final String COLUMN_USER_ID = "_id";
	public static final String COLUMN_USER_MAIL = "USEMAIL";
	public static final String COLUMN_USER_MDP = "USEMDP";
	
	public static final String TABLE_TASK = "TASK";
	public static final String COLUMN_TASK_ID = "_id";
	public static final String COLUMN_TASK_REF = "TASREF";
	public static final String COLUMN_TASK_DES = "TASDES";

	// Instruction SQL de cr�ation de la base de donn�es
	private static final String DATABASE_CREATE = "create table " 
		+ TABLE_USER
		+ "(" 
		+ COLUMN_USER_ID + " integer primary key autoincrement, " 
		+ COLUMN_USER_MAIL + " text not null, " 
		+ COLUMN_USER_MDP + " text not null"    
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
		Log.w(Table.class.getName(), "Mise � jour de la base de la version "
				+ oldVersion + " � " + newVersion
				+ ", avec destruction de toutes les donn�es");
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
		onCreate(database);
	} //onCreate
  
} //