import android.content.Context
import android.content.SharedPreferences

class AppPref(context: Context) {
    private val pref: SharedPreferences

    init {
        pref = context.getSharedPreferences(APP_PREF_NAME, Context.MODE_PRIVATE)
    }

    object PrefKey {
        const val IS_LOGIN_KEY = "is_login_key"
    }

    fun put(key: String, value: String) {
        with(pref.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun put(key: String, value: Int) {
        with(pref.edit()) {
            putInt(key, value)
            apply()
        }
    }

    fun put(key: String, value: Boolean) {
        with(pref.edit()) {
            putBoolean(key, value)
            apply()
        }
    }

    fun getString(key: String, defaultValue: String = ""): String {
        return pref.getString(key, defaultValue) ?: ""
    }

    fun getInt(key: String, defaultValue: Int = 0): Int {
        return pref.getInt(key, defaultValue)
    }

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return pref.getBoolean(key, defaultValue)
    }

    fun remove(vararg keys: String) {
        with(pref.edit()) {
            for (key in keys) remove(key)
            apply()
        }
    }

    fun clear() {
        with(pref.edit()) {
            clear()
            apply()
        }
    }

    companion object {
        private const val APP_PREF_NAME = "app_pref"
        private var instance: AppPref? = null

        fun getInstance(context: Context): AppPref = instance ?: AppPref(context).also { instance = it }
    }
}
