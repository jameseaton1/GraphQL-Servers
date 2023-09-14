package org.example;

import com.netflix.graphql.dgs.*;
import graphql.schema.DataFetchingEnvironment;

import java.util.List;
import java.util.Map;

@DgsComponent
public class MarketDataFetcher {

    private final List<Market> markets = List.of(new Market(1,1,"Market1", 4),
            new Market(2,1, "Market2", 14),
            new Market(3,2, "Market3", 14),
            new Market(4,2, "Market4", 14));


    @DgsData(parentType = "Event", field = "markets")
    public List<Market> getMarkets(DataFetchingEnvironment dfe) {

        Event event = dfe.getSource();
        return markets.stream().filter(x -> x.getEventId() == event.getId()).toList();

    }

    @DgsEntityFetcher(name = "Market")
    public Market getMarket(Map<String, Object> values) {
        return markets.get((int) values.get("id"));
    }

}
