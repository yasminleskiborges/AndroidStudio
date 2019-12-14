package br.com.listamateriais;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import br.com.listamateriais.R;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public ImageButton moreButton;
    public ImageButton deleteButton;

    public LineHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.main_line_title);
        moreButton = (ImageButton) itemView.findViewById(R.id.main_line_more);
        deleteButton = (ImageButton) itemView.findViewById(R.id.main_line_delete);

        View.OnClickListener a =  (View.OnClickListener) itemView.getContext();
    }
}