package com.example.viaceptestapplication;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class EnderecoAdapter extends RecyclerView.Adapter<EnderecoAdapter.EnderecoViewHolder>  {

    private ArrayList<Endereco> enderecoList = new ArrayList<>();
    private LayoutInflater inflater;

    public EnderecoAdapter(Context context, ArrayList<Endereco> enderecoList){
        inflater = LayoutInflater.from(context);
        this.enderecoList=enderecoList;

    }
    @NonNull
    @Override
    public EnderecoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EnderecoViewHolder(inflater.inflate(android.R.layout.simple_list_item_1, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EnderecoViewHolder holder, int position) {
        Endereco endereco = enderecoList.get(position);
        TextView tvEndereco = (TextView) holder.itemView;
        tvEndereco.setText(endereco.toString());

    }

    @Override
    public int getItemCount() {
        return enderecoList.size();
    }
    public static class EnderecoViewHolder extends RecyclerView.ViewHolder{

        public EnderecoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
