package com.bitdubai.fermat_api.layer._12_middleware.wallet;

/**
 * Created by ciencias on 3/24/15.
 */
public enum TransferFailedReasons {

    ACCOUNT_FROM_ALREADY_LOCKED ("Account from already locked"),
    ACCOUNT_TO_ALREADY_LOCKED ("Account to already locked"),
    ACCOUNT_FROM_DOES_NOT_BELONG_TO_THIS_WALLET ("Account from does not belong to this wallet"),
    ACCOUNT_TO_DOES_NOT_BELONG_TO_THIS_WALLET ("Account to does not belong to this wallet"),
    ACCOUNT_FROM_NOT_OPEN ("Account from not open"),
    ACCOUNT_TO_NOT_OPEN ("Account to not open"),
    NOT_ENOUGH_FUNDS ("Not enough funds"),
    CANT_SAVE_TRANSACTION("Cant save transaction");

    private String reasonText;
    
    TransferFailedReasons (String reasonText) {
        this.reasonText = reasonText;
    }
    
    public String getReasonText(){
        return this.reasonText;
    }
}
