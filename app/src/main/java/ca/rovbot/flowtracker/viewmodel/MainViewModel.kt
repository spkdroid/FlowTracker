package ca.rovbot.flowtracker.viewmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import ca.rovbot.flowtracker.R
import ca.rovbot.flowtracker.base.BaseViewModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel : BaseViewModel() {


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

}
