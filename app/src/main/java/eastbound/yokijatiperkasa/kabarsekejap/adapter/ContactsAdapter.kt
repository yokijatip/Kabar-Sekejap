package eastbound.yokijatiperkasa.kabarsekejap.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import eastbound.yokijatiperkasa.kabarsekejap.R
import eastbound.yokijatiperkasa.kabarsekejap.data.model.Contacts

class ContactsAdapter(private val contactList: ArrayList<Contacts>) :
    RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_contacts, parent, false)
        return ContactsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val (tvUsername) = contactList[position]
        holder.tvUsername.text = tvUsername
    }

    override fun getItemCount() = contactList.size
    class ContactsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUsername: TextView = view.findViewById(R.id.tv_contacts_username)
    }


}