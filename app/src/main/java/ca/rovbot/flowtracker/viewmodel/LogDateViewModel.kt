package ca.rovbot.flowtracker.viewmodel

import android.content.Context
import ca.rovbot.flowtracker.R
import ca.rovbot.flowtracker.base.BaseViewModel

class LogDateViewModel : BaseViewModel() {

    fun getLastPeriodDate(context: Context?): String {
        var editor = context!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)
         return editor.getString("freq","freq").toString()
    }

    fun getDays(context: Context?): String {
        var editor = context!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)
        return editor.getString("date","date").toString()
    }

}
