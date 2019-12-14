package br.com.listamateriais;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {
    private final List<MaterialModel> mMateriais;

    public LineAdapter(ArrayList materiais) {
        mMateriais = materiais;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_line_view, parent, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = "";
            }
        });
        return new LineHolder(view);
    }

    @Override
    public void onBindViewHolder(LineHolder holder, final int position) {
        holder.title.setText(String.format(Locale.getDefault(), "%s",
                mMateriais.get(position).getNome()
        ));

        holder.moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateItem(position);
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removerItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (mMateriais == null)
                ? 0 : mMateriais.size();
    }

    private void updateItem(int position) {
        MaterialModel materialModel = mMateriais.get(position);
        notifyItemChanged(position);
    }

    private void removerItem(int position) {
        mMateriais.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mMateriais.size());
    }

    private void insertItem(MaterialModel item) {
        mMateriais.add(item);
        notifyItemInserted(mMateriais.indexOf(item));
    }

    public void updateList(MaterialModel material) {
        insertItem(material);
    }

    public void updateList(String nome){
        MaterialModel m = new MaterialModel();
        m.setNome(nome);
        insertItem(m);
    }
}
