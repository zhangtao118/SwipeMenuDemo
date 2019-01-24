package com.example.admin.swipemenudemo;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class QuickAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public QuickAdapter(@Nullable List data) {
        super(R.layout.item_swipe_menu, data );
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
            helper.setText( R.id.tv_content,"第"+item+"条数据" );
            helper.addOnClickListener( R.id.tv_delete );
    }
}
