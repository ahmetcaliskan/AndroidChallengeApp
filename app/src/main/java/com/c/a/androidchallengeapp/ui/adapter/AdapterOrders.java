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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ModelOrders modelOrders = getItem(i);
        viewHolder.binding.setVariable(com.c.a.androidchallengeapp.BR.modelOrders, modelOrders);
        viewHolder.binding.executePendingBindings();

//        if (modelOrders.isExpand()) {//scroll anında son durumu korumak için
//            viewHolder.binding.expandableLayout.expand();
//            modelOrders.setExpand(true);
//        } else {
//            viewHolder.binding.expandableLayout.collapse();
//            modelOrders.setExpand(false);
//        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemRecvOrdersBinding binding;

        ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

            itemView.setOnClickListener(v -> {
                binding.expandableLayout.toggle();
//                ModelOrders modelOrders = getItem(getAdapterPosition());
//                if (modelOrders.isExpand()) {
//                    binding.expandableLayout.collapse();
//                    modelOrders.setExpand(false);
//                } else {
//                    binding.expandableLayout.expand();
//                    modelOrders.setExpand(true);
//                }
            });
        }
    }

    private static final DiffUtil.ItemCallback<ModelOrders> DIFF_CALLBACK = new DiffUtil.ItemCallback<ModelOrders>() {
        @Override
        public boolean areItemsTheSame(ModelOrders oldItem, ModelOrders newItem) {
            return oldItem.getOrderName().equals(newItem.getOrderName()) &&
                    oldItem.getMarketName().equals(newItem.getMarketName());
        }

        @Override
        public boolean areContentsTheSame(ModelOrders oldItem, ModelOrders newItem) {
            return oldItem.getOrderName().equals(newItem.getOrderName()) &&
                    oldItem.getMarketName().equals(newItem.getMarketName());
        }
    };
}
