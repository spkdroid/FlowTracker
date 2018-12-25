package ca.rovbot.flowtracker.viewmodel

import android.arch.lifecycle.ViewModel;
import android.content.Context.MODE_PRIVATE
import android.content.Context
import ca.rovbot.flowtracker.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class RegistrationViewModel : ViewModel() {

    fun registerUser(lastPeriodDate:String,numberOfDays:String,ctx: Context) {
        val editor = ctx.getSharedPreferences(R.string.sharedpreferencename.toString(), MODE_PRIVATE).edit()
        editor.putString("date", lastPeriodDate)
        editor.putString("freq",numberOfDays)
        editor.apply()
    }

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


    fun checkSelectedDateValid(context: Context?,selectedCalendarDate:String):String {
        val editor = context!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)
        val formatter: DateFormat
        var date: Date
        formatter = SimpleDateFormat("dd-MM-yyyy")
        date = formatter.parse(selectedCalendarDate)
        var currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
        var currentDay: Date
        currentDay = formatter.parse(currentDate)
        val v = daysBetween(date,currentDay)
        return v.toString();
    }


    fun daysBetween(d1: Date, d2: Date): Long {
        return ((d2.time - d1.time) / (1000 * 60 * 60 * 24)) as Long
    }

    // TODO: Implement the ViewModel
}
