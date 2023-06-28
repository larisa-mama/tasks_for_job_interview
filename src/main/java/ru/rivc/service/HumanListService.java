package ru.rivc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rivc.dictionary.HumanEmbeddedDictionary;
import ru.rivc.pojo.Adult;
import ru.rivc.pojo.Human;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;


/**
 * The type Human list service.
 * Service to work with in-memory dictionary
 * TODO methods for task 1,2 and 3
 */
@Service
public class HumanListService {
    private final HumanEmbeddedDictionary dictionary;

    /**
     * Instantiates a new Human list service.
     *
     * @param dictionary the dictionary
     */
    @Autowired
    public HumanListService(HumanEmbeddedDictionary dictionary) {
        this.dictionary = dictionary;
    }

    //TODO findById
    public Human findById(int id) {
        Human human = null;
        try {
            human = dictionary.getHumans().stream().map(s -> (Human) s).filter(z -> z.getId() == id).findFirst().get();
        } catch (RuntimeException exception) {
            exception.printStackTrace();
        }
        return human;
    }

    //TODO groupByName
    public Map<String, List<Adult>> groupByName() {
        Map<String, List<Adult>> myMap = new HashMap<>();
        myMap = dictionary.getHumans().stream().filter(v -> v instanceof Adult).map(c -> (Adult) c).collect(Collectors.groupingBy(Adult::getName));
        return myMap;
    }

    //TODO getRandomHumanForLottery()
    public Human getRandomHumanForLottery() {
        Random random = new Random();
        return (Human) dictionary.getHumans().get(random.nextInt(0, dictionary.getHumans().size() - 1));
    }

}
