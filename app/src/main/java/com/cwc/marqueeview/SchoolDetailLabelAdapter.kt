package cn.mucang.android.mars.student.refactor.business.school.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.cwc.marqueeview.MarsStudentBaseRecyclerViewAdapter
import com.cwc.marqueeview.R
/**
 *@author Cuiweicong 2017/9/14
 */
class SchoolDetailLabelAdapter(list: List<String>, context: Context): MarsStudentBaseRecyclerViewAdapter() {
    val list = list
    val context = context

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.school_detail_label_item, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val myViewHolder = holder as MyViewHolder
        myViewHolder.tv.text = list[position]
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val iv = itemView.findViewById(R.id.iv) as ImageView
        val tv = itemView.findViewById(R.id.tv) as TextView
    }

}