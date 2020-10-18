package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_start.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class StartFragment : Fragment() {

    private val portalCollection = PortalCollection(arrayListOf<Portal>())
    private val portalAdapter = PortalAdapter(portalCollection.portals)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvPortal.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rvPortal.adapter = portalAdapter;

        fab.setOnClickListener{

            var args = Bundle()
            args.putParcelable("PortalCollection", portalCollection)

            findNavController().navigate(R.id.action_StartFragment_to_AddPortalFragment, args)
        }
    }
}