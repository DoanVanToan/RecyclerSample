package com.framgia.toandoan;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.toandoan.databinding.ItemOptionBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by framgia on 29/03/2017.
 */
public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.ViewHolder> {
    private List<OptionItem> mOptions;
    private LayoutInflater mInflater;
    private OnAdapterClick mListenner;

    public OptionAdapter(OnAdapterClick listenner) {
        mOptions = new ArrayList<>();
        mOptions.add(new OptionItem(0, null, null));
        mOptions.add(new OptionItem(1, null, null));
        mOptions.add(new OptionItem(2, null, null));
        mOptions.add(new OptionItem(3, null, null));
        mListenner = listenner;
    }

    @Override
    public OptionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (null == mInflater) mInflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(mInflater.inflate(R.layout.item_option, parent, false));
    }

    @Override
    public void onBindViewHolder(OptionAdapter.ViewHolder holder, int position) {
        OptionItem optionItem = mOptions.get(position);
        holder.bindData(optionItem);
    }

    @Override
    public int getItemCount() {
        return mOptions != null ? mOptions.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemOptionBinding mBinding;

        public ViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        public void bindData(OptionItem item) {
            mBinding.setHanlder(OptionAdapter.this);
            mBinding.setOption(item);
            mBinding.setPos(getAdapterPosition());
            mBinding.executePendingBindings();
        }
    }

    public void onAddImageClicked(OptionItem item) {
        mListenner.onAddImage(item);
    }

    public void onDeleteImageClicked(OptionItem item) {
        item.setUrl(null);
    }

    public void onDeleteOptionClick(int position) {
        if (position == getItemCount() && getItemCount() == 1) return;
        mOptions.remove(position);
        notifyItemRemoved(position);
    }

    public void onAddNewOption(int position) {
        if (position != mOptions.size() - 1) return;
        mOptions.add(new OptionItem(0, null, null));
        notifyItemInserted(position + 1);
    }

    public interface OnAdapterClick {
        void onAddImage(OptionItem item);
    }
}
