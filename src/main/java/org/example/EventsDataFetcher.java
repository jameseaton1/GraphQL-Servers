package org.example;

import com.netflix.graphql.dgs.*;
import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@DgsComponent
public class EventsDataFetcher {

    private final Logger logger = LoggerFactory.getLogger(EventsDataFetcher.class);

    private final List<Event> events = List.of(new Event(1, "Event1"),
                                                new Event(2, "EVent2"));

   @DgsQuery(field = "events")
    public List<Event> getEvents(@InputArgument String nameFilter) {
        if (!StringUtils.isNotEmpty(nameFilter)) {
            return events;
        }
        List<Event> events = this.events.stream().filter(x -> x.getName().contains(nameFilter)).toList();
        return events;
    }

    @DgsEntityFetcher(name = "Event")
    public Event getEvent(Map<String, Object> values) {
        return events.get((int) values.get("id"));
    }

}
