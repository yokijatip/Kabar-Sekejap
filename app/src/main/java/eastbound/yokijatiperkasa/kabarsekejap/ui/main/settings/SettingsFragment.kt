package eastbound.yokijatiperkasa.kabarsekejap.ui.main.settings

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eastbound.yokijatiperkasa.kabarsekejap.R
import eastbound.yokijatiperkasa.kabarsekejap.adapter.SettingsAdapter
import eastbound.yokijatiperkasa.kabarsekejap.data.model.Settings
import eastbound.yokijatiperkasa.kabarsekejap.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    private lateinit var rvSettings: RecyclerView
    private val listSettings = ArrayList<Settings>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        TODO
        rvSettings = binding.rvSettings
        rvSettings.setHasFixedSize(true)

        listSettings.addAll(getListSetting())
        showRecyclerView()
        accountSettings()
    }



    companion object {
        fun newInstance(): SettingsFragment {
            val fragment = SettingsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    @SuppressLint("Recycle")
    private fun getListSetting(): ArrayList<Settings> {
        val dataTitle = resources.getStringArray(R.array.settings_screen_title)
        val dataIcon = resources.obtainTypedArray(R.array.settings_screen_icon)
        val listSettings = ArrayList<Settings>()
        for (i in dataTitle.indices) {
            val settings = Settings(dataIcon.getResourceId(i, -1), dataTitle[i])
            listSettings.add(settings)
        }
        return listSettings
    }

    private fun showRecyclerView() {
        rvSettings.layoutManager = LinearLayoutManager(requireContext())
        val listSettingsAdapter = SettingsAdapter(listSettings)
        rvSettings.adapter = listSettingsAdapter
    }

    private fun accountSettings() {
        binding.apply {
            settingProfile.setOnClickListener {
                Toast.makeText(requireContext(), "Profile Settings Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}