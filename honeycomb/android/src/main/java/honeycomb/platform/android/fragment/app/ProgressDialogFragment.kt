package honeycomb.platform.android.fragment.app

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import honeycomb.android.databinding.ViewDialogProgressBinding
import honeycomb.platform.android.lifecycle.getViewModel


class ProgressDialogFragment : DialogFragment() {

    private lateinit var _binding: ViewDialogProgressBinding
    private lateinit var _viewModel: ProgressDialogViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        _viewModel = activity!!.getViewModel()
        _binding.viewModel = _viewModel
        _binding.executePendingBindings()

        _viewModel.isVisible.observe(this, Observer {
            if (it)
                return@Observer
            dismiss()
        })
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        DialogFragmentService.removeTitleOnCreateDialog(dialog)
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return activity?.let {
            _binding = ViewDialogProgressBinding.inflate(inflater)
            _binding.lifecycleOwner = this
            _binding.root
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onResume() {
        super.onResume()
        DialogFragmentService.preventUserCancellationOnResume(this)
    }

    companion object {
        private const val FRAGMENT_TAG =
            "honeycomb.platform.android.fragment.app.ProgressDialogFragment"

        fun present(fragmentManager: FragmentManager): ProgressDialogFragment {
            val fragment = ProgressDialogFragment()
            fragment.show(fragmentManager, FRAGMENT_TAG)
            return fragment
        }
    }
}
