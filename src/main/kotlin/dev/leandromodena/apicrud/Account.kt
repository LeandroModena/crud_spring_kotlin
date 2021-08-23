package dev.leandromodena.apicrud

data class Account(
    val id: String? = null,
    val name: String,
    val document: String? = null,
    val balance: Long? = 0
)
