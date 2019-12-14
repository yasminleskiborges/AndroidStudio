package br.com.applista;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LineHolder extends RecyclerView.ViewHolder {
    TextView nome;
    ImageButton btnAdd;
    ImageButton btnDel;

    public LineHolder(@NonNull View itemView) {
        super(itemView);
        nome = itemView.findViewById(R.id.nome);
        btnAdd = itemView.findViewById(R.id.btnAdd);
        btnDel = itemView.findViewById(R.id.btnDel);
    }
}
