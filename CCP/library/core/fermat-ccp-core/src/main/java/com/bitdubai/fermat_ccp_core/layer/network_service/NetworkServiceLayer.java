package com.bitdubai.fermat_ccp_core.layer.network_service;

import com.bitdubai.fermat_api.layer.all_definition.common.abstract_classes.AbstractLayer;
import com.bitdubai.fermat_api.layer.all_definition.common.exceptions.CantStartLayerException;
import com.bitdubai.fermat_ccp_core.layer.network_service.crypto_addresses.CryptoAddressesSubsystem;
import com.bitdubai.fermat_ccp_core.layer.network_service.crypto_payment_request.CryptoPaymentRequestSubsystem;
import com.bitdubai.fermat_ccp_core.layer.network_service.crypto_transmission.CryptoTransmissionSubsystem;
import com.bitdubai.fermat_ccp_api.all_definition.enums.CCPPlugins;

/**
 * Created by Leon Acosta - (laion.cj91@gmail.com) on 22/09/2015.
 *
 * @version 1.0
 * @since Java JDK 1.7
 */
public class NetworkServiceLayer extends AbstractLayer {

    public void start() throws CantStartLayerException {

        addPlugin(
                CCPPlugins.BITDUBAI_CRYPTO_ADDRESSES_NETWORK_SERVICE,
                new CryptoAddressesSubsystem()
        );

        addPlugin(
                CCPPlugins.BITDUBAI_CRYPTO_PAYMENT_REQUEST_NETWORK_SERVICE,
                new CryptoPaymentRequestSubsystem()
        );

        addPlugin(
                CCPPlugins.BITDUBAI_CRYPTO_TRANSMISSION_NETWORK_SERVICE,
                new CryptoTransmissionSubsystem()
        );

    }

}
