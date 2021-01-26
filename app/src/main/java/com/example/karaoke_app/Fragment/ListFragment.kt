package com.example.karaoke_app.Fragment

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.karaoke_app.Adaptertheloai.Adptertbaihat
import com.example.karaoke_app.Interface.OncTopClickListner
import com.example.karaoke_app.MainActivity
import com.example.karaoke_app.R
import com.example.karaoke_app.entity.User
import com.example.karaoke_app.top100.adapter100
import com.example.karaoke_app.top100.top100
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_list.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment(), OncTopClickListner {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val arrtop100 = ArrayList<top100>()
        arrtop100.add(top100(R.drawable.cachmang100, "TOP 100 nhạc cách mạng") )
        arrtop100.add(top100(R.drawable.dancer100,"TOP 100 nhạc dancer"))
        arrtop100.add(top100(R.drawable.nhactrinh100,"TOP 100 nhạc trịnh"))
        arrtop100.add(top100(R.drawable.quehuong100,"TOP 100 nhạc quê hương"))
        arrtop100.add(top100(R.drawable.rap100,"TOP 100 nhạc rap"))
        arrtop100.add(top100(R.drawable.rock100,"TOP 100 nhạc rock"))
        arrtop100.add(top100(R.drawable.thieunhi100,"TOP 100 nhạc thiếu nhi"))
        arrtop100.add(top100(R.drawable.vpop100,"TOP 100 nhạc v Pop"))
        list100.adapter = adapter100(arrtop100, this)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        list100.layoutManager = staggeredGridLayoutManager
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun OnTopClick(item: top100, position: Int) {
         var intent = Intent(activity,MainActivity::class.java)
        startActivity(intent)
    }
}