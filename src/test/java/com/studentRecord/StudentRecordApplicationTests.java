package com.studentRecord;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRecordApplicationTests {

	@Test
	public void test()
	{
		int actual =12;
		int expected = 12;
		System.out.println();
		
		Assertions.assertEquals(expected, actual );
	}
	

}
