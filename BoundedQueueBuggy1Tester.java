import org.junit.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.junit.Assume.*;


import java.lang.Iterable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class BoundedQueueBuggy1Tester {

	// Buggy1
    @Test 
    public void testBuggy1() {
		// Initialize bounded queue with capacity 3
        BoundedQueueBuggy1<Integer> buggy1Queue = new BoundedQueueBuggy1<>(3);
        
        // Add some elements to the queue
        buggy1Queue.put(1);
        buggy1Queue.put(2);
        
        // Try to add a null element, violating rep invariant
        buggy1Queue.put(null);

		assertTrue(buggy1Queue.repOk());
	}

}