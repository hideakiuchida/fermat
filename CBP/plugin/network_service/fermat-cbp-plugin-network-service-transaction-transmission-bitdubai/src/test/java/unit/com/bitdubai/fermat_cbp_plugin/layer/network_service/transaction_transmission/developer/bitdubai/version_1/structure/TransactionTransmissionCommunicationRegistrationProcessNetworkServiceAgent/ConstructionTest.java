package unit.com.bitdubai.fermat_cbp_plugin.layer.network_service.transaction_transmission.developer.bitdubai.version_1.structure.TransactionTransmissionCommunicationRegistrationProcessNetworkServiceAgent;

import com.bitdubai.fermat_api.layer.all_definition.common.system.annotations.NeededPluginReference;
import com.bitdubai.fermat_api.layer.all_definition.enums.Layers;
import com.bitdubai.fermat_api.layer.all_definition.enums.Platforms;
import com.bitdubai.fermat_api.layer.all_definition.enums.Plugins;
import com.bitdubai.fermat_cbp_plugin.layer.network_service.transaction_transmission.developer.bitdubai.version_1.TransactionTransmissionNetworkServicePluginRoot;
import com.bitdubai.fermat_cbp_plugin.layer.network_service.transaction_transmission.developer.bitdubai.version_1.structure.TransactionTransmissionCommunicationRegistrationProcessNetworkServiceAgent;
import com.bitdubai.fermat_p2p_api.layer.p2p_communication.WsCommunicationsCloudClientManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by root on 21/12/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class ConstructionTest {

    @NeededPluginReference(platform = Platforms.COMMUNICATION_PLATFORM, layer = Layers.COMMUNICATION, plugin = Plugins.WS_CLOUD_CLIENT)
    @Mock
    private WsCommunicationsCloudClientManager wsCommunicationsCloudClientManager;

    @Mock
    private TransactionTransmissionNetworkServicePluginRoot transactionTransmissionNetworkServicePluginRoot;

    @Test
    public void ConstructionTest(){
        TransactionTransmissionCommunicationRegistrationProcessNetworkServiceAgent transactionTransmissionCommunicationRegistrationProcessNetworkServiceAgent = new TransactionTransmissionCommunicationRegistrationProcessNetworkServiceAgent(
                this.transactionTransmissionNetworkServicePluginRoot,
                this.wsCommunicationsCloudClientManager.getCommunicationsCloudClientConnection()
        );

        assertThat(transactionTransmissionCommunicationRegistrationProcessNetworkServiceAgent).isNotNull();
    }

}
