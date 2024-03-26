package eastbound.yokijatiperkasa.kabarsekejap.ui.main.contacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eastbound.yokijatiperkasa.kabarsekejap.R
import eastbound.yokijatiperkasa.kabarsekejap.databinding.FragmentContactsBinding
import eastbound.yokijatiperkasa.kabarsekejap.ui.main.messages.MessagesFragment

class ContactsFragment : Fragment() {

    private lateinit var binding: FragmentContactsBinding

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

//        TODO
    }

    companion object {
        fun newInstance(): ContactsFragment {
            val fragment = ContactsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}