package bankinkingOperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entrypoint {

	private List<String> queries = new ArrayList<>();

	

	public List<String> proceesQueries(List<String> queries) {
		List<String> results = new ArrayList<String>();
		Map<Integer, Account> accounts = new HashMap<>();
		for (String query : queries) {
			String[] parts = query.split(" ");
			long timestamp = Long.parseLong(parts[0]);
			String action = (String)parts[1];
			int accountId = Integer.parseInt(parts[2]);
			System.out.println("type of action"+action);

			switch (action) {
			case "CREATE": {
				String accountname = parts[3];
				if(!accounts.containsKey(accountId)) {
					accounts.put(accountId, new Account(accountId, accountname));
					results.add(timestamp+" Account Created "+ accountId);
				}
				else {
					results.add("Account already exist");
				}
				break;
			}
			case "DEPOSIT": {
				double amount = Double.parseDouble(parts[3]);
//				double amount=100.0;
				Account depositAccount= accounts.get(accountId);
				if(depositAccount!=null) {
					depositAccount.deposit(amount);
					results.add(timestamp+" amount deposit "+ amount+" rupees in "+ accountId);
				}
				else {
					results.add("Account does not found");
				}
				break;
			}
//			case "withdraw": {
//				double amount = Double.parseDouble(parts[3]);
//
//			}
//			case "merge": {
//
//			}
			default:
				results.add("No operation performed");
//				throw new IllegalArgumentException("Unexpected value: " + action);
			}

		}
		return results;
	}
}
