package fr.easytime.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Table {

  // Table de la base de données
  public static final String TABLE_USER = "USER";
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_MAIL = "USEMAIL";
  public static final String COLUMN_MDP = "USEMDP";

  // Instruction SQL de création de la base de données
  private static final String DATABASE_CREATE = "create table " 
      + TABLE_USER
      + "(" 
      + COLUMN_ID + " integer primary key autoincrement, " 
      + COLUMN_MAIL + " text not null, " 
      + COLUMN_MDP + " text not null"    
      + ");";

  public static void onCreate(SQLiteDatabase database) {
    database.execSQL(DATABASE_CREATE);
  }

  public static void onUpgrade(SQLiteDatabase database, int oldVersion,
      int newVersion) {
    Log.w(Table.class.getName(), "Mise à jour de la base de la version "
        + oldVersion + " à " + newVersion
        + ", avec destruction de toutes les données");
    database.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
    onCreate(database);
  }
  

}