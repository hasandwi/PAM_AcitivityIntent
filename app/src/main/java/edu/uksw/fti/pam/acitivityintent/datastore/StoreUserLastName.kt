package edu.uksw.fti.pam.acitivityintent.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreUserLastName(private val context: Context) {

    //
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("userLastName")
            val USER_LASTNAME_KEY = stringPreferencesKey("userLastName")
    }

    //Untuk Mendapatkan Last Name
    val getLastName: Flow<String?> = context.dataStore.data
        .map {preferences ->
            preferences[USER_LASTNAME_KEY] ?: ""
        }

    // Untuk Menyimpan Last Name
    suspend fun saveLastName(name: String){
        context.dataStore.edit {preferences ->
            preferences[USER_LASTNAME_KEY] = name
        }
    }
}