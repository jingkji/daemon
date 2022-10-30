package com.kiseki.daemon;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class KisekiDaemonApplicationTests {

	@Test
	void contextLoads() {
		// 1
		System.out.println(3*0.1);
		System.out.println((3*0.1)==0.3);
		// 2
		double a = 0.1;
		int b = 3;
		System.out.println(a*b);
		// 3
		Double c = 0.1;
		Integer d = 3;
		System.out.println(c*d);
		// 4
		BigDecimal bigDecimal = new BigDecimal("0.1");
		BigDecimal result = bigDecimal.multiply(new BigDecimal(3));
		System.out.println(result);





	}

}
