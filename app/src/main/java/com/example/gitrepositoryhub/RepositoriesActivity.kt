package com.example.gitrepositoryhub

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.example.gitrepositoryhub.adapters.RepositoriesAdapter
import com.example.gitrepositoryhub.data.Repository
import com.example.gitrepositoryhub.databinding.ActivityRepositoriesBinding
import com.example.gitrepositoryhub.api.RepositoryServiceUtilities
import com.example.gitrepositoryhub.utils.InjectorUtils
import com.example.gitrepositoryhub.viewmodels.RepositoriesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.toast
import retrofit2.HttpException
import retrofit2.Response

class RepositoriesActivity : AppCompatActivity() {

    lateinit var binding: ActivityRepositoriesBinding
    private lateinit var adapter: RepositoriesAdapter
    val context: Context = this
    var repositoriesViewModel : RepositoriesViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repositoriesViewModel = ViewModelProviders.of(this, InjectorUtils.
            provideRepositoriesViewModelFactory(context)).get(RepositoriesViewModel::class.java)

        binding = DataBindingUtil.setContentView<ActivityRepositoriesBinding>(this, R.layout.activity_repositories)
        setupRepositoriesList()
        observeList()

        setSupportActionBar(binding.toolbar)

    }

    /*
      Utilizes live data to Observe any changes in the database which then refreshes the list of repositories
      that are displayed in the recycler view. Will indicate there are no products with a textview if
      no repositories are returned in the result variable.
   */
    fun observeList() {
        repositoriesViewModel?.repositories?.observe(this, Observer {
                result ->
            adapter.submitList(result)
        })
    }

    fun setupRepositoriesList() {
        adapter = RepositoriesAdapter()
        binding.repositoryList.adapter = adapter
    }




}
