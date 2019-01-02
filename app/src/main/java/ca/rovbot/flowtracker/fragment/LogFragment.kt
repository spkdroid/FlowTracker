package ca.rovbot.flowtracker.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ca.rovbot.flowtracker.viewmodel.LogViewModel
import ca.rovbot.flowtracker.R


class LogFragment : Fragment() {

    companion object {
        fun newInstance() = LogFragment()
    }

    private lateinit var viewModel: LogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.log_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LogViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
