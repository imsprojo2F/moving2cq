package com.movingcq.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;

import com.movingcq.util.ConfigReloadManager.ConfigListener;

public final class ResourceTools {
	public static final String PATH_CONFIG = "classpath:config.properties";

	private static final Logger logger = Logger.getLogger(ResourceTools.class);

	private static final Map<String, Properties> propertysMap = new ConcurrentHashMap<String, Properties>();

	private ResourceTools() {
	}

	static net.sf.ehcache.concurrent.StripedReadWriteLockSync locks = new net.sf.ehcache.concurrent.StripedReadWriteLockSync(
			16);

	public static Properties getProperty(String path) {
		try {
			File f = ResourceUtils.getFile(path);
			final String key = f.getCanonicalPath();
			final Lock writeLock = locks.getLockForKey(key).writeLock();
			try {
				writeLock.lock();
				Properties val = propertysMap.get(key);
				if (val != null)
					return val;

				final Properties[] temp = new Properties[1];
				ConfigListener listener = new ConfigListener(f.getCanonicalPath(), 6 * 1000L)// TODo
																								// conf
				{
					public void reload(File f) {
						FileInputStream is = null;
						try {
							if (logger.isInfoEnabled())
								logger.info("start reload file:" + f.getCanonicalPath());
							is = new FileInputStream(f);
							Properties prop = new Properties();
							prop.load(is);
							temp[0] = prop;
							propertysMap.put(key, prop);
							if (logger.isInfoEnabled())
								logger.info("reload success file:" + f.getCanonicalPath());
						} catch (Exception e) {
							logger.error("reload error", e);
						} finally {
							IOUtils.closeQuietly(is);
						}
					}
				};
				ConfigReloadManager.getInstance().addListener(listener).waitFirstRun();
				return temp[0];
			} finally {
				writeLock.unlock();
			}
		} catch (Exception e) {
			logger.error("getProperties " + path + " error ", e);
			return null;// return new Properties();
		}
	}

	/**
	 * 获得资源文件属性(缓存)
	 *
	 * @param path
	 *            资文件路径 : classpath:config.properties
	 * @param key
	 *            属性键
	 * @return value 属性值
	 */
	public static String getPropertyValue(String path, String key) {
		String value = "";
		Assert.hasText(path, "path is empty");
		Assert.notNull(key, "prop key is null");
		value = getProperty(path).getProperty(key);
		return value;
	}
}
