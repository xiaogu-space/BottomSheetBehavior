package com.bottom.sample;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import co.com.parsoniisolutions.custombottomsheetbehavior.R;

/**
 * Created by xiaogu on 2017/12/13.
 */
public class Adapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public Adapter() {
        super(R.layout.item);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv, item);
    }
}
