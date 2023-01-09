package com.kodyakov.mycar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String DATABASE_NAME = "MyCar.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CAR_WASH_TABLE_NAME = "car_wash";
    private static final String CAR_WASH_COLUMN_ID = "_car_wash_id";
    private static final String CAR_WASH_COLUMN_DATE = "car_wash_date";
    private static final String CAR_WASH_COLUMN_COST = "car_wash_cost";
    private static final String CAR_WASH_COLUMN_COMMENT = "car_wash_comment";

    private static final String REFUELING_TABLE_NAME = "refueling";
    private static final String REFUELING_COLUMN_ID = "_refueling_id";
    private static final String REFUELING_COLUMN_DATE = "refueling_date";
    private static final String REFUELING_COLUMN_COST = "refueling_cost";
    private static final String REFUELING_COLUMN_COMMENT = "refueling_comment";

    private static final String PARKING_TABLE_NAME = "parking";
    private static final String PARKING_COLUMN_ID = "_parking_id";
    private static final String PARKING_COLUMN_DATE = "parking_date";
    private static final String PARKING_COLUMN_COST = "parking_cost";
    private static final String PARKING_COLUMN_COMMENT = "parking_comment";

    private static final String TOLL_ROAD_TABLE_NAME = "toll_road";
    private static final String TOLL_ROAD_COLUMN_ID = "_toll_road_id";
    private static final String TOLL_ROAD_COLUMN_DATE = "toll_road_date";
    private static final String TOLL_ROAD_COLUMN_COST = "toll_road_cost";
    private static final String TOLL_ROAD_COLUMN_COMMENT = "toll_road_comment";

    private static final String SERVICE_TABLE_NAME = "service";
    private static final String SERVICE_COLUMN_ID = "_service_id";
    private static final String SERVICE_COLUMN_DATE = "service_date";
    private static final String SERVICE_COLUMN_COST = "service_cost";
    private static final String SERVICE_COLUMN_COMMENT = "service_comment";

    private static final String TIRE_FITTING_TABLE_NAME = "tire_fitting";
    private static final String TIRE_FITTING_COLUMN_ID = "_tire_fitting_id";
    private static final String TIRE_FITTING_COLUMN_DATE = "tire_fitting_date";
    private static final String TIRE_FITTING_COLUMN_COST = "tire_fitting_cost";
    private static final String TIRE_FITTING_COLUMN_COMMENT = "tire_fitting_comment";

    private static final String REPAIR_TABLE_NAME = "repair";
    private static final String REPAIR_COLUMN_ID = "_repair_id";
    private static final String REPAIR_COLUMN_DATE = "repair_date";
    private static final String REPAIR_COLUMN_COST = "repair_cost";
    private static final String REPAIR_COLUMN_COMMENT = "repair_comment";

    private static final String SPARES_TABLE_NAME = "spares";
    private static final String SPARES_COLUMN_ID = "_spares_id";
    private static final String SPARES_COLUMN_DATE = "spares_date";
    private static final String SPARES_COLUMN_COST = "spares_cost";
    private static final String SPARES_COLUMN_COMMENT = "spares_comment";

    private static final String FINES_TABLE_NAME = "fines";
    private static final String FINES_COLUMN_ID = "_fines_id";
    private static final String FINES_COLUMN_DATE = "fines_date";
    private static final String FINES_COLUMN_COST = "fines_cost";
    private static final String FINES_COLUMN_COMMENT = "fines_comment";

    private static final String OTHER_TABLE_NAME = "other";
    private static final String OTHER_COLUMN_ID = "_other_id";
    private static final String OTHER_COLUMN_DATE = "other_date";
    private static final String OTHER_COLUMN_COST = "other_cost";
    private static final String OTHER_COLUMN_COMMENT = "other_comment";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + CAR_WASH_TABLE_NAME +
                " (" + CAR_WASH_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CAR_WASH_COLUMN_DATE + " TEXT, " +
                CAR_WASH_COLUMN_COMMENT + " TEXT, " +
                CAR_WASH_COLUMN_COST + " REAL);";
        db.execSQL(query);
        query = "CREATE TABLE " + REFUELING_TABLE_NAME +
                " (" + REFUELING_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                REFUELING_COLUMN_DATE + " TEXT, " +
                REFUELING_COLUMN_COMMENT + " TEXT, " +
                REFUELING_COLUMN_COST + " REAL);";
        db.execSQL(query);
        query = "CREATE TABLE " + PARKING_TABLE_NAME +
                " (" + PARKING_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PARKING_COLUMN_DATE + " TEXT, " +
                PARKING_COLUMN_COMMENT + " TEXT, " +
                PARKING_COLUMN_COST + " REAL);";
        db.execSQL(query);
        query = "CREATE TABLE " + TOLL_ROAD_TABLE_NAME +
                " (" + TOLL_ROAD_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TOLL_ROAD_COLUMN_DATE + " TEXT, " +
                TOLL_ROAD_COLUMN_COMMENT + " TEXT, " +
                TOLL_ROAD_COLUMN_COST + " REAL);";
        db.execSQL(query);
        query = "CREATE TABLE " + SERVICE_TABLE_NAME +
                " (" + SERVICE_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SERVICE_COLUMN_DATE + " TEXT, " +
                SERVICE_COLUMN_COMMENT + " TEXT, " +
                SERVICE_COLUMN_COST + " REAL);";
        db.execSQL(query);
        query = "CREATE TABLE " + TIRE_FITTING_TABLE_NAME +
                " (" + TIRE_FITTING_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TIRE_FITTING_COLUMN_DATE + " TEXT, " +
                TIRE_FITTING_COLUMN_COMMENT + " TEXT, " +
                TIRE_FITTING_COLUMN_COST + " REAL);";
        db.execSQL(query);
        query = "CREATE TABLE " + REPAIR_TABLE_NAME +
                " (" + REPAIR_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                REPAIR_COLUMN_DATE + " TEXT, " +
                REPAIR_COLUMN_COMMENT + " TEXT, " +
                REPAIR_COLUMN_COST + " REAL);";
        db.execSQL(query);
        query = "CREATE TABLE " + SPARES_TABLE_NAME +
                " (" + SPARES_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SPARES_COLUMN_DATE + " TEXT, " +
                SPARES_COLUMN_COMMENT + " TEXT, " +
                SPARES_COLUMN_COST + " REAL);";
        db.execSQL(query);
        query = "CREATE TABLE " + FINES_TABLE_NAME +
                " (" + FINES_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FINES_COLUMN_DATE + " TEXT, " +
                FINES_COLUMN_COMMENT + " TEXT, " +
                FINES_COLUMN_COST + " REAL);";
        db.execSQL(query);
        query = "CREATE TABLE " + OTHER_TABLE_NAME +
                " (" + OTHER_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                OTHER_COLUMN_DATE + " TEXT, " +
                OTHER_COLUMN_COMMENT + " TEXT, " +
                OTHER_COLUMN_COST + " REAL);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + CAR_WASH_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + REFUELING_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + PARKING_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TOLL_ROAD_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SERVICE_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TIRE_FITTING_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + REPAIR_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SPARES_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + FINES_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + OTHER_TABLE_NAME);
        onCreate(db);
    }

    public void addRow(Event event, String date, String comment, double cost){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        long res = -1;
        switch (event){
            case CAR_WASH:
                cv.put(CAR_WASH_COLUMN_DATE, date);
                cv.put(CAR_WASH_COLUMN_COMMENT, comment);
                cv.put(CAR_WASH_COLUMN_COST, cost);
                res = db.insert(CAR_WASH_TABLE_NAME, null, cv);
                break;
            case REFUELING:
                cv.put(REFUELING_COLUMN_DATE, date);
                cv.put(REFUELING_COLUMN_COMMENT, comment);
                cv.put(REFUELING_COLUMN_COST, cost);
                res = db.insert(REFUELING_TABLE_NAME, null, cv);
                break;
            case PARKING:
                cv.put(PARKING_COLUMN_DATE, date);
                cv.put(PARKING_COLUMN_COMMENT, comment);
                cv.put(PARKING_COLUMN_COST, cost);
                res = db.insert(PARKING_TABLE_NAME, null, cv);
                break;
            case TOLL_ROAD:
                cv.put(TOLL_ROAD_COLUMN_DATE, date);
                cv.put(TOLL_ROAD_COLUMN_COMMENT, comment);
                cv.put(TOLL_ROAD_COLUMN_COST, cost);
                res = db.insert(TOLL_ROAD_TABLE_NAME, null, cv);
                break;
            case SERVICE:
                cv.put(SERVICE_COLUMN_DATE, date);
                cv.put(SERVICE_COLUMN_COMMENT, comment);
                cv.put(SERVICE_COLUMN_COST, cost);
                res = db.insert(SERVICE_TABLE_NAME, null, cv);
                break;
            case TIRE_FITTING:
                cv.put(TIRE_FITTING_COLUMN_DATE, date);
                cv.put(TIRE_FITTING_COLUMN_COMMENT, comment);
                cv.put(TIRE_FITTING_COLUMN_COST, cost);
                res = db.insert(TIRE_FITTING_TABLE_NAME, null, cv);
                break;
            case REPAIR:
                cv.put(REPAIR_COLUMN_DATE, date);
                cv.put(REPAIR_COLUMN_COMMENT, comment);
                cv.put(REPAIR_COLUMN_COST, cost);
                res = db.insert(REPAIR_TABLE_NAME, null, cv);
                break;
            case SPARES:
                cv.put(SPARES_COLUMN_DATE, date);
                cv.put(SPARES_COLUMN_COMMENT, comment);
                cv.put(SPARES_COLUMN_COST, cost);
                res = db.insert(SPARES_TABLE_NAME, null, cv);
                break;
            case FINES:
                cv.put(FINES_COLUMN_DATE, date);
                cv.put(FINES_COLUMN_COMMENT, comment);
                cv.put(FINES_COLUMN_COST, cost);
                res = db.insert(FINES_TABLE_NAME, null, cv);
                break;
            case OTHER:
                cv.put(OTHER_COLUMN_DATE, date);
                cv.put(OTHER_COLUMN_COMMENT, comment);
                cv.put(OTHER_COLUMN_COST, cost);
                res = db.insert(OTHER_TABLE_NAME, null, cv);
                break;
        }
        if (res == -1){
            Toast.makeText(context, "Не удалось добавить запись", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Запись добавлена", Toast.LENGTH_SHORT).show();
        }

    }
    public Cursor readAllData(Event event){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        String query = "";
        switch (event){
            case CAR_WASH:
                query = "SELECT * FROM " + CAR_WASH_TABLE_NAME;
                break;
            case REFUELING:
                query = "SELECT * FROM " + REFUELING_TABLE_NAME;
                break;
            case PARKING:
                query = "SELECT * FROM " + PARKING_TABLE_NAME;
                break;
            case TOLL_ROAD:
                query = "SELECT * FROM " + TOLL_ROAD_TABLE_NAME;
                break;
            case SERVICE:
                query = "SELECT * FROM " + SERVICE_TABLE_NAME;
                break;
            case TIRE_FITTING:
                query = "SELECT * FROM " + TIRE_FITTING_TABLE_NAME;
                break;
            case REPAIR:
                query = "SELECT * FROM " + REPAIR_TABLE_NAME;
                break;
            case SPARES:
                query = "SELECT * FROM " + SPARES_TABLE_NAME;
                break;
            case FINES:
                query = "SELECT * FROM " + FINES_TABLE_NAME;
                break;
            case OTHER:
                query = "SELECT * FROM " + OTHER_TABLE_NAME;
                break;
        }
        if (db != null ){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    void updateData(Event event, String row_id, String date, String comment, String cost){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        long res = -1;
        switch (event){
            case CAR_WASH:
                cv.put(CAR_WASH_COLUMN_DATE, date);
                cv.put(CAR_WASH_COLUMN_COMMENT, comment);
                cv.put(CAR_WASH_COLUMN_COST, cost);
                res = db.update(CAR_WASH_TABLE_NAME, cv, "_car_wash_id=?", new String[]{row_id});
                break;
            case REFUELING:
                cv.put(REFUELING_COLUMN_DATE, date);
                cv.put(REFUELING_COLUMN_COMMENT, comment);
                cv.put(REFUELING_COLUMN_COST, cost);
                res = db.update(REFUELING_TABLE_NAME, cv, "_refueling_id=?", new String[]{row_id});
                break;
            case PARKING:
                cv.put(PARKING_COLUMN_DATE, date);
                cv.put(PARKING_COLUMN_COMMENT, comment);
                cv.put(PARKING_COLUMN_COST, cost);
                res = db.update(PARKING_TABLE_NAME, cv, "_parking_id=?", new String[]{row_id});
                break;
            case TOLL_ROAD:
                cv.put(TOLL_ROAD_COLUMN_DATE, date);
                cv.put(TOLL_ROAD_COLUMN_COMMENT, comment);
                cv.put(TOLL_ROAD_COLUMN_COST, cost);
                res = db.update(TOLL_ROAD_TABLE_NAME, cv, "_toll_road_id=?", new String[]{row_id});
                break;
            case SERVICE:
                cv.put(SERVICE_COLUMN_DATE, date);
                cv.put(SERVICE_COLUMN_COMMENT, comment);
                cv.put(SERVICE_COLUMN_COST, cost);
                res = db.update(SERVICE_TABLE_NAME, cv, "_service_id=?", new String[]{row_id});
                break;
            case TIRE_FITTING:
                cv.put(TIRE_FITTING_COLUMN_DATE, date);
                cv.put(TIRE_FITTING_COLUMN_COMMENT, comment);
                cv.put(TIRE_FITTING_COLUMN_COST, cost);
                res = db.update(TIRE_FITTING_TABLE_NAME, cv, "_tire_fitting_id=?", new String[]{row_id});
                break;
            case REPAIR:
                cv.put(REPAIR_COLUMN_DATE, date);
                cv.put(REPAIR_COLUMN_COMMENT, comment);
                cv.put(REPAIR_COLUMN_COST, cost);
                res = db.update(REPAIR_TABLE_NAME, cv, "_repair_id=?", new String[]{row_id});
                break;
            case SPARES:
                cv.put(SPARES_COLUMN_DATE, date);
                cv.put(SPARES_COLUMN_COMMENT, comment);
                cv.put(SPARES_COLUMN_COST, cost);
                res = db.update(SPARES_TABLE_NAME, cv, "_spares_id=?", new String[]{row_id});
                break;
            case FINES:
                cv.put(FINES_COLUMN_DATE, date);
                cv.put(FINES_COLUMN_COMMENT, comment);
                cv.put(FINES_COLUMN_COST, cost);
                res = db.update(FINES_TABLE_NAME, cv, "_fines_id=?", new String[]{row_id});
                break;
            case OTHER:
                cv.put(OTHER_COLUMN_DATE, date);
                cv.put(OTHER_COLUMN_COMMENT, comment);
                cv.put(OTHER_COLUMN_COST, cost);
                res = db.update(OTHER_TABLE_NAME, cv, "_other_id=?", new String[]{row_id});
                break;
        }
        if (res == -1){
            Toast.makeText(context, "Не удалось обновить", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Обновлено", Toast.LENGTH_SHORT).show();
        }
    }
    void deleteRow(Event event, String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long res = -1;
        switch (event){
            case CAR_WASH:
                res = db.delete(CAR_WASH_TABLE_NAME, "_car_wash_id=?", new String[]{row_id});
                break;
            case REFUELING:
                res = db.delete(REFUELING_TABLE_NAME, "_refueling_id=?", new String[]{row_id});
                break;
            case PARKING:
                res = db.delete(PARKING_TABLE_NAME, "_parking_id=?", new String[]{row_id});
                break;
            case TOLL_ROAD:
                res = db.delete(TOLL_ROAD_TABLE_NAME, "_toll_road_id=?", new String[]{row_id});
                break;
            case SERVICE:
                res = db.delete(SERVICE_TABLE_NAME, "_service_id=?", new String[]{row_id});
                break;
            case TIRE_FITTING:
                res = db.delete(TIRE_FITTING_TABLE_NAME, "_tire_fitting_id=?", new String[]{row_id});
                break;
            case REPAIR:
                res = db.delete(REPAIR_TABLE_NAME, "_repair_id=?", new String[]{row_id});
                break;
            case SPARES:
                res = db.delete(SPARES_TABLE_NAME, "_spares_id=?", new String[]{row_id});
                break;
            case FINES:
                res = db.delete(FINES_TABLE_NAME, "_fines_id=?", new String[]{row_id});
                break;
            case OTHER:
                res = db.delete(OTHER_TABLE_NAME, "_other_id=?", new String[]{row_id});
                break;
        }
        if (res == -1){
            Toast.makeText(context, "Не удалось обновить", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Удалено", Toast.LENGTH_SHORT).show();
        }
    }


}
