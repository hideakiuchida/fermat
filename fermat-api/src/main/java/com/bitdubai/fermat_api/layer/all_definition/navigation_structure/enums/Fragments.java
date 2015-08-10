package com.bitdubai.fermat_api.layer.all_definition.navigation_structure.enums;

import com.bitdubai.fermat_api.layer.all_definition.enums.FermatFragments;
import com.bitdubai.fermat_api.layer.all_definition.navigation_structure.Fragment;

/**
 * Created by rodrigo on 2015.07.20..
 */
public enum Fragments implements FermatFragments {
    CWP_SHELL_LOGIN ("CSL"),
    CWP_WALLET_MANAGER_MAIN ("CWMM"),
    CWP_SUB_APP_DEVELOPER ("CSAD"),
    CWP_WALLET_MANAGER_SHOP ("CWMS"),
    CWP_SHOP_MANAGER_MAIN ("CSMM"),
    CWP_SHOP_MANAGER_FREE("CSMF") ,
    CWP_SHOP_MANAGER_PAID ("CSMP"),
    CWP_SHOP_MANAGER_ACCEPTED_NEARBY("CSMAN"),

    CWP_WALLET_RUNTIME_WALLET_BITCOIN_ALL_BITDUBAI_SEND("CWRWBTCABS"),
    CWP_WALLET_RUNTIME_WALLET_BITCOIN_ALL_BITDUBAI_BALANCE("CWRWBTCABB"),
    CWP_WALLET_RUNTIME_WALLET_BITCOIN_ALL_BITDUBAI_RECEIVE("CWRWBTCABR"),
    CWP_WALLET_RUNTIME_WALLET_BITCOIN_ALL_BITDUBAI_TRANSACTIONS("CWRWBTCABT"),
    CWP_WALLET_RUNTIME_WALLET_BITCOIN_ALL_BITDUBAI_CONTACTS("CWRWBTCABC"),

    CWP_WALLET_RUNTIME_WALLET_AGE_KIDS_ALL_BITDUBAI_PROFILE("CWRWAKABP"),
    CWP_WALLET_RUNTIME_WALLET_AGE_KIDS_ALL_BITDUBAI_DESKTOP("CWRWAKABD"),
    CWP_WALLET_RUNTIME_WALLET_AGE_KIDS_ALL_BITDUBAI_CONTACTS("CWRWAKABC"),
    CWP_WALLET_RUNTIME_WALLET_AGE_KIDS_ALL_BITDUBAI_COMMUNITY("CWRWAKABCT"),

    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_HOME("CWRWAABH"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_BALANCE("CWRWAABB"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SEND("CWRWAABS"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_RECEIVE("CWRWAABR"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SHOPS("CWRWAABSS"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_REFFIL("CWRWAABRF"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_DISCOUNTS("CWRWAABD"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SHOP_SHOP("CWRWAABSHS"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SHOP_PRODUCTS("CWRWAABSHP"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SHOP_REVIEWS("CWRWAABSHR"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SHOP_CHAT("CWRWAABSHC"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SHOP_HISTORY("CWRWAABSHH"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SHOP_MAP("CWRWAABSHM"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_ACCOUNTS_DEBITS("CWRWAABAD"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_ACCOUNT_CREDITS("CWRWAABAC"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_ACCOUNTS_ALL("CWRWAABAA"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_CONTACTS_CHAT("CWRWAABCC"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_CONTACTS("CWRWAABC"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_CONTACTS_SEND("CWRWAABCS"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_CONTACTS_NEW_SEND("CWRWAABCNS"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_CONTACTS_RECEIVE("CWRWAABCR"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_CONTACTS_NEW_RECEIVE("CWRWAABCNR"),
    CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_CHAT_TRX("CWRWAABCTX"),
    CWP_WALLET_RUNTIME_ADULTS_ALL_AVAILABLE_BALANCE("CWRAAAB"),

    CWP_WALLET_ADULTS_ALL_REQUESTS_RECEIVED("CWAARR"),
    CWP_WALLET_ADULTS_ALL_REQUESTS_RECEIVED_HISTORY("CWAARRH"),
    CWP_WALLET_ADULTS_ALL_REQUEST_SEND("CWAARS"),
    CWP_WALLET_ADULTS_ALL_SEND_HISTORY("CWAASH"),
    CWP_WALLET_ADULTS_ALL_DAILY_DISCOUNT("CWAADD"),
    CWP_WALLET_ADULTS_ALL_WEEKLY_DISCOUNT("CWAAWD"),
    CWP_WALLET_ADULTS_ALL_MONTHLY_DISCOUNT("CWAAMD"),

    CWP_SUB_APP_DEVELOPER_DATABASE_TOOLS_DATABASES("CSADDTD"),
    CWP_SUB_APP_DEVELOPER_DATABASE_TOOLS_TABLES("CSADDTT"),
    CWP_SUB_APP_DEVELOPER_DATABASE_TOOLS_RECORDS("CSADDTR"),
    CWP_SUB_APP_DEVELOPER_DATABASE_TOOLS("CSADDT"),
    CWP_SUB_APP_DEVELOPER_LOG_TOOLS("CSADLT"),
    CWP_SUB_APP_DEVELOPER_LOG_LEVEL_1_TOOLS("CSADLL1T"),
    CWP_SUB_APP_DEVELOPER_LOG_LEVEL_2_TOOLS("CSADLL2T"),
    CWP_SUB_APP_DEVELOPER_LOG_LEVEL_3_TOOLS("CSADLL3T"),

    CWP_WALLET_STORE_MAIN ("CWSM"),

    CWP_WALLET_PUBLISHER_MAIN("CWPM"),


    /**
     * WAllet factory
     */
    CWP_WALLET_FACTORY_MAIN ("CWFM"),
    CWP_WALLET_FACTORY_MANAGER ("CWFMG"),
    CWP_WALLET_FACTORY_ESTRUCTURE ("CWFE");



    private String code;

    Fragments(String code) {
        this.code = code;
    }

    public String getKey()   { return this.code; }



    public String toString(){
        return code;
    }

    public static Fragments getValueFromString(String code) {
        /*for (Fragments fragments : Fragments.values()) {
            if (fragments.key.equals(name)) {
                return fragments;
            }
        }*/
        switch (code){

            case "CSL":
                return Fragments.CWP_SHELL_LOGIN;
            case "CWMM":
                return Fragments.CWP_WALLET_MANAGER_MAIN;
            case "CSAD":
                return Fragments.CWP_SUB_APP_DEVELOPER;
            case "CWMS":
                return Fragments.CWP_WALLET_MANAGER_SHOP;
            case "CSMM":
                return Fragments.CWP_SHOP_MANAGER_MAIN;
            case "CSMF":
                return Fragments.CWP_SHOP_MANAGER_FREE;
            case "CSMP":
                return Fragments.CWP_SHOP_MANAGER_PAID;
            case "CSMAN":
                return Fragments.CWP_SHOP_MANAGER_ACCEPTED_NEARBY;
            case "CWRWBTCABS":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_BITCOIN_ALL_BITDUBAI_SEND;
            case "CWRWBTCABB":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_BITCOIN_ALL_BITDUBAI_BALANCE;
            case "CWRWBTCABR":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_BITCOIN_ALL_BITDUBAI_RECEIVE;
            case "CWRWBTCABT":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_BITCOIN_ALL_BITDUBAI_TRANSACTIONS;
            case "CWRWBTCABC":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_BITCOIN_ALL_BITDUBAI_CONTACTS;
            case "CWRWAKABP":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_AGE_KIDS_ALL_BITDUBAI_PROFILE;
            case "CWRWAKABD":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_AGE_KIDS_ALL_BITDUBAI_DESKTOP;
            case "CWRWAKABC":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_AGE_KIDS_ALL_BITDUBAI_CONTACTS;
            case "CWRWAKABCT":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_AGE_KIDS_ALL_BITDUBAI_COMMUNITY;
            case "CWRWAABH":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_HOME;
            case "CWRWAABB":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_BALANCE;
            case "CWRWAABS":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SEND;
            case "CWRWAABR":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_RECEIVE;
            case "CWRWAABSS":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SHOPS;
            case "CWRWAABRF":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_REFFIL;
            case "CWRWAABD":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_DISCOUNTS;
            case "CWRWAABSHS":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SHOP_SHOP;
            case "CWRWAABSHP":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SHOP_PRODUCTS;
            case "CWRWAABSHR":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SHOP_REVIEWS;
            case "CWRWAABSHC":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SHOP_CHAT;
            case "CWRWAABSHH":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SHOP_HISTORY;
            case "CWRWAABSHM":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_SHOP_MAP;
            case "CWRWAABAD":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_ACCOUNTS_DEBITS;
            case "CWRWAABAC":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_ACCOUNT_CREDITS;
            case "CWRWAABAA":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_ACCOUNTS_ALL;
            case "CWRWAABCC":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_CONTACTS_CHAT;
            case "CWRWAABC":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_CONTACTS;
            case "CWRWAABCS":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_CONTACTS_SEND;
            case "CWRWAABCNS":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_CONTACTS_NEW_SEND;
            case "CWRWAABCR":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_CONTACTS_RECEIVE;
            case "CWRWAABCNR":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_CONTACTS_NEW_RECEIVE;
            case "CWRWAABCTX":
                return Fragments.CWP_WALLET_RUNTIME_WALLET_ADULTS_ALL_BITDUBAI_CHAT_TRX;
            case "CWRAAAB":
                return Fragments.CWP_WALLET_RUNTIME_ADULTS_ALL_AVAILABLE_BALANCE;
            case "CWAARR":
                return Fragments.CWP_WALLET_ADULTS_ALL_REQUESTS_RECEIVED;
            case "CWAARRH":
                return Fragments.CWP_WALLET_ADULTS_ALL_REQUESTS_RECEIVED_HISTORY;
            case "CWAARS":
                return Fragments.CWP_WALLET_ADULTS_ALL_REQUEST_SEND;
            case "CWAASH":
                return Fragments.CWP_WALLET_ADULTS_ALL_SEND_HISTORY;
            case "CWAADD":
                return Fragments.CWP_WALLET_ADULTS_ALL_DAILY_DISCOUNT;
            case "CWAAWD":
                return Fragments.CWP_WALLET_ADULTS_ALL_WEEKLY_DISCOUNT;
            case "CWAAMD":
                return Fragments.CWP_WALLET_ADULTS_ALL_MONTHLY_DISCOUNT;
            case "CSADDTD":
                return Fragments.CWP_SUB_APP_DEVELOPER_DATABASE_TOOLS_DATABASES;
            case "CSADDTT":
                return Fragments.CWP_SUB_APP_DEVELOPER_DATABASE_TOOLS_TABLES;
            case "CSADDTR":
                return Fragments.CWP_SUB_APP_DEVELOPER_DATABASE_TOOLS_RECORDS;
            case "CSADDT":
                return Fragments.CWP_SUB_APP_DEVELOPER_DATABASE_TOOLS;
            case "CSADLT":
                return Fragments.CWP_SUB_APP_DEVELOPER_LOG_TOOLS;
            case "CSADLL1T":
                return Fragments.CWP_SUB_APP_DEVELOPER_LOG_LEVEL_1_TOOLS;
            case "CSADLL2T":
                return Fragments.CWP_SUB_APP_DEVELOPER_LOG_LEVEL_2_TOOLS;
            case "CSADLL3T":
                return Fragments.CWP_SUB_APP_DEVELOPER_LOG_LEVEL_3_TOOLS;
            case "CWSM":
                return Fragments.CWP_WALLET_STORE_MAIN;
            case "CWPM":
                return Fragments.CWP_WALLET_PUBLISHER_MAIN;
            case "CWFM":
                return Fragments.CWP_WALLET_FACTORY_MAIN;
            case "CWFMG":
                return Fragments.CWP_WALLET_FACTORY_MANAGER;
            case "CWFE":
                return Fragments.CWP_WALLET_FACTORY_ESTRUCTURE;
            
        }
        
        // throw an IllegalArgumentException or return null
        // throw new IllegalArgumentException("the given number doesn't match any Status.");
        return null;
    }
}