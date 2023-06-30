package com.merqurex.carrepair

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomerAdapter(private val customers: List<Customer>) : RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_customer, parent, false)
        return CustomerViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val currentCustomer = customers[position]
        holder.textName.text = "${currentCustomer.firstName} ${currentCustomer.lastName}"
        holder.textPhone.text = "Phone: ${currentCustomer.phoneNumber}"
        holder.textEmail.text = "Email: ${currentCustomer.email}"
        holder.textLocality.text = "Locality: ${currentCustomer.locality}"
        holder.textCity.text = "City: ${currentCustomer.city}"
        holder.textState.text = "State: ${currentCustomer.state}"
        holder.textPincode.text = "Pincode: ${currentCustomer.pincode}"
        holder.textCarManufacturer.text = "Car Manufacturer: ${currentCustomer.carManufacturer}"
        holder.textCarModel.text = "Car Model: ${currentCustomer.carModel}"
        holder.textCarMYear.text = "Car Manufacturing Year: ${currentCustomer.carMYear}"
    }

    override fun getItemCount(): Int {
        return customers.size
    }

    inner class CustomerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName: TextView = itemView.findViewById(R.id.textName)
        val textPhone: TextView = itemView.findViewById(R.id.textPhone)
        val textEmail: TextView = itemView.findViewById(R.id.textEmail)
        val textLocality: TextView = itemView.findViewById(R.id.textLocality)
        val textCity: TextView = itemView.findViewById(R.id.textCity)
        val textState: TextView = itemView.findViewById(R.id.textState)
        val textPincode: TextView = itemView.findViewById(R.id.textPincode)
        val textCarManufacturer: TextView = itemView.findViewById(R.id.textCarManufacturer)
        val textCarModel: TextView = itemView.findViewById(R.id.textCarModel)
        val textCarMYear: TextView = itemView.findViewById(R.id.textCarMYear)
    }
}
