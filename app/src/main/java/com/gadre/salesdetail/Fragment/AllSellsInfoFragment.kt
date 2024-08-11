package com.gadre.salesdetail.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.gadre.salesdetail.Database.DBHelper
import com.gadre.salesdetail.Database.TCity
import com.gadre.salesdetail.Database.TSales
import com.gadre.salesdetail.Database.TSalesPerson
import com.gadre.salesdetail.R
import com.gadre.salesdetail.databinding.FragmentAllSellsInfoBinding

class AllSellsInfoFragment : Fragment() {

    private lateinit var binding: FragmentAllSellsInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllSellsInfoBinding.inflate(inflater, container, false)
        onsavebuttonclick()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dbHelper = DBHelper(requireContext())

        // Fetch city data and display into dropdown
        val city = dbHelper.selectCity() ?: emptyList()
        val cityAdapter = ArrayAdapter<TCity>(requireContext(), android.R.layout.simple_spinner_item, city)
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCityName.adapter = cityAdapter

        //fetch person data and display into dropdown
        val person = dbHelper.selectpersonname() ?: emptyList()
        val personAdapter = ArrayAdapter<TSalesPerson>(requireContext(), android.R.layout.simple_spinner_item, person)
        personAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPersonName.adapter = personAdapter

    }

    private fun onsavebuttonclick() {
        binding.btnSave.setOnClickListener {
            val month = binding.editTextMonth.text.toString()
            val year = binding.editTextYear.text.toString()
            val sales = binding.editSale.text.toString()
            val city = binding.spinnerCityName.selectedItem as TCity
            val personName = binding.spinnerPersonName.selectedItem as TSalesPerson
            val dbhelper = DBHelper(requireContext())
            if (month.isNotEmpty() && year.isNotEmpty() && sales.isNotEmpty()) {
                val tsales = TSales(month, year, personName.personID!!, city.cityID!!, sales.toDouble())
                dbhelper.insertSales(tsales)

                Toast.makeText(requireContext(), "data inserted successfully", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

}