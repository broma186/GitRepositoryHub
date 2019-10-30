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



class RepositoriesAdapter: ListAdapter<Repository, RepositoriesAdapter.RepositoryViewHolder>(ProductDiffCallback()) {

   /* fun setData(newData: List<Repository>) {
        this.repositories = newData
        notifyDataSetChanged()
    }
*/
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

    class RepositoryViewHolder(
        private val binding: ListItemRepositoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: Repository) {
            with(binding) {
                viewModel = RepositoryViewModel(repository)
                executePendingBindings()
            }
        }
    }

    private class ProductDiffCallback : DiffUtil.ItemCallback<Repository>() {

        override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            return oldItem.name == newItem.name
        }
    }

}