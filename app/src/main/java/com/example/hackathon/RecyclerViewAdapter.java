package com.example.hackathon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<RecyclerViewData> mData = null ;
    Context context;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    RecyclerViewAdapter(ArrayList<RecyclerViewData> list) {
        mData = list ;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.recycler_view_item_main, parent, false) ;
        RecyclerViewAdapter.ViewHolder vh = new RecyclerViewAdapter.ViewHolder(view) ;

        return vh;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, final int position) {

        RecyclerViewData item = mData.get(position) ;

        holder.recyclerViewUserProfileImage.setImageBitmap(item.getUserImage());
        holder.recyclerViewUserProfileNickName.setText(item.getUserNickName());
        holder.recyclerViewUserThumbnail.setImageBitmap(item.getYouTubeThumbnail());
        holder.recyclerViewCountLike.setText(item.getCountLike());
        holder.recyclerViewCountView.setText(item.getCountView());
        holder.recyclerViewContents.setText(item.getContents());



        final RecyclerViewAdapter.ViewHolder buttonHolder = (RecyclerViewAdapter.ViewHolder)holder;

        buttonHolder.recyclerViewLikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countLike = "ㅁㄴㅇㅁㄴㅇ";
                mData.get(position).setCountLike(countLike);
                notifyDataSetChanged();
            }
        });



    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView recyclerViewUserProfileImage;
        TextView recyclerViewUserProfileNickName;
        ImageView recyclerViewUserThumbnail;
        ImageView recyclerViewLikeBtn;
        TextView recyclerViewCountLike;
        TextView recyclerViewCountView;
        TextView recyclerViewContents;




        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)

            recyclerViewUserProfileImage = itemView.findViewById(R.id.recyclerViewUserProfileImage);
            recyclerViewUserProfileNickName = itemView.findViewById(R.id.recyclerViewUserProfileNickName);
            recyclerViewUserThumbnail = itemView.findViewById(R.id.recyclerViewUserThumbnail);
            recyclerViewLikeBtn = itemView.findViewById(R.id.recyclerViewLikeBtn);
            recyclerViewCountLike = itemView.findViewById(R.id.recyclerViewCountLike);
            recyclerViewCountView = itemView.findViewById(R.id.recyclerViewCountView);
            recyclerViewContents = itemView.findViewById(R.id.recyclerViewContents);




        }
    }


}