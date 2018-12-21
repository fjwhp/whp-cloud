

package com.cloud.whp.admin;

import com.ulisesbocchio.jasyptspringboot.encryptor.DefaultLazyEncryptor;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.springframework.core.env.StandardEnvironment;

/**
 * @author whp
 * @date 2018/10/7
 * <p>
 * 加解密单元测试
 */
public class PigxAdminApplicationTest {
	@Test
	public void testJasypt() {
		// 对应application-dev.yml 中配置的根密码
		System.setProperty("jasypt.encryptor.password", "whp-cloud");
		StringEncryptor stringEncryptor = new DefaultLazyEncryptor(new StandardEnvironment());

		//加密方法
		System.out.println(stringEncryptor.encrypt("whp-cloud"));

		//解密方法
		//System.out.println(stringEncryptor.decrypt("ltJPpR50wT0oIY9kfOe1Iw==="));
		System.out.println(stringEncryptor.decrypt("L3jDmsoWe2v4hI5c3+41tQ8SpxOrWE0d"));
	}
}
