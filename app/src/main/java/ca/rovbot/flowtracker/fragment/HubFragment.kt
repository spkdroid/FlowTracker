package ca.rovbot.flowtracker.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import ca.rovbot.flowtracker.viewmodel.HubViewModel
import ca.rovbot.flowtracker.R
import kotlinx.android.synthetic.main.hub_fragment.*

class HubFragment : Fragment() {

    companion object {
        fun newInstance() = HubFragment()
    }

    private lateinit var viewModel: HubViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.hub_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HubViewModel::class.java)
        // TODO: Use the ViewModel

        val dayscount = viewModel.getDayCount(context)
        val progresBarResult = viewModel.getCurrentProgress(dayscount,context)

        circularProgressBar.setPercentage((progresBarResult.toInt()*3.5).toInt())
        circularProgressBar.setStepCountText(dayscount);

        if(progresBarResult<39){
            messagecontent.setText(R.string.lesswarningmessage)
        } else if(progresBarResult>39 && progresBarResult < 65) {
            messagecontent.setText(R.string.highwarningmessage)
        } else if(progresBarResult>39 && progresBarResult < 65) {
            messagecontent.setText(R.string.ovulationmessage)
        } else {
            messagecontent.setText(R.string.lesswarningmessage)
        }

        logperiod.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_hubFragment_to_logDateFragment)
        }
        calendarbutton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_hubFragment_to_calendarFragment)
        }
         chatbutton.setOnClickListener {
         Toast.makeText(it.context,"Chat Support not enabled",Toast.LENGTH_LONG).show()
         //   Navigation.findNavController(it).navigate(R.id.action_hubFragment_to_chatBotFragment)
        }
    }
}
