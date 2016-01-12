package com.bitdubai.fermat_dap_android_sub_app_asset_user_community_bitdubai.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import com.bitdubai.fermat_android_api.ui.adapters.FermatAdapter;
import com.bitdubai.fermat_dap_android_sub_app_asset_user_community_bitdubai.R;
import com.bitdubai.fermat_dap_android_sub_app_asset_user_community_bitdubai.holders.GroupViewHolder;
import com.bitdubai.fermat_dap_android_sub_app_asset_user_community_bitdubai.interfaces.AdapterChangeListener;
import com.bitdubai.fermat_dap_android_sub_app_asset_user_community_bitdubai.models.Group;
import com.bitdubai.fermat_dap_api.layer.all_definition.enums.DAPConnectionState;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GroupCommunityAdapter extends FermatAdapter<Group, GroupViewHolder> {

    private AdapterChangeListener<Group> adapterChangeListener;

    public GroupCommunityAdapter(Context context) {
        super(context);
    }

    public GroupCommunityAdapter(Context context, List<Group> dataSet) {
        super(context, dataSet);
    }

    @Override
    protected GroupViewHolder createHolder(View itemView, int type) {
        return new GroupViewHolder(itemView);
    }

    @Override
    protected int getCardViewResource() {
        return R.layout.row_group;
    }

    @Override
    protected void bindHolder(final GroupViewHolder holder, final Group data, final int position) {
        try {
            if (data.getGroupName() != null) {
                holder.groupName.setText(String.format("%s", data.getGroupName()));
            }

        Picasso.with(context).load(R.drawable.profile_image_standard).into(holder.thumbnail);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setAdapterChangeListener(AdapterChangeListener<Group> adapterChangeListener) {
        this.adapterChangeListener = adapterChangeListener;
    }

    public int getSize() {
        if (dataSet != null)
            return dataSet.size();
        return 0;
    }
}
