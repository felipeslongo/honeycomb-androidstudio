package com.example.honeycomb.ui.buttons

import kotlinx.coroutines.delay

class CheckInCheckOutController {
    suspend fun checkInSuspendable() : Boolean {
        delay(1000)
        return true
    }

    suspend fun checkOutSuspendable() : Boolean {
        delay(1000)
        return false
    }

    companion object {
        fun Create () : CheckInCheckOutController {
            return CheckInCheckOutController()
        }
    }
}