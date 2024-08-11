package com.gadre.salesdetail.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gadre.salesdetail.Database.SalesInfo
import com.gadre.salesdetail.Database.TSales
import com.gadre.salesdetail.R
import com.gadre.salesdetail.databinding.DisplayalldetailsItemBinding

class DisplayAdapter():RecyclerView.Adapter<DisplayAdapter.DisplayDetailsHolder> (){
    val dislaylist=ArrayList<SalesInfo>()

    class DisplayDetailsHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val binding =DisplayalldetailsItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayDetailsHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.displayalldetails_item,parent,false)
        return DisplayDetailsHolder(view)
    }

    override fun getItemCount(): Int {
       return dislaylist.size
    }

    override fun onBindViewHolder(holder: DisplayDetailsHolder, position: Int) {
        holder.binding.textViewCityName.text=dislaylist[position].cityName
        holder.binding.textViewSalesPersonName.text=dislaylist[position].salesPersonName
        holder.binding.textViewSales.text=dislaylist[position].sales.toString()
    }
}