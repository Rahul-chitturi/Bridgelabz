package BasicCoreTestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bridgelab.utility.Utility;

class ToBinary {

	@Test
	void test0() {
		int arr[]  = Utility.toBinary(12);
		int ar[] = {1,1,0,0};
		assertEquals(ar[0], arr[0]);
	}

}
