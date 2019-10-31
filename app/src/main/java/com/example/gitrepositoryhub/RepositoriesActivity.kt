package com.example.gitrepositoryhub

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gitrepositoryhub.adapters.RepositoriesAdapter
import com.example.gitrepositoryhub.databinding.ActivityRepositoriesBinding
import com.example.gitrepositoryhub.viewmodels.RepositoriesViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class RepositoriesActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    val context: Context = this
    lateinit var binding: ActivityRepositoriesBinding
    private lateinit var adapter: RepositoriesAdapter

    private lateinit var repositoriesViewModel : RepositoriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityRepositoriesBinding>(this, R.layout.activity_repositories)
        setSupportActionBar(binding.toolbar)

        repositoriesViewModel = ViewModelProviders.of(this, viewModelFactory)[RepositoriesViewModel::class.java]

        setupRepositoriesList()

        observeList()
    }

    /*
      Utilizes live data to Observe any changes in the database which then refreshes the list of repositories
      that are displayed in the recycler view. Will indicate there are no products with a textview if
      no repositories are returned in the result variable.
   */
    fun observeList() {
        repositoriesViewModel.repositoryLiveData.observe(this, Observer {
                result ->
            if (!result.isNullOrEmpty()) {
                binding.noRepositories.visibility = View.GONE
            }
            adapter.submitList(result)
        })
    }

    fun setupRepositoriesList() {
        binding.repositoryList.layoutManager = LinearLayoutManager(this)
        adapter = RepositoriesAdapter()
        binding.repositoryList.adapter = adapter
    }
}
