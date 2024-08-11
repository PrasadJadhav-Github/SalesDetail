package com.gadre.salesdetail.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gadre.salesdetail.Database.TSalesPerson
import com.gadre.salesdetail.R
import com.gadre.salesdetail.databinding.SellspersonrecyclerviewItemBinding

class PersonNameAdapter:RecyclerView.Adapter<PersonNameAdapter.PersonNameHolder> (){
    val personNamelist=ArrayList<TSalesPerson>()

    class PersonNameHolder (itemView: View ):RecyclerView.ViewHolder(itemView){
        val binding=SellspersonrecyclerviewItemBinding.bind(itemView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonNameHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.sellspersonrecyclerview_item,parent,false)
        return PersonNameHolder(view)
    }

    override fun getItemCount(): Int {
       return  personNamelist.size
    }

    override fun onBindViewHolder(holder: PersonNameHolder, position: Int) {
        holder.binding.textviewPersonName.text=personNamelist[position].personname
    }
}