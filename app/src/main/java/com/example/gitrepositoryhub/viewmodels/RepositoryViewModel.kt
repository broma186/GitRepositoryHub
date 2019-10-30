package com.example.gitrepositoryhub.viewmodels

import androidx.lifecycle.ViewModel
import com.example.gitrepositoryhub.data.Repository

class RepositoryViewModel(val repository: Repository) : ViewModel(){

    val id
        get() = repository.id

    val name
        get() = repository.name

    val description
        get() = repository.description
}