package ca.rovbot.flowtracker.viewmodel

import android.arch.lifecycle.ViewModel;
import android.content.Context.MODE_PRIVATE
import android.R.id.edit
import android.content.Context
import android.content.SharedPreferences
import ca.rovbot.flowtracker.R


class RegistrationViewModel : ViewModel() {

    fun registerUser(lastPeriodDate:String,numberOfDays:String,ctx: Context) {
        val editor = ctx.getSharedPreferences(R.string.sharedpreferencename.toString(), MODE_PRIVATE).edit()
        editor.putString("date", lastPeriodDate)
        editor.putString("freq",numberOfDays)
        editor.apply()
    }
    // TODO: Implement the ViewModel
}
