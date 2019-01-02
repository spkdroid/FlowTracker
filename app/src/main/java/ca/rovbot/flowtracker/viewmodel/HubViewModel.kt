package ca.rovbot.flowtracker.viewmodel

import android.content.Context
import ca.rovbot.flowtracker.R
import ca.rovbot.flowtracker.base.BaseViewModel


class HubViewModel : BaseViewModel() {


    fun getCurrentProgress(currentDayNumber:String,context: Context?):Float{
        val editor = context!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)
        val maxDate = editor.getString("date", "date").toString()
        var percentage = (currentDayNumber.toFloat()/maxDate.toFloat())*100;
        return percentage
    }

}
