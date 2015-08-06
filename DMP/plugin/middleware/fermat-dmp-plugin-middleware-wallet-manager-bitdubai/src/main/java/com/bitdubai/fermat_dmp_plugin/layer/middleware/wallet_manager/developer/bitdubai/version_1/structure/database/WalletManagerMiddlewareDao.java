package com.bitdubai.fermat_dmp_plugin.layer.middleware.wallet_manager.developer.bitdubai.version_1.structure.database;

import com.bitdubai.fermat_api.FermatException;
import com.bitdubai.fermat_api.layer.all_definition.enums.Languages;
import com.bitdubai.fermat_api.layer.all_definition.enums.WalletCategory;
import com.bitdubai.fermat_api.layer.all_definition.util.Version;
import com.bitdubai.fermat_api.layer.dmp_middleware.wallet_manager.interfaces.InstalledLanguage;
import com.bitdubai.fermat_api.layer.dmp_middleware.wallet_manager.interfaces.InstalledSkin;
import com.bitdubai.fermat_api.layer.dmp_middleware.wallet_manager.interfaces.InstalledWallet;
import com.bitdubai.fermat_api.layer.osa_android.database_system.Database;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseFilterType;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTable;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTableRecord;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTransaction;
import com.bitdubai.fermat_api.layer.osa_android.database_system.PluginDatabaseSystem;
import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.CantDeleteRecordException;
import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.CantInsertRecordException;
import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.CantLoadTableToMemoryException;
import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.CantOpenDatabaseException;
import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.CantUpdateRecordException;
import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.DatabaseNotFoundException;
import com.bitdubai.fermat_api.layer.osa_android.logger_system.LogManager;
import com.bitdubai.fermat_dmp_plugin.layer.middleware.wallet_manager.developer.bitdubai.version_1.exceptions.CantDeleteWalletLanguageException;
import com.bitdubai.fermat_dmp_plugin.layer.middleware.wallet_manager.developer.bitdubai.version_1.exceptions.CantDeleteWalletSkinException;
import com.bitdubai.fermat_dmp_plugin.layer.middleware.wallet_manager.developer.bitdubai.version_1.exceptions.CantExecuteDatabaseOperationException;
import com.bitdubai.fermat_dmp_plugin.layer.middleware.wallet_manager.developer.bitdubai.version_1.exceptions.CantGetInstalledWalletsException;
import com.bitdubai.fermat_dmp_plugin.layer.middleware.wallet_manager.developer.bitdubai.version_1.exceptions.CantPersistWalletException;
import com.bitdubai.fermat_dmp_plugin.layer.middleware.wallet_manager.developer.bitdubai.version_1.exceptions.CantPersistWalletLanguageException;
import com.bitdubai.fermat_dmp_plugin.layer.middleware.wallet_manager.developer.bitdubai.version_1.exceptions.CantPersistWalletSkinException;
import com.bitdubai.fermat_dmp_plugin.layer.middleware.wallet_manager.developer.bitdubai.version_1.exceptions.CantUpdateWalletNameException;
import com.bitdubai.fermat_dmp_plugin.layer.middleware.wallet_manager.developer.bitdubai.version_1.structure.WalletManagerMiddlewareInstalledLanguage;
import com.bitdubai.fermat_dmp_plugin.layer.middleware.wallet_manager.developer.bitdubai.version_1.structure.WalletManagerMiddlewareInstalledSkin;
import com.bitdubai.fermat_dmp_plugin.layer.middleware.wallet_manager.developer.bitdubai.version_1.structure.WalletManagerMiddlewareInstalledWallet;
import com.bitdubai.fermat_pip_api.layer.pip_platform_service.error_manager.ErrorManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by natalia on 04/08/15.
 */
public class WalletManagerMiddlewareDao {

    /**
     * WalletManagerMiddlewareDatabaseDao member variables
     */
    UUID pluginId;
    Database database;



    /**
     * DealsWithPluginDatabaseSystem interface member variables
     */
    PluginDatabaseSystem pluginDatabaseSystem;



    /**
     * Constructor
     * @param pluginDatabaseSystem
     */
    public WalletManagerMiddlewareDao(PluginDatabaseSystem pluginDatabaseSystem, UUID pluginId) throws CantExecuteDatabaseOperationException {

        this.pluginDatabaseSystem = pluginDatabaseSystem;
        this.pluginId = pluginId;

        database = openDatabase();
        database.closeDatabase();
    }


    private Database openDatabase() throws CantExecuteDatabaseOperationException {
        try {
            return pluginDatabaseSystem.openDatabase(pluginId, WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_DATABASE);
        } catch (CantOpenDatabaseException | DatabaseNotFoundException exception) {
            throw  new CantExecuteDatabaseOperationException(exception, null, "Error in database plugin.");
        }
    }

    private DatabaseTable getDatabaseTable(String tableName){
        DatabaseTable table = database.getTable(tableName);
        return table;
    }

    public  List<InstalledWallet>  getInstalletWallets() throws CantGetInstalledWalletsException {
        List<InstalledWallet> lstInstalledWallet = new ArrayList<InstalledWallet>();
        try{
            database = openDatabase();
            DatabaseTable databaseTable = getDatabaseTable(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_TABLE_NAME);

            databaseTable.loadToMemory();

            List<DatabaseTableRecord> records = databaseTable.getRecords();
            for (DatabaseTableRecord record : records){

                InstalledWallet installedWallet= new WalletManagerMiddlewareInstalledWallet(WalletCategory.getByCode(record.getStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_CATEGORY_COLUMN_NAME)),
                        getInstalletSkin(record.getStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_CATALOG_ID_COLUMN_NAME)),
                        getInstalletLanguage(record.getStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_CATALOG_ID_COLUMN_NAME)),
                        record.getStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_ICON_NAME_COLUMN_NAME),
                        record.getStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_NAME_COLUMN_NAME),
                        record.getStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_PUBLIC_KEY_COLUMN_NAME),
                        record.getStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_PLATFORM_IDENTIFIER_COLUMN_NAME),
                        new Version(1,0,0)
                );


                lstInstalledWallet.add(installedWallet);

            }
        }
        catch (CantLoadTableToMemoryException e){
            throw new CantGetInstalledWalletsException("ERROR GET INTALLEd WALLETS FROM DATABASE",e, null, null);
        }
        catch (Exception exception){
            throw new CantGetInstalledWalletsException("ERROR GET INTALLEd WALLETS FROM DATABASE",FermatException.wrapException(exception), null, null);
        }

        return lstInstalledWallet;
    }



    public void persistWallet (String walletPublicKey,String walletPrivateKey,WalletCategory walletCategory,String walletName, String walletIconName, String walletIdentifier,  UUID walletCatalogueId, Version walletVersion) throws CantPersistWalletException {
        try{
            database = openDatabase();
            DatabaseTable databaseTable = getDatabaseTable(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_TABLE_NAME);
            DatabaseTableRecord record = databaseTable.getEmptyRecord();
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_PUBLIC_KEY_COLUMN_NAME,walletPublicKey);
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_PRIVATE_KEY_COLUMN_NAME, walletPrivateKey);
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_DEVICE_USER_PUBLIC_KEY_COLUMN_NAME, "");
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_CATALOG_ID_COLUMN_NAME, walletCatalogueId.toString());
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_CATEGORY_COLUMN_NAME, walletCategory.getCode());
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_NAME_COLUMN_NAME, walletName);
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_PLATFORM_IDENTIFIER_COLUMN_NAME, walletIdentifier);
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_ICON_NAME_COLUMN_NAME, walletIconName);
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_VERSION_COLUMN_NAME, String.valueOf(walletVersion.getMajor()));


            databaseTable.insertRecord(record);

        }
        catch (CantInsertRecordException e){
            throw new CantPersistWalletException("ERROR PERSISTING WALLET SKIN",e, null, null);
        }
        catch (Exception exception){
            throw new CantPersistWalletException("ERROR PERSISTING WALLET SKIN",FermatException.wrapException(exception), null, null);
        }
    }

    public void persistWalletSkin (UUID walletCatalogueId, UUID skinId, String alias, String Preview, Version version) throws CantPersistWalletSkinException {
        try{
            database = openDatabase();
            DatabaseTable databaseTable = getDatabaseTable(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_TABLE_NAME);
            DatabaseTableRecord record = databaseTable.getEmptyRecord();
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_SKIN_ID_COLUMN_NAME,skinId.toString());
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_WALLET_CATALOG_ID_COLUMN_NAME, walletCatalogueId.toString());
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_SKIN_NAME_COLUMN_NAME, alias);
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_SKIN_PREVIEW_IMAGE_COLUMN_NAME, Preview);
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_SKIN_VERSION_COLUMN_NAME, String.valueOf(version.getMajor()));


            databaseTable.insertRecord(record);

        }
        catch (CantInsertRecordException e){
            throw new CantPersistWalletSkinException("ERROR PERSISTING WALLET SKIN",e, null, null);
        }
        catch (Exception exception){
            throw new CantPersistWalletSkinException("ERROR PERSISTING WALLET SKIN",FermatException.wrapException(exception), null, null);
        }
    }

    public void persistWalletLanguage (UUID walletCatalogueId, UUID languageId, Languages language, String label, Version version) throws CantPersistWalletLanguageException {
        try{
            database = openDatabase();
            DatabaseTable databaseTable = getDatabaseTable(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_LANGUAGES_TABLE_TABLE_NAME);
            DatabaseTableRecord record = databaseTable.getEmptyRecord();
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_LANGUAGES_TABLE_LANGUAGE_ID_COLUMN_NAME,languageId.toString());
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_LANGUAGES_TABLE_WALLET_CATALOG_ID_COLUMN_NAME, walletCatalogueId.toString());
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_LANGUAGES_TABLE_LANGUAGE_NAME_COLUMN_NAME, language.value());
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_LANGUAGES_TABLE_LANGUAGE_LABEL_COLUMN_NAME, label);
            record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_LANGUAGES_TABLE_LANGUAGE_VERSION_COLUMN_NAME, String.valueOf(version.getMajor()));


            databaseTable.insertRecord(record);

        }
        catch (CantInsertRecordException e){
            throw new CantPersistWalletLanguageException("ERROR PERSISTING WALLET LANGUAGE",e, null, null);
        }
        catch (Exception exception){
            throw new CantPersistWalletLanguageException("ERROR PERSISTING WALLET LANGUAGE", FermatException.wrapException(exception), null, null);
        }
    }

    public void deleteWalletLanguage (UUID walletCatalogueId, UUID languageId) throws CantDeleteWalletLanguageException {
        try{
            database = openDatabase();
            DatabaseTable databaseTable = getDatabaseTable(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_LANGUAGES_TABLE_TABLE_NAME);
           databaseTable.setStringFilter(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_LANGUAGES_TABLE_WALLET_CATALOG_ID_COLUMN_NAME, walletCatalogueId.toString(), DatabaseFilterType.EQUAL);
            databaseTable.setStringFilter(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_LANGUAGES_TABLE_LANGUAGE_ID_COLUMN_NAME, languageId.toString(), DatabaseFilterType.EQUAL);

            databaseTable.loadToMemory();

            List<DatabaseTableRecord> records = databaseTable.getRecords();
            for (DatabaseTableRecord record : records){
                databaseTable.deleteRecord(record);
            }

        }
        catch (CantLoadTableToMemoryException e){
            throw new CantDeleteWalletLanguageException("ERROR DELETING WALLET LANGUAGE OFF TABLE",e, null, null);
        }
        catch (CantDeleteRecordException e){
            throw new CantDeleteWalletLanguageException("ERROR DELETING WALLET LANGUAGE OFF TABLE",e, null, null);
        }
        catch (Exception exception){
            throw new CantDeleteWalletLanguageException("ERROR DELETING WALLET LANGUAGE OFF TABLE",FermatException.wrapException(exception), null, null);
        }
    }

    public void deleteWalletSkin (UUID walletCatalogueId, UUID skinId) throws CantDeleteWalletSkinException {
        try{
            database = openDatabase();
            DatabaseTable databaseTable = getDatabaseTable(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_TABLE_NAME);
            databaseTable.setStringFilter(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_WALLET_CATALOG_ID_COLUMN_NAME, walletCatalogueId.toString(), DatabaseFilterType.EQUAL);
            databaseTable.setStringFilter(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_SKIN_ID_COLUMN_NAME, skinId.toString(), DatabaseFilterType.EQUAL);

            databaseTable.loadToMemory();

            List<DatabaseTableRecord> records = databaseTable.getRecords();
            for (DatabaseTableRecord record : records){
                databaseTable.deleteRecord(record);
            }

        }
        catch (CantLoadTableToMemoryException e){
            throw new CantDeleteWalletSkinException("ERROR DELETING WALLET SKIN OFF TABLE",e, null, null);
        }
        catch (CantDeleteRecordException e){
            throw new CantDeleteWalletSkinException("ERROR DELETING WALLET SKIN OFF TABLE",e, null, null);
        }
        catch (Exception exception){
            throw new CantDeleteWalletSkinException("ERROR DELETING WALLET SKIN OFF TABLE",FermatException.wrapException(exception), null, null);
        }
    }

    public void deleteWallet (UUID walletId) throws CantDeleteWalletSkinException {
        try{
            database = openDatabase();
            DatabaseTable databaseTable = getDatabaseTable(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_TABLE_NAME);
            databaseTable.setStringFilter(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_PUBLIC_KEY_COLUMN_NAME, walletId.toString(), DatabaseFilterType.EQUAL);

            databaseTable.loadToMemory();

            List<DatabaseTableRecord> records = databaseTable.getRecords();
            for (DatabaseTableRecord record : records){
                databaseTable.deleteRecord(record);
                /**
                 * Delete wallet Skins and Languages
                 */
                deleteWalletSkin(record.getUUIDValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_CATALOG_ID_COLUMN_NAME));
                deleteWalletLanguage(record.getUUIDValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_CATALOG_ID_COLUMN_NAME));

            }

        }
        catch (CantLoadTableToMemoryException e){
            throw new CantDeleteWalletSkinException("ERROR DELETING WALLET OFF TABLE",e, null, null);
        }
        catch (CantDeleteWalletSkinException e){
            throw new CantDeleteWalletSkinException("ERROR DELETING WALLET OFF TABLE",e, null, null);
        }
        catch (CantDeleteWalletLanguageException e){
            throw new CantDeleteWalletSkinException("ERROR DELETING WALLET OFF TABLE",e, null, null);
        }
        catch (CantDeleteRecordException e){
            throw new CantDeleteWalletSkinException("ERROR DELETING WALLET OFF TABLE",e, null, null);
        }
        catch (Exception exception){
            throw new CantDeleteWalletSkinException("ERROR DELETING WALLET OFF TABLE",FermatException.wrapException(exception), null, null);
        }
    }


    public void changeWalletName (UUID walletIdInTheDevice, String newName) throws CantUpdateWalletNameException {
        try{
            database = openDatabase();
            DatabaseTable databaseTable = getDatabaseTable(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_TABLE_NAME);
            databaseTable.setStringFilter(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_PUBLIC_KEY_COLUMN_NAME, walletIdInTheDevice.toString(), DatabaseFilterType.EQUAL);

            databaseTable.loadToMemory();

            List<DatabaseTableRecord> records = databaseTable.getRecords();
            for (DatabaseTableRecord record : records){
                record.setStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_WALLETS_TABLE_WALLET_NAME_COLUMN_NAME,newName);

                databaseTable.updateRecord(record);
            }

        }
        catch (CantLoadTableToMemoryException e){
            throw new CantUpdateWalletNameException("ERROR CHANGING WALLET NAME ON TABLE",e, null, null);
        }
        catch (CantUpdateRecordException e){
            throw new CantUpdateWalletNameException("ERROR CHANGING WALLET NAME ON TABLE",e, null, null);
        }
        catch (Exception exception){
            throw new CantUpdateWalletNameException("ERROR CHANGING WALLET NAME ON TABLE",FermatException.wrapException(exception), null, null);
        }
    }

    /**
     * Private methods
     *
     */

    private  List<InstalledSkin>  getInstalletSkin(String walletCatalogId) throws CantGetInstalledWalletsException {
        List<InstalledSkin> lstInstalledSkin = new ArrayList<InstalledSkin>();
        try{
            database = openDatabase();
            DatabaseTable databaseTable = getDatabaseTable(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_TABLE_NAME);
            databaseTable.setStringFilter(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_WALLET_CATALOG_ID_COLUMN_NAME, walletCatalogId, DatabaseFilterType.EQUAL);

            databaseTable.loadToMemory();

            List<DatabaseTableRecord> records = databaseTable.getRecords();
            for (DatabaseTableRecord record : records){

                InstalledSkin installedSkin= new WalletManagerMiddlewareInstalledSkin(record.getUUIDValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_SKIN_ID_COLUMN_NAME),
                        record.getStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_SKIN_NAME_COLUMN_NAME),
                        record.getStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_SKIN_PREVIEW_IMAGE_COLUMN_NAME),
                        new Version(1,0,0)
                );


                lstInstalledSkin.add(installedSkin);

            }
        }
        catch (CantLoadTableToMemoryException e){
            throw new CantGetInstalledWalletsException("ERROR GET INTALLEd SKINS FROM DATABASE",e, null, null);
        }
        catch (Exception exception){
            throw new CantGetInstalledWalletsException("ERROR GET INTALLEd SKINS FROM DATABASE",FermatException.wrapException(exception), null, null);
        }

        return lstInstalledSkin;
    }

    private  List<InstalledLanguage>  getInstalletLanguage(String walletCatalogId) throws CantGetInstalledWalletsException {
        List<InstalledLanguage> lstInstalledLaguage = new ArrayList<InstalledLanguage>();
        try{
            database = openDatabase();
            DatabaseTable databaseTable = getDatabaseTable(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_TABLE_NAME);
            databaseTable.setStringFilter(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_WALLET_CATALOG_ID_COLUMN_NAME, walletCatalogId, DatabaseFilterType.EQUAL);

            databaseTable.loadToMemory();

            List<DatabaseTableRecord> records = databaseTable.getRecords();
            for (DatabaseTableRecord record : records){

                InstalledLanguage installedLanguage= new WalletManagerMiddlewareInstalledLanguage(record.getUUIDValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_SKIN_ID_COLUMN_NAME),
                        Languages.valueOf(record.getStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_LANGUAGES_TABLE_LANGUAGE_NAME_COLUMN_NAME)),
                        record.getStringValue(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_LANGUAGES_TABLE_LANGUAGE_LABEL_COLUMN_NAME),
                        new Version(1,0,0)
                );


                lstInstalledLaguage.add(installedLanguage);

            }
        }
        catch (CantLoadTableToMemoryException e){
            throw new CantGetInstalledWalletsException("ERROR GET INTALLEd SKINS FROM DATABASE",e, null, null);
        }
        catch (Exception exception){
            throw new CantGetInstalledWalletsException("ERROR GET INTALLEd SKINS FROM DATABASE",FermatException.wrapException(exception), null, null);
        }

        return lstInstalledLaguage;
    }

    private void deleteWalletSkin (UUID walletCatalogueId) throws CantDeleteWalletSkinException {
        try{
            database = openDatabase();
            DatabaseTable databaseTable = getDatabaseTable(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_TABLE_NAME);
            databaseTable.setStringFilter(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_SKINS_TABLE_WALLET_CATALOG_ID_COLUMN_NAME, walletCatalogueId.toString(), DatabaseFilterType.EQUAL);

            databaseTable.loadToMemory();

            List<DatabaseTableRecord> records = databaseTable.getRecords();
            for (DatabaseTableRecord record : records){
                databaseTable.deleteRecord(record);
            }

        }
        catch (CantLoadTableToMemoryException e){
            throw new CantDeleteWalletSkinException("ERROR DELETING WALLET SKIN OFF TABLE",e, null, null);
        }
        catch (CantDeleteRecordException e){
            throw new CantDeleteWalletSkinException("ERROR DELETING WALLET SKIN OFF TABLE",e, null, null);
        }
        catch (Exception exception){
            throw new CantDeleteWalletSkinException("ERROR DELETING WALLET SKIN OFF TABLE",FermatException.wrapException(exception), null, null);
        }
    }

    private void deleteWalletLanguage (UUID walletCatalogueId) throws CantDeleteWalletLanguageException {
        try{
            database = openDatabase();
            DatabaseTable databaseTable = getDatabaseTable(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_LANGUAGES_TABLE_TABLE_NAME);
            databaseTable.setStringFilter(WalletManagerMiddlewareDatabaseConstants.WALLET_MANAGER_LANGUAGES_TABLE_WALLET_CATALOG_ID_COLUMN_NAME, walletCatalogueId.toString(), DatabaseFilterType.EQUAL);

            databaseTable.loadToMemory();

            List<DatabaseTableRecord> records = databaseTable.getRecords();
            for (DatabaseTableRecord record : records){
                databaseTable.deleteRecord(record);
            }

        }
        catch (CantLoadTableToMemoryException e){
            throw new CantDeleteWalletLanguageException("ERROR DELETING WALLET LANGUAGE OFF TABLE",e, null, null);
        }
        catch (CantDeleteRecordException e){
            throw new CantDeleteWalletLanguageException("ERROR DELETING WALLET LANGUAGE OFF TABLE",e, null, null);
        }
        catch (Exception exception){
            throw new CantDeleteWalletLanguageException("ERROR DELETING WALLET LANGUAGE OFF TABLE",FermatException.wrapException(exception), null, null);
        }
    }
}
