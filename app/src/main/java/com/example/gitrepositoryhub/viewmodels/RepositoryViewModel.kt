package com.example.gitrepositoryhub.viewmodels

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.example.gitrepositoryhub.data.Repository

class RepositoryViewModel(repository: Repository) : ViewModel(){

    private val repository = checkNotNull(repository)

    val id
        get() = repository.id

    val name
        get() = repository.name

    val description
        get() = repository.description

    val htmlUrl
        get() = repository.html_url

    val avatarUrl
        get() = repository.owner?.avatar_url

    fun openGitRepository(context: Context) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(htmlUrl)
        ContextCompat.startActivity(context, i, null)
    }

}