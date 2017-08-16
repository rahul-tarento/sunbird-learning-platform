package org.ekstep.content.util;

import org.apache.commons.lang3.StringUtils;
import org.ekstep.content.mimetype.mgr.IMimeTypeManager;
import org.ekstep.content.mimetype.mgr.impl.APKMimeTypeMgrImpl;
import org.ekstep.content.mimetype.mgr.impl.AssetsMimeTypeMgrImpl;
import org.ekstep.content.mimetype.mgr.impl.CollectionMimeTypeMgrImpl;
import org.ekstep.content.mimetype.mgr.impl.DefaultMimeTypeMgrImpl;
import org.ekstep.content.mimetype.mgr.impl.DocumentMimeTypeManager;
import org.ekstep.content.mimetype.mgr.impl.ECMLMimeTypeMgrImpl;
import org.ekstep.content.mimetype.mgr.impl.H5PMimeTypeMgrImpl;
import org.ekstep.content.mimetype.mgr.impl.HTMLMimeTypeMgrImpl;
import org.ekstep.content.mimetype.mgr.impl.PluginMimeTypeMgrImpl;
import org.ekstep.content.mimetype.mgr.impl.YoutubeMimeTypeManager;

import com.ilimi.common.dto.CoverageIgnore;
import com.ilimi.common.logger.PlatformLogger;

public class MimeTypeManagerFactory {

	static IMimeTypeManager ecmlMimeTypeMgr = new ECMLMimeTypeMgrImpl();
	static IMimeTypeManager htmlMimeTypeMgr = new HTMLMimeTypeMgrImpl();
	static IMimeTypeManager apkMimeTypeMgr = new APKMimeTypeMgrImpl();
	static IMimeTypeManager collectionMimeTypeMgr = new CollectionMimeTypeMgrImpl();
	static IMimeTypeManager assetsMimeTypeMgr = new AssetsMimeTypeMgrImpl();
	static IMimeTypeManager pluginMimeTypeMgrImpl = new PluginMimeTypeMgrImpl();
	static IMimeTypeManager youtubeMimeTypeMgr = new YoutubeMimeTypeManager();
	static IMimeTypeManager documentMimeTypeMgr = new DocumentMimeTypeManager();
	static IMimeTypeManager defaultMimeTypeMgr = new DefaultMimeTypeMgrImpl();
	static IMimeTypeManager h5pMimeTypeMgr = new H5PMimeTypeMgrImpl();

	@CoverageIgnore
	public static IMimeTypeManager getManager(String contentType, String mimeType) {
		PlatformLogger.log("ContentType: " + contentType + " | MimeType: " + mimeType);
		IMimeTypeManager manager;
		if (StringUtils.equalsIgnoreCase(contentType, "Asset")) {
			manager = assetsMimeTypeMgr;
		} else {
			switch (StringUtils.lowerCase(mimeType)) {
			case "application/vnd.ekstep.ecml-archive":
				manager = ecmlMimeTypeMgr;
				break;
			case "application/vnd.ekstep.html-archive":
				manager = htmlMimeTypeMgr;
				break;
			case "application/vnd.android.package-archive":
				manager = apkMimeTypeMgr;
				break;
			case "application/vnd.ekstep.content-collection":
				manager = collectionMimeTypeMgr;
				break;
			case "assets":
				manager = assetsMimeTypeMgr;
				break;
			case "application/vnd.ekstep.plugin-archive":
				manager = pluginMimeTypeMgrImpl;
				break;
			case "video/youtube":
			case "video/x-youtube":
			case "text/x-url":
				manager = youtubeMimeTypeMgr;
				break;
			case "application/pdf":
			case "application/epub":
			case "application/msword":
				manager = documentMimeTypeMgr;
				break;
			case "application/vnd.ekstep.h5p-archive":
				manager = h5pMimeTypeMgr;
				break;
			default:
				manager = defaultMimeTypeMgr;
				break;
			}
		}

		return manager;
	}
}
