package com.bitdubai.fermat_cbp_plugin.layer.sub_app_module.crypto_broker_community.developer.bitdubai.version_1;

import com.bitdubai.fermat_api.CantStartPluginException;
import com.bitdubai.fermat_api.FermatException;
import com.bitdubai.fermat_api.layer.all_definition.common.system.abstract_classes.AbstractPlugin;
import com.bitdubai.fermat_api.layer.all_definition.common.system.annotations.NeededAddonReference;
import com.bitdubai.fermat_api.layer.all_definition.common.system.annotations.NeededPluginReference;
import com.bitdubai.fermat_api.layer.all_definition.common.system.interfaces.FermatManager;
import com.bitdubai.fermat_api.layer.all_definition.common.system.utils.PluginVersionReference;
import com.bitdubai.fermat_api.layer.all_definition.enums.Addons;
import com.bitdubai.fermat_api.layer.all_definition.enums.Layers;
import com.bitdubai.fermat_api.layer.all_definition.enums.Platforms;
import com.bitdubai.fermat_api.layer.all_definition.enums.Plugins;
import com.bitdubai.fermat_api.layer.all_definition.enums.ServiceStatus;
import com.bitdubai.fermat_api.layer.all_definition.util.Version;
import com.bitdubai.fermat_api.layer.osa_android.file_system.PluginFileSystem;
import com.bitdubai.fermat_cbp_api.layer.actor_connection.crypto_broker.interfaces.CryptoBrokerActorConnectionManager;
import com.bitdubai.fermat_cbp_api.layer.actor_network_service.crypto_broker.interfaces.CryptoBrokerManager;
import com.bitdubai.fermat_cbp_api.layer.identity.crypto_broker.interfaces.CryptoBrokerIdentityManager;
import com.bitdubai.fermat_cbp_api.layer.identity.crypto_customer.interfaces.CryptoCustomerIdentityManager;
import com.bitdubai.fermat_cbp_plugin.layer.sub_app_module.crypto_broker_community.developer.bitdubai.version_1.structure.CryptoBrokerCommunityManager;
import com.bitdubai.fermat_pip_api.layer.platform_service.error_manager.interfaces.ErrorManager;

/**
 * Created by Leon Acosta - (laion.cj91@gmail.com) on 18/12/2015.
 *
 * @author lnacosta
 * @version 1.0.0
 */
public class CryptoBrokerCommunitySubAppModulePluginRoot extends AbstractPlugin {

    @NeededAddonReference (platform = Platforms.PLUG_INS_PLATFORM     , layer = Layers.PLATFORM_SERVICE     , addon  = Addons .ERROR_MANAGER     )
    private ErrorManager errorManager;

    @NeededAddonReference (platform = Platforms.OPERATIVE_SYSTEM_API  , layer = Layers.SYSTEM               , addon  = Addons .PLUGIN_FILE_SYSTEM)
    private PluginFileSystem pluginFileSystem;

    @NeededPluginReference(platform = Platforms.CRYPTO_BROKER_PLATFORM, layer = Layers.ACTOR_NETWORK_SERVICE, plugin = Plugins.CRYPTO_BROKER     )
    private CryptoBrokerManager cryptoBrokerNetworkServiceManager;

    @NeededPluginReference(platform = Platforms.CRYPTO_BROKER_PLATFORM, layer = Layers.IDENTITY             , plugin = Plugins.CRYPTO_BROKER     )
    private CryptoBrokerIdentityManager cryptoBrokerIdentityManager;

    @NeededPluginReference(platform = Platforms.CRYPTO_BROKER_PLATFORM, layer = Layers.IDENTITY             , plugin = Plugins.CRYPTO_CUSTOMER   )
    private CryptoCustomerIdentityManager cryptoCustomerIdentityManager;

    @NeededPluginReference(platform = Platforms.CRYPTO_BROKER_PLATFORM, layer = Layers.ACTOR_CONNECTION     , plugin = Plugins.CRYPTO_BROKER     )
    private CryptoBrokerActorConnectionManager cryptoBrokerActorConnectionManager;

    CryptoBrokerCommunityManager fermatManager;


    public CryptoBrokerCommunitySubAppModulePluginRoot() {
        super(new PluginVersionReference(new Version()));
    }

    /**
     * PlatformService Interface implementation.
     */
    @Override
    public void start() throws CantStartPluginException {

        try {
            fermatManager = new CryptoBrokerCommunityManager(
                    cryptoBrokerIdentityManager,
                    cryptoBrokerActorConnectionManager,
                    cryptoBrokerNetworkServiceManager,
                    cryptoCustomerIdentityManager,
                    errorManager,
                    pluginFileSystem,
                    pluginId,
                    this.getPluginVersionReference()
            );

            this.serviceStatus = ServiceStatus.STARTED;

        } catch (Exception exception) {

            throw new CantStartPluginException(
                    exception,
                    null,
                    "Crypto broker Community SubApp Module error while starting."
            );
        }
    }

    @Override
    public FermatManager getManager() {
        return fermatManager;
    }

}