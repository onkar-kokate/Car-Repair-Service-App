package com.merqurex.carrepair;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "customers.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "customer";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_LAST_NAME = "last_name";
    private static final String COLUMN_PHONE = "phone_number";
    private static final String COLUMN_EMAIL = "email_address";
    private static final String COLUMN_LOCALITY = "locality";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_STATE = "state";
    private static final String COLUMN_PINCODE = "pin_code";
    private static final String COLUMN_CAR_MANUFACTURER = "car_manufacturer";
    private static final String COLUMN_CAR_MODEL = "car_model";
    private static final String COLUMN_CAR_MYEAR = "car_manufac_year";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_FIRST_NAME + " TEXT, " +
                COLUMN_LAST_NAME + " TEXT, " +
                COLUMN_PHONE + " INTEGER PRIMARY KEY, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_LOCALITY + " TEXT, " +
                COLUMN_CITY + " TEXT, " +
                COLUMN_STATE + " TEXT, " +
                COLUMN_PINCODE + " INTEGER, " +
                COLUMN_CAR_MANUFACTURER + " TEXT, " +
                COLUMN_CAR_MODEL + " TEXT, " +
                COLUMN_CAR_MYEAR + " TEXT" +
                ")";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertCustomer(String firstName, String lastName, int phone_number, String email, String locality, String city, String state, int pincode, String car_manufacturer, String car_model, String car_m_year) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST_NAME, firstName);
        values.put(COLUMN_LAST_NAME, lastName);
        values.put(COLUMN_PHONE, phone_number);

        // Check if the email is empty or null before inserting
        if (email != null && !email.isEmpty()) {
            values.put(COLUMN_EMAIL, email);
        }

        values.put(COLUMN_LOCALITY, locality);
        values.put(COLUMN_CITY, city);
        values.put(COLUMN_STATE, state);
        values.put(COLUMN_PINCODE, pincode);
        values.put(COLUMN_CAR_MANUFACTURER, car_manufacturer);
        values.put(COLUMN_CAR_MODEL, car_model);

        // Check if the car manufacturing year is empty or null before inserting
        if (car_m_year != null && !car_m_year.isEmpty()) {
            values.put(COLUMN_CAR_MYEAR, car_m_year);
        }

        // Insert the values into the table
        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public List<Customer> getAllCustomers() {
        List<Customer> customersList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            int firstNameIndex = cursor.getColumnIndex(COLUMN_FIRST_NAME);
            int lastNameIndex = cursor.getColumnIndex(COLUMN_LAST_NAME);
            int phoneNumberIndex = cursor.getColumnIndex(COLUMN_PHONE);
            int emailIndex = cursor.getColumnIndex(COLUMN_EMAIL);
            int localityIndex = cursor.getColumnIndex(COLUMN_LOCALITY);
            int cityIndex = cursor.getColumnIndex(COLUMN_CITY);
            int stateIndex = cursor.getColumnIndex(COLUMN_STATE);
            int pincodeIndex = cursor.getColumnIndex(COLUMN_PINCODE);
            int carManufacturerIndex = cursor.getColumnIndex(COLUMN_CAR_MANUFACTURER);
            int carModelIndex = cursor.getColumnIndex(COLUMN_CAR_MODEL);
            int carMYearIndex = cursor.getColumnIndex(COLUMN_CAR_MYEAR);

            do {
                if (firstNameIndex != -1 && lastNameIndex != -1 && phoneNumberIndex != -1 && emailIndex != -1
                        && localityIndex != -1 && cityIndex != -1 && stateIndex != -1 && pincodeIndex != -1
                        && carManufacturerIndex != -1 && carModelIndex != -1 && carMYearIndex != -1) {

                    String firstName = cursor.getString(firstNameIndex);
                    String lastName = cursor.getString(lastNameIndex);
                    int phoneNumber = cursor.getInt(phoneNumberIndex);
                    String email = cursor.getString(emailIndex);
                    String locality = cursor.getString(localityIndex);
                    String city = cursor.getString(cityIndex);
                    String state = cursor.getString(stateIndex);
                    int pincode = cursor.getInt(pincodeIndex);
                    String carManufacturer = cursor.getString(carManufacturerIndex);
                    String carModel = cursor.getString(carModelIndex);
                    String carMYear = cursor.getString(carMYearIndex);

                    Customer customer = new Customer(firstName, lastName, phoneNumber, email, locality, city, state, pincode, carManufacturer, carModel, carMYear);
                    customersList.add(customer);
                }
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return customersList;
    }

}
