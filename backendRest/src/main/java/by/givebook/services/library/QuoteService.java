package by.givebook.services.library;

import by.givebook.entities.library.Quote;
import by.givebook.services.SimpleService;

/**
 * Created by operb_000 on 13.05.2016.
 */
public interface QuoteService extends SimpleService<Quote> {
    Quote getRandom();
}
