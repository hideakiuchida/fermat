package com.bitdubai.fermat_cbp_api.layer.business_transaction.common.interfaces;

import com.bitdubai.fermat_api.layer.all_definition.enums.CryptoCurrency;
import com.bitdubai.fermat_cbp_api.all_definition.contract.Contract;
import com.bitdubai.fermat_cbp_api.all_definition.enums.OriginTransaction;

import java.math.BigDecimal;

/** This class represents the fields necessary to create a Crypto Money DeStock Transaction
 * Created by Manuel Perez (darkpriestrelative@gmail.com) on 21/12/15.
 */
public class CryptoMoneyDeStockRecord {

    private String publicKeyActor;

    private CryptoCurrency cryptoCurrency;

    private String cbpWalletPublicKey;

    private String cryWalletPublicKey;

    private BigDecimal amount;

    private String memo;

    private BigDecimal priceReference;

    private OriginTransaction originTransaction;

    public CryptoMoneyDeStockRecord(
            BusinessTransactionRecord businessTransactionRecord){

        this.publicKeyActor=businessTransactionRecord.getBrokerPublicKey();
        //For this version, the crypto currency is set to BITCOIN
        this.cryptoCurrency=CryptoCurrency.BITCOIN;
        this.cbpWalletPublicKey=businessTransactionRecord.getCBPWalletPublicKey();
        this.cryWalletPublicKey=businessTransactionRecord.getCryptoWalletPublicKey();
        this.amount=parseLongToBigDecimal(
                businessTransactionRecord.getCryptoAmount());
        this.memo=generateMemo(businessTransactionRecord.getContractHash());
        this.priceReference=businessTransactionRecord.getPriceReference();
        this.originTransaction=OriginTransaction.STOCK_INITIAL;

    }

    public String getPublicKeyActor() {
        return publicKeyActor;
    }

    public void setPublicKeyActor(String publicKeyActor) {
        this.publicKeyActor = publicKeyActor;
    }

    public CryptoCurrency getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setCryptoCurrency(CryptoCurrency cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    public String getCbpWalletPublicKey() {
        return cbpWalletPublicKey;
    }

    public void setCbpWalletPublicKey(String cbpWalletPublicKey) {
        this.cbpWalletPublicKey = cbpWalletPublicKey;
    }

    public String getCryWalletPublicKey() {
        return cryWalletPublicKey;
    }

    public void setCryWalletPublicKey(String cryWalletPublicKey) {
        this.cryWalletPublicKey = cryWalletPublicKey;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public BigDecimal getPriceReference() {
        return priceReference;
    }

    public void setPriceReference(BigDecimal priceReference) {
        this.priceReference = priceReference;
    }

    public OriginTransaction getOriginTransaction() {
        return originTransaction;
    }

    public void setOriginTransaction(OriginTransaction originTransaction) {
        this.originTransaction = originTransaction;
    }

    private BigDecimal parseLongToBigDecimal(long longAmount){
        return BigDecimal.valueOf(longAmount);
    }

    private String generateMemo(String contractHash){
        String memo="DeStock transaction generated by Broker Submit Online business transaction from" +
                " contract "+contractHash;
        return memo;
    }

    @Override
    public String toString() {
        return "CryptoMoneyDeStockRecord{" +
                "publicKeyActor='" + publicKeyActor + '\'' +
                ", cryptoCurrency=" + cryptoCurrency +
                ", cbpWalletPublicKey='" + cbpWalletPublicKey + '\'' +
                ", cryWalletPublicKey='" + cryWalletPublicKey + '\'' +
                ", amount=" + amount +
                ", memo='" + memo + '\'' +
                ", priceReference=" + priceReference +
                ", originTransaction=" + originTransaction +
                '}';
    }
}