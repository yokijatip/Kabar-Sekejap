package eastbound.yokijatiperkasa.kabarsekejap.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Settings(
    val ivSettings: Int,
    val tvSettings: String
): Parcelable
