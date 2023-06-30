package com.merqurex.carrepair

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textFName = this.findViewById<EditText>(R.id.textFName)
        val textLName = this.findViewById<EditText>(R.id.textLName)
        val textPhone = this.findViewById<EditText>(R.id.textPhone)
        val textEmail = this.findViewById<EditText>(R.id.textEmail)
        val textLocality = this.findViewById<EditText>(R.id.textLocality)
        val textCity = this.findViewById<EditText>(R.id.textCity)
        val textState = this.findViewById<EditText>(R.id.textState)
        val textPincode = this.findViewById<EditText>(R.id.textPincode)
        val textCarManufacturer = this.findViewById<EditText>(R.id.textCarManufacturer)
        val textCarModel = this.findViewById<EditText>(R.id.textCarModel)
        val textCarMYear = this.findViewById<EditText>(R.id.textCarMYear)
        // Initialize other UI components

        val databaseHelper = DBHelper(this)
        val submitButton = this.findViewById<Button>(R.id.submitButton)
        val viewDB = this.findViewById<Button>(R.id.viewDB)

        submitButton.setOnClickListener {
            // Retrieve values from input fields
            val firstName = textFName.text.toString()
            val lastName = textLName.text.toString()
            val phoneText = textPhone.text.toString()
            val email = textEmail.text.toString()
            val locality = textLocality.text.toString()
            val city = textCity.text.toString()
            val state = textState.text.toString()
            val pincodeText = textPincode.text.toString()
            val carManufacturer = textCarManufacturer.text.toString()
            val carModel = textCarModel.text.toString()
            val carMYear = textCarMYear.text.toString()

            // Validate the required fields
            if (firstName.isEmpty() || lastName.isEmpty() || locality.isEmpty() || city.isEmpty() || state.isEmpty() || carManufacturer.isEmpty() || carModel.isEmpty() || phoneText.isEmpty() || pincodeText.isEmpty()) {
                // Show an error message or toast indicating missing fields
                Toast.makeText(applicationContext, "Please enter all required fields!", Toast.LENGTH_SHORT).show()
            } else {
                // Perform conversion of phone and pincode
                val phone = phoneText.toIntOrNull()
                val pincode = pincodeText.toIntOrNull()

                if (phone == null || pincode == null) {
                    // Show an error message or toast indicating invalid values
                    Toast.makeText(applicationContext, "Invalid phone number or pincode!", Toast.LENGTH_SHORT).show()
                } else {
                    // Insert data into the database
                    databaseHelper.insertCustomer(firstName, lastName, phone, email, locality, city, state, pincode, carManufacturer, carModel, carMYear)
                    // Show a success message or navigate to the next screen
                    Toast.makeText(applicationContext, "Successfully Registered", Toast.LENGTH_SHORT).show()
                }
            }
        }


        viewDB.setOnClickListener {
            val viewDBIntent = Intent(this, ViewDatabase::class.java)
            startActivity(viewDBIntent)
        }


    }
}
