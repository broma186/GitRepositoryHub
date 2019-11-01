package com.example.gitrepositoryhub.data

/*
POJO for all repositories.
 */
data class Repository(
    val id: Int?,
    val name: String?,
    val description: String?,
    val html_url: String?,
    val owner: Owner?
)

data class Owner(
    val avatar_url: String?
)
