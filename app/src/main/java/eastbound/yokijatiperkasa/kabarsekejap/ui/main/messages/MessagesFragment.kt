package eastbound.yokijatiperkasa.kabarsekejap.ui.main.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eastbound.yokijatiperkasa.kabarsekejap.R
import eastbound.yokijatiperkasa.kabarsekejap.databinding.FragmentMessagesBinding

class MessagesFragment : Fragment() {

    private lateinit var binding: FragmentMessagesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMessagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        TODO
    }

    companion object {
        fun newInstance(): MessagesFragment {
            val fragment = MessagesFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}