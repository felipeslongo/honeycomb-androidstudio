package com.example.honeycomb.ui.dataBindings
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * A simple VM for [com.example.android.databinding.basicsample.ui.PlainOldActivity].
 */
class AndroidDataBindingCodelabViewModel : ViewModel() {
    private val _name = MutableLiveData<String>().apply { value = "Felipe" }
    private val _lastName = MutableLiveData<String>().apply { value = "de Souza Longo" }
    private val _likes = MutableLiveData<Int>().apply { value = 0 }

    val name: LiveData<String> = _name
    val lastName: LiveData<String> = _lastName
    var likes: LiveData<Int> = _likes
        private set // This is to prevent external modification of the variable.

    /**
     * Increments the number of likes.
     */
    fun onLike() {
        _likes.value = (likes.value ?: 0) + 1
    }

    /**
     * Returns popularity in buckets: [Popularity.NORMAL], [Popularity.POPULAR] or [Popularity.STAR]
     */
    val popularity: LiveData<Popularity> = Transformations.map(_likes){
        when {
            it > 9 -> Popularity.STAR
            it > 4 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }
    }
}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}
