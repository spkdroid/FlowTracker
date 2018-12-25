package ca.rovbot.flowtracker.viewmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import ca.rovbot.flowtracker.R

class MainViewModel : ViewModel() {

    fun validateUser(it: Context?): Boolean {

        val editor = it!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)

        val date = editor.getString("date","date").toString()
        val freq = editor.getString("freq","freq").toString()

        if(date.equals("date") && freq.equals("freq")) {
            return true;
        }
        return false;
    }
    // TODO: Implement the ViewModel
}
