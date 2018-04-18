package com.example.akbar.book_ing;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Akbar on 4/14/2018.
 */
public class MyAdapter extends ArrayAdapter<Book> {


    public MyAdapter(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.row_layout, parent, false);
        }

        TextView author1=convertView.findViewById(R.id.author1);
        TextView name1=convertView.findViewById(R.id.name1);
        TextView price1=convertView.findViewById(R.id.price1);
        Book ob=getItem(position);
        author1.setText(ob.getAuthorName());
        name1.setText(ob.getBookName());
        price1.setText(ob.getBookPrice());
        return convertView;
    }
}
