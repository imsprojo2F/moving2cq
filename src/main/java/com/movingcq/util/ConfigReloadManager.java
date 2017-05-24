package com.movingcq.util;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

//TODo spring bean
public class ConfigReloadManager {
	static ScheduledExecutorService pool;
	static ConfigReloadManager instance;

	public void init() {
		pool = Executors.newScheduledThreadPool(1, new CustomizableThreadFactory("ConfigReloadManager"));
		instance = this;
	}

	public void destroy() {
		pool.shutdownNow();
		pool = null;
	}

	public static ConfigReloadManager getInstance() {
		return instance;
	}

	public ConfigListener addListener(ConfigListener listener) {
		pool.scheduleWithFixedDelay(listener, 0L, listener.delay, TimeUnit.MILLISECONDS);
		return listener;
	}

	/**
	 * @author share
	 */
	public static class ConfigListener implements Runnable {
		String filePath;
		long delay;
		Long lastTime;
		CountDownLatch lock1 = new CountDownLatch(1);

		public ConfigListener(String canonicalPath, long delay) {
			this.filePath = canonicalPath;
			this.delay = delay;
		}

		public void run() {
			final File f = new File(filePath);
			final long lastModified = f.lastModified();
			if (lastTime == null || lastModified > lastTime) {
				lastTime = lastModified;
				try {
					reload(f);
				} finally {
					if (lock1.getCount() > 0)
						lock1.countDown();
				}
			}
		}

		public void reload(File f) {
		}

		public void waitFirstRun() throws InterruptedException {
			lock1.await();
		}
	}
}
