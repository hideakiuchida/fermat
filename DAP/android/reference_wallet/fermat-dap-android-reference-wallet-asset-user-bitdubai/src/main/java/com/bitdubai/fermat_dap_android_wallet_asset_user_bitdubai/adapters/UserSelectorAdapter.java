package com.bitdubai.fermat_dap_android_wallet_asset_user_bitdubai.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;

import com.bitdubai.fermat_android_api.layer.definition.wallet.FermatRoundedImageView;
import com.bitdubai.fermat_android_api.layer.definition.wallet.utils.ImagesUtils;
import com.bitdubai.fermat_android_api.layer.definition.wallet.views.FermatTextView;
import com.bitdubai.fermat_android_api.ui.adapters.FermatAdapter;
import com.bitdubai.fermat_dap_android_wallet_asset_user_bitdubai.R;
import com.bitdubai.fermat_dap_android_wallet_asset_user_bitdubai.filters.UserSelectorAdapterFilter;
import com.bitdubai.fermat_dap_android_wallet_asset_user_bitdubai.holders.AssetSellSelectUserHolder;
import com.bitdubai.fermat_dap_android_wallet_asset_user_bitdubai.models.User;
import com.bitdubai.fermat_dap_api.layer.dap_module.wallet_asset_user.interfaces.AssetUserWalletSubAppModuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jinmy Bohorqprivate void doSell(final String assetPublicKey, final User user, final long amountPerUnity, final long amountTotal, final int quantityToSell) {
 final ProgressDialog dialog = new ProgressDialog(activity);
 dialog.setMessage(getResources().getString(R.string.dap_user_wallet_wait));
 dialog.setCancelable(false);
 dialog.show();
 FermatWorker task = new FermatWorker() {
@Override
protected Object doInBackground() throws Exception {
moduleManager.startSell(user.getActorAssetUser(), amountPerUnity, amountTotal, quantityToSell, digitalAsset.getAssetPublicKey());
return true;
}
};

 task.setContext(activity);
 task.setCallBack(new FermatWorkerCallBack() {
@Override
public void onPostExecute(Object... result) {
dialog.dismiss();
if (activity != null) {
//                    refreshUIData();
Toast.makeText(activity, getResources().getString(R.string.dap_user_wallet_sell_ok), Toast.LENGTH_LONG).show();
changeActivity(Activities.DAP_WALLET_ASSET_USER_ASSET_DETAIL, appSession.getAppPublicKey());
}
}

@Override
public void onErrorOccurred(Exception ex) {
dialog.dismiss();
if (activity != null)
Toast.makeText(activity, getResources().getString(R.string.dap_user_wallet_exception_retry),
Toast.LENGTH_SHORT).show();
}
});
 task.execute();
 }uez on 17/03/16.
 */
public class UserSelectorAdapter  extends FermatAdapter<User, AssetSellSelectUserHolder>
implements Filterable{

    private AssetUserWalletSubAppModuleManager manager;

    public UserSelectorAdapter(Context context, List<User> users, AssetUserWalletSubAppModuleManager manager) {
        super(context, users);
        this.manager = manager;
        this.dataSet = users;
    }

    @Override
    protected AssetSellSelectUserHolder createHolder(View itemView, int type) {
        return new AssetSellSelectUserHolder(itemView, manager, context);
    }

    @Override
    protected int getCardViewResource() {
        return R.layout.dap_wallet_asset_user_asset_sell_select_users_item;
    }

    @Override
    protected void bindHolder(AssetSellSelectUserHolder holder, User data, int position) {
        holder.bind(data);
        if (data.isSelected()){
            holder.userLayout.setVisibility(View.VISIBLE);
        } else {
            holder.userLayout.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public Filter getFilter() {
        return new UserSelectorAdapterFilter(this.dataSet, this);
    }


//    Context context;
//    int resource;
//    int textViewResourceId;
//    int imageViewResourceId;
//    FermatTextView nameText;
//    ImageView imageViewUser;
//    List<User> items, tempItems, suggestions;
//
//
//    public UserSelectorAdapter(Context context, int resource, int textViewResourceId, List<User>items) {
//        super(context, resource, textViewResourceId, items);
//        this.context = context;
//        this.resource = resource;
//        this.textViewResourceId = textViewResourceId;
//        this.items = items;
//        tempItems = new ArrayList<User>(items);
//        suggestions = new ArrayList<User>();
//    }
//    public UserSelectorAdapter(Context context, int resource, int textViewResourceId,int imageViewResourceId, List<User>items) {
//        super(context, resource, textViewResourceId, items);
//        this.context = context;
//        this.resource = resource;
//        this.textViewResourceId = textViewResourceId;
//        this.imageViewResourceId = imageViewResourceId;
//        this.items = items;
//        tempItems = new ArrayList<User>(items);
//        suggestions = new ArrayList<User>();
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = convertView;
//        if (convertView == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(R.layout.v3_dap_wallet_asset_user_asset_sell_select_users_item, parent, false);
//        }
//        User user = items.get(position);
//        if (user != null) {
//            nameText = (FermatTextView) view.findViewById(R.id.userName);
//            imageViewUser = (ImageView) view.findViewById(R.id.imageView_user_sell_avatar);
//            if (nameText != null)
//                nameText.setText(user.getName());
//            if (user.getActorAssetUser().getProfileImage() != null && user.getActorAssetUser().getProfileImage().length > 0) {
//                Bitmap bitmap = BitmapFactory.decodeByteArray(user.getActorAssetUser().getProfileImage(), 0, user.getActorAssetUser().getProfileImage().length);
//                bitmap = Bitmap.createScaledBitmap(bitmap, 120, 120, true);
//                imageViewUser.setImageDrawable(ImagesUtils.getRoundedBitmap(context.getResources(), bitmap));
//            }
//        }
//        return view;
//    }
//
//    @Override
//    public Filter getFilter() {
//        return nameFilter;
//    }
//    Filter nameFilter = new Filter() {
//        @Override
//        public CharSequence convertResultToString(Object resultValue) {
//            String str = ((User) resultValue).getName();
//            return str;
//        }
//
//        @Override
//        protected Filter.FilterResults performFiltering(CharSequence constraint) {
//            if (constraint != null) {
//                suggestions.clear();
//                for (User user : tempItems) {
//                    if (user.getName().toLowerCase().contains(constraint.toString().toLowerCase())) {
//                        suggestions.add(user);
//                    }
//                }
//                FilterResults filterResults = new FilterResults();
//                filterResults.values = suggestions;
//                filterResults.count = suggestions.size();
//                return filterResults;
//            } else {
//                return new FilterResults();
//            }
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            List<User> filterList = (ArrayList<User>) results.values;
//            if (results != null && results.count > 0) {
//                clear();
//                for (User user : filterList) {
//                    add(user);
//                    notifyDataSetChanged();
//                }
//            }
//        }
//    };
}
