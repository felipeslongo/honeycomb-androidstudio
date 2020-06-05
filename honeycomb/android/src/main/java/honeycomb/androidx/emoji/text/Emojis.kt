package honeycomb.androidx.emoji.text

import androidx.emoji.text.EmojiCompat

enum class Emojis(name: String, value: CharSequence) {
    NEUTRAL_FACE("neutral face", EmojiCompat.get().process("\uD83D\uDE10"))
}