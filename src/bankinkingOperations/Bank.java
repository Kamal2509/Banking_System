package bankinkingOperations;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	public static void main(String[] args) {
		List<String> q = new ArrayList<>();
		q.add("1 CREATE 1001 kamal1");
//		q.add("2 DEPOSIT 1001 1000");
		q.add("3 CREATE 1003 kamal3");
		q.add("4 DEPOSIT 1003 1000.0");
		q.add("5 CREATE 1005 kamal5");
		q.add("6 CREATE 1005 kamal6");
		Entrypoint operations = new Entrypoint();
		List<String> results = operations.proceesQueries(q);
		for(String result: results) {
			System.out.println(result+"-------");
		}
	}

}
