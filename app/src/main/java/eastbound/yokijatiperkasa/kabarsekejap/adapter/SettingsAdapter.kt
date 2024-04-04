package eastbound.yokijatiperkasa.kabarsekejap.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import eastbound.yokijatiperkasa.kabarsekejap.R
import eastbound.yokijatiperkasa.kabarsekejap.data.model.Settings

class SettingsAdapter(private val listSettings: ArrayList<Settings>) :
    RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class SettingsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivSettings: ImageView = view.findViewById(R.id.iv_settings_menu)
        val tvSettings: TextView = view.findViewById(R.id.tv_settings_menu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_settings, parent, false)
        return SettingsViewHolder(view)
    }

    override fun getItemCount() = listSettings.size

    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {

        val (ivSettings, tvSettings) = listSettings[position]
        holder.ivSettings.setImageResource(ivSettings)
        holder.tvSettings.text = tvSettings
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listSettings[holder.adapterPosition])
        }

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Settings)
    }

}