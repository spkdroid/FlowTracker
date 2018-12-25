package ca.rovbot.flowtracker.viewmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import ca.rovbot.flowtracker.R

class MainViewModel : ViewModel() {

    fun validateUser(it: Context?): Boolean {

        val editor = it!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)

        if(editor.getString("date", "date").toString().isNotEmpty() && editor.getString(
                "freq",
                "freq"
            ).toString().isNotEmpty()
        ) {
            return true;
        }
        return false;
    }
    // TODO: Implement the ViewModel
}
