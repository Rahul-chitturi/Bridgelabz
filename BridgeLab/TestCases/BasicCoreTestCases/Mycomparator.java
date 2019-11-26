package BasicCoreTestCases;
import java.util.*;

public class Mycomparator implements Comparator<Integer> {
public int compare(Integer l , Integer r) {
	return (l<r)?1:(l>r)?-1:0;
}
}
