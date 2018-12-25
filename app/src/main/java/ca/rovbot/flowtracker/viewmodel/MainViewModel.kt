package ca.rovbot.flowtracker.viewmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import ca.rovbot.flowtracker.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

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

    fun checkIfCycleCompleted(context: Context?) {

        var editor = context!!.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE)

        val formatter: DateFormat
        var date: Date
        formatter = SimpleDateFormat("dd-MM-yyyy")
        date = formatter.parse(editor.getString("freq", "freq").toString())

        var currentDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
        var currentDay: Date
        currentDay = formatter.parse(currentDate)
        val v = daysBetween(date,currentDay).toString()

        val dayCount = editor.getString("date","date").toString()
        if(Integer.parseInt(v) == Integer.parseInt(dayCount))
        {
            val editor = context.getSharedPreferences(R.string.sharedpreferencename.toString(), Context.MODE_PRIVATE).edit()
            editor.putString("freq",currentDate)
            editor.commit()
        }

    }

    fun daysBetween(d1: Date, d2: Date): Long {
        return ((d2.time - d1.time) / (1000 * 60 * 60 * 24)) as Long
    }


    // TODO: Implement the ViewModel
}
