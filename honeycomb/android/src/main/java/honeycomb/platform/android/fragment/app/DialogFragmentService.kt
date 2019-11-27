package honeycomb.platform.android.fragment.app

import android.app.Dialog
import android.view.Window
import androidx.fragment.app.DialogFragment

class DialogFragmentService {
    companion object {
        fun preventUserCancellationOnResume(fragment: DialogFragment) {
            fragment.isCancelable = false
            fragment.dialog?.let {
                it.setCancelable(false)
                it.setCanceledOnTouchOutside(false)
            }
        }

        fun removeTitleOnCreateDialog(dialog: Dialog) {
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        }
    }
}
