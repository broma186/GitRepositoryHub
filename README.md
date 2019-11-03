# GitRepositoryHub
A Git repository that downloads Git repositories and displays them.

This application is written using MVVM app architecture. Data binding support is enabled for the activity and the adapter that
displays the list item. I was able to separate the view logic away from interactions with the model layer.

Dagger is used throughout for dependency injection. The app is separated into modules for the network, view models, and repositories.
Currently the app doesn't implement Room but the database/dao and repository methods can be added to the RepositoryRepositry when needed.
This was left open for the app to be extendable.

The ViewModelFactory needed to inject to create & inject the view models is injected in the main repository activity.
When the view model is instantiated, the repositories are downloaded by the data repository service and assigned to a livedata instance.
Once this occurs, the livedata instance is observed in the activity and the ListAdapter for the repository items is updated with the new data. This only happens once during the app running as the call is inside the init method of the RepositoriesViewModel.

In traditional apps you might want to poll the server every once in a while to keep data up to date. However in this case I've used a one-shot coroutine running on the IO thread.

Libraries/Dependencies:

VIEW
- Data Binding
- Recycler View 
- List Adapter
- Glide
- Material UI

VIEWMODEL
- View Models
- LiveData
- Coroutines

MODEL

- Room - Not fully implemented as wasn't deemed necessary.
- Retrofit 2
- Moshi converter


