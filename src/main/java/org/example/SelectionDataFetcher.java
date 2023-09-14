package org.example;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsEntityFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.util.List;
import java.util.Map;

@DgsComponent
public class SelectionDataFetcher {

    private final List<Selection> selections = List.of(new Selection(1,"Outcome1", "3/1", 1),
            new Selection(2,"Outcome2", "1/1", 1),
            new Selection(3,"Outcome3", "6/1", 2),
            new Selection(4,"Outcome4", "10/1", 2),
            new Selection(5,"Outcome5", "3/1", 3),
            new Selection(6,"Outcome6", "3/1", 3),
            new Selection(7,"Outcome7", "3/1", 3));


    @DgsData(parentType = "Market", field = "selections")
    public List<Selection> getSelections(DataFetchingEnvironment dfe) {

        Market market = dfe.getSource();
        return selections.stream().filter(x -> x.getMarketId() == market.getId()).toList();

    }

    @DgsEntityFetcher(name = "Selection")
    public Selection getSelection(Map<String, Object> values) {
        return selections.get((int) values.get("id"));
    }
}
