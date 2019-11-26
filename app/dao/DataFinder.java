package dao;

import com.google.inject.ImplementedBy;
import models.Movies;

import java.util.List;

@ImplementedBy(DataFinderImpl.class)
public interface DataFinder {
    List<Movies> getCorrelation1();

    List<Movies> getCorrelation2();

    List<Movies> getCorrelation3();

    List<Movies> getCorrelation4();

    List<Movies> getCorrelation5();

    List<Movies> getCorrelation6();

    List<Movies> getCorrelation7();

    List<Movies> getCorrelation8();

    List<Movies> getAllData();
}
