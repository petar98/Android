package com.example.covitracker.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covitracker.R
import com.example.covitracker.network.data.GlobalData

class ModelListAdapter(private val list: List<GlobalData>?) :
    RecyclerView.Adapter<ModelListAdapter.ModelViewHolder>() {

    class ModelViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val country: TextView = item.findViewById(R.id.txtCountryName)
        val newConfirmed: TextView = item.findViewById(R.id.txtNewConfirmed)
        val totalConfirmed: TextView = item.findViewById(R.id.txtConfirmCases)
        val newDeaths: TextView = item.findViewById(R.id.txtNewDeaths)
        val newRecovered: TextView = item.findViewById(R.id.txtNewRecovered)
        val totalRecovered: TextView = item.findViewById(R.id.txtRecovered)
        val totalDeaths: TextView = item.findViewById(R.id.txtTotalDeaths)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view: View = LayoutInflater.from(parent.context).
            inflate(R.layout.country_list_item,parent,false)
        return ModelViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        if (list != null) {
            val filteredList = list.filter { it.TotalConfirmed != 0 }
            holder.country.text = filteredList!!.get(position).Country
            holder.newConfirmed.text = filteredList.get(position).NewConfirmed.toString()
            holder.totalConfirmed.text = filteredList.get(position).TotalConfirmed.toString()
            holder.newRecovered.text = filteredList.get(position).NewRecovered.toString()
            holder.totalRecovered.text = filteredList.get(position).TotalRecovered.toString()
            holder.newDeaths.text = filteredList.get(position).NewDeaths.toString()
            holder.totalDeaths.text = filteredList.get(position).TotalDeaths.toString()
        }
    }
}