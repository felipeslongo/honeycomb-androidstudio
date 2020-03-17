package honeycomb.android.ui.dataBindings

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

/**
 * Provides Factory like conveniences methods
 * for building an View class with its data binding.
 * @param TViewDataBinding Data Binding class
 * @param TView View output class
 */
class ViewFactory<TViewDataBinding, TView>(
    private val rootViewId: Int,
    private val dataBinderAction: (binding: TViewDataBinding) -> TView
)
        where TViewDataBinding : ViewDataBinding {

    fun createFromActivity(activity: AppCompatActivity): TView =
        createFromActivity(activity, rootViewId)

    fun createFromActivity(activity: AppCompatActivity, id: Int): TView {
        val binding = createBinding(activity.findViewById(id))
        return createFromBinding(binding, activity)
    }

    fun createFromBinding(binding: TViewDataBinding, lifecycleOwner: LifecycleOwner): TView {
        binding.lifecycleOwner = lifecycleOwner
        return dataBinderAction(binding)
    }

    fun createFromFragment(fragment: Fragment): TView =
        createFromFragment(fragment, rootViewId)

    fun createFromFragment(fragment: Fragment, id: Int): TView {
        val binding = createBinding(fragment.view!!.findViewById(id))
        return createFromBinding(binding, fragment)
    }

    private fun createBinding(root: View): TViewDataBinding {
        return DataBindingUtil.bind(root)!!
    }
}
