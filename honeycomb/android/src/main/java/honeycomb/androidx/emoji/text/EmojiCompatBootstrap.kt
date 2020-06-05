package honeycomb.androidx.emoji.text


import android.content.Context
import android.util.Log
import androidx.core.provider.FontRequest
import androidx.emoji.text.EmojiCompat
import androidx.emoji.text.FontRequestEmojiCompatConfig
import honeycomb.android.R
import honeycomb.kotlin.wrapWithException
import kotlinx.coroutines.*
import kotlin.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class EmojiCompatBootstrap {

    companion object {

        private val TAG = "EmojiCompatBootstrap"
    }

    suspend fun bootstrapAsync(context: Context) = suspendCancellableCoroutine<Unit> { coroutine ->
        val fontRequest = createEmojiFontRequest()
        val config = FontRequestEmojiCompatConfig(context, fontRequest)
        val emojiCallback = createFontRequestEmojiCompatConfigInitCallback(coroutine, config)
        config.registerInitCallback(emojiCallback)
        EmojiCompat.init(config)
    }

    private fun createEmojiFontRequest() = FontRequest(
        "com.google.android.gms.fonts",
        "com.google.android.gms",
        "Noto Color Emoji Compat",
        R.array.com_google_android_gms_fonts_certs
    )

    private fun createFontRequestEmojiCompatConfigInitCallback(
        coroutine: CancellableContinuation<Unit>,
        config: FontRequestEmojiCompatConfig) = object : EmojiCompat.InitCallback() {

        override fun onInitialized() {
            super.onInitialized()
            Log.i(TAG, "EmojiCompat initialized");
            coroutine.resume(Unit)
            config.unregisterInitCallback(this)
        }

        override fun onFailed(throwable: Throwable?) {
            super.onFailed(throwable)
            Log.i(TAG, "EmojiCompat Initialization Failed");
            val exception = throwable?.wrapWithException()
                ?: Exception("EmojiCompat Initialization Failed")
            coroutine.resumeWithException(exception)
            config.unregisterInitCallback(this)
        }
    }
}