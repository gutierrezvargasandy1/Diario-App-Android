package mx.edu.utng.appdiario.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import mx.edu.utng.appdiario.local.dao.NotaDao
import mx.edu.utng.appdiario.local.dao.TarjetaDao
import mx.edu.utng.appdiario.local.dao.UsuarioDao
import mx.edu.utng.appdiario.local.entity.Nota
import mx.edu.utng.appdiario.local.entity.Tarjeta
import mx.edu.utng.appdiario.local.entity.Usuario
import mx.edu.utng.appdiario.local.entity.TipoUsuarioConverter

@Database(
    entities = [Usuario::class, Tarjeta::class, Nota::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(TipoUsuarioConverter::class) // 👈 Agrega esta línea
abstract class AppDatabase : RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao
    abstract fun tarjetaDao(): TarjetaDao
    abstract fun notaDao(): NotaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "DiarioDB"
                )
                    .fallbackToDestructiveMigration() // 🔹 Borra y recrea la DB si cambia la versión
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
