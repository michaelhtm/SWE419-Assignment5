import org.junit.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.junit.Assume.*;


import java.lang.Iterable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class BoundedQueueTester {

	// Happy Path
    @Test
    public void testEmptyQueue() {
		BoundedQueue<Object> bq = new BoundedQueue<>(3);
		assertTrue("Expected queue to be empty", bq.isEmpty());
		assertTrue("Expected Queue to be repOk", bq.repOk());
	}

	// Happy Path
    @Test
    public void testFullQueue() {
		BoundedQueue<Object> bq = new BoundedQueue<>(1);
		bq.put("SWE419");
		assertTrue("Expected queue to be full", bq.isFull());
		assertTrue("Expected Queue to be repOk", bq.repOk());
	}

	// Happy Path (put at least one null)
    @Test
    public void testPut() {
		BoundedQueue<Object> bq = new BoundedQueue<>(1);
		bq.put(null);
		assertTrue("Expected queue to be empty", bq.isEmpty());
		bq.put("SWE419");
		assertTrue("Expected queue to be full", bq.isFull());
		assertTrue("Expected Queue to be repOk", bq.repOk());
	}

	// Passes when exception is thrown
    @Test 
    public void testPutException() {
		BoundedQueue<Object> bq = new BoundedQueue<>(1);
		bq.put("SWE419");
		assertThrows("Expected IllegalStateException", IllegalStateException.class, () -> { bq.put(null); });
	}

	
	// Happy Path
    @Test
    public void testGet() {
		String elem = "SWE419";
		BoundedQueue<Object> bq = new BoundedQueue<>(1);
		bq.put(elem);
		assertEquals(bq.get(), elem);
		assertTrue("Expected Queue to be repOk", bq.repOk());
	}

	// Passes when exception is thrown
    @Test 
    public void testGetException() {
		BoundedQueue<Object> bq = new BoundedQueue<>(1);
		assertThrows(IllegalStateException.class, () -> { bq.get(); });
    }

	// Happy Path (put at least one null)
    @Test
    public void testPutAll() {
        BoundedQueue<Object> bq = new BoundedQueue<>(3);
		List<Object> ls = new ArrayList<>();
		ls.add("SWE419");
		ls.add(4);
		ls.add(null);
		bq.putall(ls);
		assertFalse("Expected queue not to be full", bq.isFull());
		bq.put(9);
		assertTrue("Expected queue to be full", bq.isFull());
		assertTrue("Expected Queue to be repOk", bq.repOk());
    }

	// Passes when exception is thrown
    @Test 
    public void testPutAllException() {
		BoundedQueue<Object> bq = new BoundedQueue<>(2);
		List<Object> ls = new ArrayList<>();
		ls.add("SWE419");
		ls.add(4);
		ls.add(null);
		assertThrows(IllegalStateException.class, () -> { bq.putall(ls); });
	
    }

	// Happy Path
    @Test
    public void testGetAll() {
		BoundedQueue<Object> bq = new BoundedQueue<>(3);
		List<Object> ls = new ArrayList<>();
		ls.add("SWE419");
		ls.add(4);
		bq.putall(ls);
		List<Object> temp = new ArrayList<>();
		bq.getall(temp);
		assertEquals(temp, ls);
		assertTrue("Expected queue to be repOk", bq.repOk());
    
    }

	// Passes when exception is thrown
    @Test
    public void testGetAllException() {
		BoundedQueue<Object> bq = new BoundedQueue<>(1);
		List<Object> temp = new ArrayList<>();
		assertThrows(IllegalStateException.class, () -> { bq.getall(temp); });
    }



	////////////////////////////
	//AF() toString Tests
	
	@Test
	// Test toString() when queue is empty
	public void toStringTestEmpty() {
		BoundedQueue<Object> bq = new BoundedQueue<>(3);
		bq.put(null);
		assertEquals(bq.toString(), "BoundedQueue: []");
	}

	// Test toString() when all elements are strings
	@Test
	public void toStringTestStrings() {
		BoundedQueue<String> bq = new BoundedQueue<>(3);
		String expected = "BoundedQueue: [SWE419, SWE443, CS471]";
		bq.put("SWE419");
		bq.put("SWE443");
		bq.put("CS471");
		assertEquals(bq.toString(), expected);
	}
	
	// Test toString() when all elements are doubles. 
	@Test
	public void toStringTestDoubles() {
		BoundedQueue<Double> bq = new BoundedQueue<>(3);
		String expected = "BoundedQueue: [4.19, 4.43, 4.71]";
		bq.put(4.19);
		bq.put(4.43);
		bq.put(4.71);
		assertEquals(bq.toString(), expected);
		
	}

	// Test toString() when all elements are integers
	@Test
	public void toStringTestIntegers() {
		BoundedQueue<Integer> bq = new BoundedQueue<>(3);
		String expected = "BoundedQueue: [419, 443, 471]";
		bq.put(419);
		bq.put(443);
		bq.put(471);
		assertEquals(bq.toString(), expected);
		
	}
	

	// Test toString() when elements have mixed types (e.g., strings, doubles, integers)
	@Test
	public void toStringTestMixed() {
		BoundedQueue<Object> bq = new BoundedQueue<>(3);
		String expected = "BoundedQueue: [419, 4.43, CS471]";
		bq.put(419);
		bq.put(4.43);
		bq.put("CS471");
		assertEquals(bq.toString(), expected);
		
	}
}
