package eastbound.yokijatiperkasa.kabarsekejap.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contacts(
    val name: String? = null
) : Parcelable