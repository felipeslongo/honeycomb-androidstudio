package com.example.honeycomb.ui.buttons

import kotlinx.coroutines.delay

class CheckInCheckOutController {
    suspend fun checkInSuspendable() {
        delay(1000)
    }

    suspend fun checkOutSuspendable() {
        delay(1000)
    }

    suspend fun getCheckedInStateSuspendable(): Boolean {
        delay(1000)
        return false
    }

    companion object {
        fun Create () : CheckInCheckOutController {
            return CheckInCheckOutController()
        }
    }
}