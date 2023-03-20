package com.example.authme2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.authme2.adapter.InOfficeAdapter
import com.example.authme2.model.ActiveUsersResponse
import com.example.authme2.model.User
import com.example.authme2.viewModel.GetActiveUsersViewModel


class InOffice : Fragment() {

    var activeUsersResponse: List<User> = arrayListOf()
    lateinit var mRecycler: RecyclerView
    lateinit var mAdapter: InOfficeAdapter

    private val mViewModel: GetActiveUsersViewModel = GetActiveUsersViewModel()

    companion object {

        fun newInstance(): InOffice {
            return InOffice()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view =  inflater.inflate(R.layout.activity_in_office, container, false)
        mRecycler = view.findViewById(R.id.recycler_new)
        mRecycler.layoutManager = LinearLayoutManager(activity)

        var list = ArrayList<User>()
        list.add(User("Ori", 35, "elior@gmail.com"))
        list.add(User("Matan", 35, "matan@gmail.com"))
        list.add(User("Ori", 35, "elior@gmail.com"))
        list.add(User("Matan", 35, "matan@gmail.com"))
        list.add(User("Ori", 35, "elior@gmail.com"))
        list.add(User("Matan", 35, "matan@gmail.com"))
        list.add(User("Ori", 35, "elior@gmail.com"))
        list.add(User("Matan", 35, "matan@gmail.com"))
        list.add(User("Ori", 35, "elior@gmail.com"))
        list.add(User("Matan", 35, "matan@gmail.com"))
        list.add(User("Ori", 35, "elior@gmail.com"))
        list.add(User("Matan", 35, "matan@gmail.com"))

        val activeUsersList = addImagesToUsers(list)
        mAdapter = InOfficeAdapter(activeUsersList)
        mRecycler.adapter = mAdapter

        mViewModel.getActiveUsers()
        val observer = Observer<ActiveUsersResponse> { item ->

            val activeUsersList = addImagesToUsers(item.activeUsers)
            mAdapter = InOfficeAdapter(activeUsersList)
            mRecycler.adapter = mAdapter
        }
        mViewModel.getActiveUsersLiveData()?.observe(requireActivity(), observer)
        return view
    }

    private fun addImagesToUsers(users: List<User>): List<User> {
        val PACKAGE_NAME: String? = context?.packageName

        val usersSize = users.size -1
        var index = 1
        for (i in 0..usersSize) {
            if(index == 5){
                index = 1
            }
            val res = resources.getIdentifier("picture" + index, "drawable", PACKAGE_NAME)
            users[i].pictureName = res
            index++
        }
        return users
    }
}
