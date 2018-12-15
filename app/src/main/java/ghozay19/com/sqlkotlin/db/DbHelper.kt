package ghozay19.com.sqlkotlin.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import ghozay19.com.sqlkotlin.LogBook
import org.jetbrains.anko.db.*

class DbHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "db_logbook.db", null, 1) {

    companion object {
        private var instance: DbHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DbHelper {
            if (instance == null) {
                instance = DbHelper(ctx.applicationContext)
            }
            return instance as DbHelper
        }
    }


    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(
                LogBook.TABLE_LOGBOOK, true,
                LogBook.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                LogBook.IDLOG to TEXT + UNIQUE,
                LogBook.TANGGAL to TEXT,
                LogBook.JUDUL to TEXT,
                LogBook.DESKRIPSI to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    db?.dropTable(LogBook.TABLE_LOGBOOK,true)
    }
}
val Context.database:DbHelper
get() = DbHelper.getInstance(applicationContext)