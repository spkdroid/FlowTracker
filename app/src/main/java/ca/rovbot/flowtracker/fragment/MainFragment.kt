package ca.rovbot.flowtracker.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.Navigation
import ca.rovbot.flowtracker.R
import ca.rovbot.flowtracker.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
         splashicon.startAnimation(AnimationUtils.loadAnimation(context,R.anim.rotation_anim))
         startbutton.setOnClickListener {

             if(viewModel.validateUser(this.context)) {
                 Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_registrationFragment)
             } else {
                 Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_hubFragment)
             }
         }
    }

}
