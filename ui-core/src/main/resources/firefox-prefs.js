/*
 * If you make changes to this file while the application is running,
 * the changes will be overwritten when the application exits.
 *
 * To make a manual change to preferences, you can visit the URL about:config
 */

user_pref("browser.download.manager.showWhenStarting", false);
user_pref("browser.download.panel.firstSessionCompleted", false);
user_pref("browser.download.folderList", 2);
user_pref("browser.download.useDownloadDir", true);
user_pref("browser.download.dir", "${browserDownloadFolder}");
user_pref("browser.download.downloadDir", "${browserDownloadFolder}");
user_pref("browser.download.defaultFolder", "${browserDownloadFolder}");
user_pref("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream,application/pdf,application/json,text/csv,image/png,application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
user_pref("pdfjs.disabled", true);
user_pref("network.websocket.allowInsecureFromHTTPS", true);
