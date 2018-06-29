package com.example.android.jornalapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.jornalapp.model.Note;

import java.util.List;

/**
 * Created by USER on 6/29/2018.
 */

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.ViewHolder> {
    Context context;
    List<Note> noteList;


    public JournalAdapter(Context context, List<Note> noteList) {
        this.context = context;
        this.noteList = noteList;
    }



    @Override
    public int getItemCount() {

        return noteList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Note studentDetails = noteList.get(position);

        holder.noteTitle.setText(studentDetails.getNoteTitle());

        holder.noteDate.setText(studentDetails.getDate());

    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }






    // Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView noteTitle;
        public TextView noteDate;
        public View layout;
        public ViewHolder(View v) {
            super(v);
            layout = v;
            noteTitle =  v.findViewById(R.id.title_text);
            noteDate = v.findViewById(R.id.date_text);

        }
    }


}
