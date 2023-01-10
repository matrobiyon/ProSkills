package com.ru.week_1.view.adapter

import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.ru.week_1.R
import com.ru.week_1.model.MusicData

class MusicAdapter(
    private var list: List<MusicData>
) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {
    class MusicViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var title = view.findViewById<TextView>(R.id.text_item)
        var imageView =view.findViewById<ImageView>(R.id.image_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.music_item,parent,false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        var items = list[position]
        holder.title.text = items.title
        holder.imageView.setImageResource(items.musicPhoto)
    }

    override fun getItemCount(): Int = list.size
}

//Getting permission for Camera and External Storage
// self function
//private fun permission(context : Context){
//    Dexter.withContext(context).withPermissions(
//        Manifest.permission.CAMERA,
//        Manifest.permission.READ_EXTERNAL_STORAGE,
//        Manifest.permission.WRITE_EXTERNAL_STORAGE
//    ).withListener(object : MultiplePermissionsListener{
//        override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
//            if (report!!.areAllPermissionsGranted()){
//                Toast.makeText(context,"You have permission",Toast.LENGTH_SHORT).show()
//            }
//        }
//        override fun onPermissionRationaleShouldBeShown(
//            permisson: MutableList<PermissionRequest>?,
//            token: PermissionToken?
//        ) {
//            AlertDialog.Builder(context).setMessage("NO PERMISSONS")
//                .setPositiveButton("GO TO SETTINGS"){ dialog,_ ->
//                    Toast.makeText(context,"No permisson Positive Button",Toast.LENGTH_SHORT).show()
//                    dialog.dismiss()
//                }
//                .setNegativeButton("CANCEL"){
//                    dialog,_ ->
//                    Toast.makeText(context,"No permisson Negative Button",Toast.LENGTH_SHORT).show()
//                    dialog.dismiss()
//                }
//                .show()
//        }
//
//    }).onSameThread().check()
//}