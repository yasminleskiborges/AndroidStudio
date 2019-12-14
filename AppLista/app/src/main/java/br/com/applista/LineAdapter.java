package br.com.applista;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {

    ArrayList<MaterialModel> listaMateriais;

    public LineAdapter(){
        listaMateriais = new ArrayList<MaterialModel>();
    }

    @NonNull
    @Override
    public LineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_linha, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LineHolder holder, int position) {
        holder.nome.setText(String.format(listaMateriais.get(position).getNome()));
    }

    @Override
    public int getItemCount() {
        return listaMateriais.size();
    }

    private void updateItem(int position){
        MaterialModel m = listaMateriais.get(position);
        notifyItemChanged(position);
    }

    private void insertItem(MaterialModel material){
        listaMateriais.add(material);
        notifyItemInserted(listaMateriais.indexOf(material));
    }

    public void insertItem(String nome){
        MaterialModel m = new MaterialModel();
        m.setNome(nome);

        insertItem(m);
    }
}
