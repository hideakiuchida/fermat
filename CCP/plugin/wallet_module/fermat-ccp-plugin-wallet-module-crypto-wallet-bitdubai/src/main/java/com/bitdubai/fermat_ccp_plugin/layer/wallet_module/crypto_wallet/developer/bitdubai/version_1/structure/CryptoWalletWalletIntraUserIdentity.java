package com.bitdubai.fermat_ccp_plugin.layer.wallet_module.crypto_wallet.developer.bitdubai.version_1.structure;

import com.bitdubai.fermat_ccp_api.layer.wallet_module.crypto_wallet.interfaces.CryptoWalletIntraUserIdentity;

/**
 * The class <code>CryptoWalletWalletIntraUserIdentity</code>
 * haves all consumable methods of a crypto wallet intra user identity.
 *
 * A Crypto Wallet Intra User Identity contains all the basic information of the User
 * <p/>
 * Created by natalia on 01/10/15.
 *
 * @author nattyco
 * @version 1.0
 * @since Java JDK 1.7
 */
public class CryptoWalletWalletIntraUserIdentity  implements CryptoWalletIntraUserIdentity {

    String publicKey;
    String alias;
    byte[] profileImage;

    public CryptoWalletWalletIntraUserIdentity(String publicKey, String alias, byte[] profileImage)
    {
        this.publicKey = publicKey;
        this.alias = alias;
        this.profileImage = profileImage;
    }


    @Override
    public String getPublicKey() {
        return this.publicKey;
    }

    @Override
    public String getAlias() {
        return this.alias;
    }

    @Override
    public byte[] getProfileImage() {
        return this.profileImage;
    }
}
