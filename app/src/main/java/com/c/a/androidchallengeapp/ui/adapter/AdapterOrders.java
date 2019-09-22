package com.c.a.androidchallengeapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.c.a.androidchallengeapp.R;
import com.c.a.androidchallengeapp.databinding.ItemRecvOrdersBinding;
import com.c.a.androidchallengeapp.model.ModelOrders;


public class AdapterOrders extends ListAdapter<ModelOrders, AdapterOrders.ViewHolder> {

    public AdapterOrders() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recv_orders, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ModelOrders modelOrders = getItem(position);
        viewHolder.binding.setVariable(com.c.a.androidchallengeapp.BR.modelOrders, modelOrders);
        viewHolder.binding.executePendingBindings();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemRecvOrdersBinding binding;

        ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

            itemView.setOnClickListener(v -> {
                ModelOrders modelOrders = getItem(getAdapterPosition());
                modelOrders.setExpand(!modelOrders.isExpand());//expand ise collapse yap, collapse expand yap
                binding.setVariable(com.c.a.androidchallengeapp.BR.modelOrders, modelOrders);//güncelle
                binding.executePendingBindings();
            });
        }
    }

    private static final DiffUtil.ItemCallback<ModelOrders> DIFF_CALLBACK = new DiffUtil.ItemCallback<ModelOrders>() {//içerik değiştiği zaman güncellenecek. Listeler arası fark kontol ediliyor
        @Override
        public boolean areItemsTheSame(ModelOrders oldItem, ModelOrders newItem) {//Her siparişin unique kod bilgisi bulunmadığı için, market, sipariş adları ve tarih aynı ise aynı item olarak varsayıldı.
            return oldItem.getOrderName().equals(newItem.getOrderName()) &&
                    oldItem.getMarketName().equals(newItem.getMarketName()) &&
                    oldItem.getDate().equals(newItem.getDate()) &&
                    oldItem.getMonth().equals(newItem.getMonth());
        }

        @Override
        public boolean areContentsTheSame(ModelOrders oldItem, ModelOrders newItem) {
            return oldItem.getOrderName().equals(newItem.getOrderName()) &&
                    oldItem.getMarketName().equals(newItem.getMarketName()) &&
                    oldItem.getDate().equals(newItem.getDate()) &&
                    oldItem.getMonth().equals(newItem.getMonth());
        }
    };
}
