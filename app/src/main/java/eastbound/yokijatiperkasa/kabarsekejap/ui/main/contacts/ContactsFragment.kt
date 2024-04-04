package eastbound.yokijatiperkasa.kabarsekejap.ui.main.contacts

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import eastbound.yokijatiperkasa.kabarsekejap.Helper
import eastbound.yokijatiperkasa.kabarsekejap.LogTag
import eastbound.yokijatiperkasa.kabarsekejap.adapter.ContactsAdapter
import eastbound.yokijatiperkasa.kabarsekejap.data.model.Contacts
import eastbound.yokijatiperkasa.kabarsekejap.databinding.FragmentContactsBinding

class ContactsFragment : Fragment() {

    private lateinit var binding: FragmentContactsBinding
    private lateinit var rvContact: RecyclerView
    private val contactList = ArrayList<Contacts>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentContactsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvContact = binding.rvContacts
        rvContact.setHasFixedSize(true)

        showRecyclerView()
        userFromDatabase()


    }

    companion object {
        fun newInstance(): ContactsFragment {
            val fragment = ContactsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    private fun userFromDatabase() {
        val usersReference = Helper.rtDatabase.getReference("users")

        usersReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (userSnapshot in snapshot.children) {
                    val username = userSnapshot.child("username").getValue(String::class.java)

                    val user = Contacts(username)
                    contactList.add(user)

                }
                val adapter = ContactsAdapter(contactList)
                rvContact.adapter = adapter
            }




            override fun onCancelled(error: DatabaseError) {
                Log.d(LogTag.TAG_DATABASE.tag, "Failed to read value.", error.toException())
            }

        })

    }

    private fun showRecyclerView() {
        rvContact.layoutManager = LinearLayoutManager(requireContext())
        val listContactsAdapter = ContactsAdapter(contactList)
        rvContact.adapter = listContactsAdapter
    }
}