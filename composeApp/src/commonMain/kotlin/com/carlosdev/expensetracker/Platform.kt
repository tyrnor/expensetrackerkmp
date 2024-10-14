package com.carlosdev.expensetracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform