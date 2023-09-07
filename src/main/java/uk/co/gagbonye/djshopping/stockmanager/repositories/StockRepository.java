package uk.co.gagbonye.djshopping.stockmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.co.gagbonye.djshopping.stockmanager.model.Stock;

public interface StockRepository extends CrudRepository<Stock, String> {
}
