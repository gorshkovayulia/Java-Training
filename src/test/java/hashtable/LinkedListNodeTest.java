package hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListNodeTest {

    @Test
    public void possibleToPrintNullContent() {
        LinkedListNode node = new LinkedListNode(null, null);
        assertEquals("(null,null)", node.printContent());
    }

    @Test
    public void possibleToPrintListWithTheOnlyPair() {
        LinkedListNode node = new LinkedListNode("test", 10);
        assertEquals("(test,10)", node.printContent());
    }

    @Test
    public void possibleToPrintListWithSeveralPairs() {
        LinkedListNode node = new LinkedListNode("test", 10);
        LinkedListNode node2 = new LinkedListNode("test2", 20);
        node.next = node2;
        assertEquals("(test,10)->(test2,20)", node.printContent());
    }
}