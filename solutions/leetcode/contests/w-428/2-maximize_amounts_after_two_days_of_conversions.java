public class Solution {

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> pairs, double[] rates) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < pairs.size(); i++) {
            String from = pairs.get(i).get(0);
            String to = pairs.get(i).get(1);
            double rate = rates[i];
            
            graph.putIfAbsent(from, new HashMap<>());
            graph.putIfAbsent(to, new HashMap<>());
            
            graph.get(from).put(to, rate);
            graph.get(to).put(from, 1.0 / rate); 
        }
        
        return graph;
    }

    private Map<String, Map<String, Double>> floydWarshall(Map<String, Map<String, Double>> graph) {
        Map<String, Map<String, Double>> dist = new HashMap<>();
        
        for (String currency : graph.keySet()) {
            dist.put(currency, new HashMap<>());
            for (String otherCurrency : graph.keySet()) {
                if (currency.equals(otherCurrency)) {
                    dist.get(currency).put(otherCurrency, 1.0); 
                } else if (graph.get(currency).containsKey(otherCurrency)) {
                    dist.get(currency).put(otherCurrency, graph.get(currency).get(otherCurrency));
                } else {
                    dist.get(currency).put(otherCurrency, 0.0); 
                }
            }
        }

        for (String k : graph.keySet()) {
            for (String i : graph.keySet()) {
                for (String j : graph.keySet()) {
                    dist.get(i).put(j, Math.max(dist.get(i).get(j), dist.get(i).get(k) * dist.get(k).get(j)));
                }
            }
        }
        
        return dist;
    }

    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, 
                            List<List<String>> pairs2, double[] rates2) {
        Map<String, Map<String, Double>> graph1 = buildGraph(pairs1, rates1);
        Map<String, Map<String, Double>> graph2 = buildGraph(pairs2, rates2);
        
        Map<String, Map<String, Double>> day1Rates = floydWarshall(graph1);
        Map<String, Map<String, Double>> day2Rates = floydWarshall(graph2);
        
        Map<String, Double> day1Amounts = new HashMap<>();
        for (String currency : day1Rates.keySet()) {
            if (day1Rates.get(initialCurrency).containsKey(currency)) {
                day1Amounts.put(currency, day1Rates.get(initialCurrency).get(currency));
            }
        }
        day1Amounts.put(initialCurrency, 1.0); 
        double maxAmount = 1.0;
        for (Map.Entry<String, Double> entry : day1Amounts.entrySet()) {
            String currency = entry.getKey();
            double amount = entry.getValue();
            
            if (day2Rates.containsKey(currency) && day2Rates.get(currency).containsKey(initialCurrency)) {
                maxAmount = Math.max(maxAmount, amount * day2Rates.get(currency).get(initialCurrency));
            }
        }
        
        return maxAmount;
    }
}
