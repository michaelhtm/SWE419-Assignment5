import org.junit.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.junit.Assume.*;


import java.lang.Iterable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class BoundedQueueBuggy2Tester {

	
	@Test
    public void testBugg2() {
        BoundedQueueBuggy2<Integer> bqbuggy2 = new BoundedQueueBuggy2<>(1);
        bqbuggy2.put(2);
        //queue is full but still attempting to add another element
        bqbuggy2.put(3);

        assertTrue(bqbuggy2.repOk());
		
		
		
		
		
		
		
		//assertTrue(someQueue.repOk());
    }

}