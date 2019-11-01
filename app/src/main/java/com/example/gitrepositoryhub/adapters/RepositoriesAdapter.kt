package com.example.gitrepositoryhub.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gitrepositoryhub.R
import com.example.gitrepositoryhub.data.Repository
import com.example.gitrepositoryhub.databinding.ListItemRepositoryBinding
import com.example.gitrepositoryhub.viewmodels.RepositoryViewModel
import android.R.attr.data


/*
Displays the list of repositories using data binding. This is the adapter for the recycler view found
in the Repositories Activity.
 */
class RepositoriesAdapter: ListAdapter<Repository, RepositoriesAdapter.RepositoryViewHolder>(ProductDiffCallback()) {

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
       return RepositoryViewHolder(
           DataBindingUtil.inflate(
               LayoutInflater.from(parent.context),
               R.layout.list_item_repository, parent, false
           )
       )
   }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        getItem(position).let { repositories ->
            with(holder) {
                bind(repositories)
            }
        }
    }

    /*
    View Holder binds to the list_item_repository file and displays the RepositoriesViewModel values.
    The onClickListener data variable in the xml is set here, it opens the selected git repository via
    the chosen browser.
     */
    class RepositoryViewHolder(
        private val binding: ListItemRepositoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener { view ->
                binding.viewModel?.openGitRepository(binding.root.context)
            }
        }

        fun bind(repository: Repository) {
            with(binding) {
                viewModel = RepositoryViewModel(repository)
                executePendingBindings()
            }
        }
    }

    // Make sure there are no duplicated items in the returned list.
    private class ProductDiffCallback : DiffUtil.ItemCallback<Repository>() {

        override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            return oldItem.name == newItem.name
        }
    }
}