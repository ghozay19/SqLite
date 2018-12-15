package ghozay19.com.sqlkotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class LogBook(
        val id: Long?,
        val idLog: String?,
        val tanggal: String?,
        val judul: String?,
        val deskripsi: String?
) {
    companion object {
        const val TABLE_LOGBOOK: String = "TABLE LOG_BOOK"
        const val ID: String = "ID_"
        const val IDLOG: String ="ID_LOG"
        const val TANGGAL: String = "TANGGAL"
        const val JUDUL: String = "JUDUL"
        const val DESKRIPSI: String = "DESKRIPSI"
    }
}