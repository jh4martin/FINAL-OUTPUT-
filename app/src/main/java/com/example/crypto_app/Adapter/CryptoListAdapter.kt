package com.example.crypto_app.Adapter

import android.content.Context
import android.content.Intent
import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crypto_app.Activity.DetailCryptoActivity
import com.example.crypto_app.Model.CryptoModel
import com.example.crypto_app.R
import com.example.crypto_app.databinding.ViewholderWalletBinding

class CryptoListAdapter(private val items:MutableList<CryptoModel>):
    RecyclerView.Adapter<CryptoListAdapter.Viewholder>() {
    class Viewholder (val binding:ViewholderWalletBinding):RecyclerView.ViewHolder(binding.root)


    private lateinit var context: Context
    var formatter: DecimalFormat? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CryptoListAdapter.Viewholder {
        context = parent.context
        formatter = DecimalFormat("###,###,###,###")
        val binding = ViewholderWalletBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: CryptoListAdapter.Viewholder, position: Int) {
        val item=items[position]
        holder.binding.cryptoNameTxt.text=item.Symbol
        holder.binding.cryptoPriceTxt.text="₱"+formatter?.format(item.Price)
        holder.binding.changePercentTxt.text=item.ChangePercent.toString()+"%"
        holder.binding.propertySizeTxt.text=item.AmountNumber.toString()+item.ShortSymbol.replace("/PHP","")
        holder.binding.propertyAmountTxt.text="₱" + formatter?.format(item.AmountPeso)
        if (item.ChangePercent < 0) holder.binding.changePercentTxt.setTextColor(
            context.resources.getColor(
                R.color.red)
        )

        val drawableResourceId=holder.itemView.resources.getIdentifier(
            item.SymbolLogo,
            "drawable",
            holder.itemView.context.packageName
        )

    Glide.with(context)
    .load(drawableResourceId)
    .into(holder.binding.logoImg)

     holder.itemView.setOnClickListener {
         val intent = Intent(context, DetailCryptoActivity::class.java)
         intent.putExtra("object", item)
         holder.itemView.context.startActivity(intent)
     }

    }

    override fun getItemCount(): Int =items.size
}