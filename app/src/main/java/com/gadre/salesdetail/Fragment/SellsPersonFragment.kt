package com.gadre.salesdetail.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.gadre.salesdetail.Database.DBHelper
import com.gadre.salesdetail.Database.TCity
import com.gadre.salesdetail.Database.TSalesPerson
import com.gadre.salesdetail.R
import com.gadre.salesdetail.adapters.PersonNameAdapter
import com.gadre.salesdetail.databinding.FragmentSellsPersonBinding


class SellsPersonFragment : Fragment() {
    private lateinit var binding: FragmentSellsPersonBinding
    private lateinit var personRecycerviewAdapter: PersonNameAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSellsPersonBinding.inflate(inflater, container, false)

        //set up for person recycler view
        personRecycerviewAdapter = PersonNameAdapter()
        binding.PersonrecyclerView.adapter = personRecycerviewAdapter
        binding.PersonrecyclerView.layoutManager = LinearLayoutManager(context)

        displayperson()
        insetPersonName()
        return binding.root
    }


    private fun insetPersonName() {
        binding.buttonAddSellsPerson.setOnClickListener {
            val sellspersonname = binding.editTextsellsperson.text.toString()
            val dbHelper = DBHelper(requireContext())
            if (sellspersonname.isNotEmpty()) {
                val isInseted = dbHelper.insertPersonName(TSalesPerson(sellspersonname))
                if (isInseted) {
                    Toast.makeText(
                        requireContext(),
                        "Sells person added successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    displayperson()
                }
            }
        }
    }

    private fun displayperson() {
        val dbHelper = DBHelper(requireContext())
        val personname = dbHelper.selectpersonname()

        if (personname!= null){
            personRecycerviewAdapter.personNamelist.clear()
            personRecycerviewAdapter.personNamelist.addAll(personname)
            personRecycerviewAdapter.notifyDataSetChanged()
        }

    }

}