package dao;

import io.ebean.Finder;
import models.Movies;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class DataFinderImpl implements DataFinder {
    private static final Finder<Long, Movies> find = new Finder<>(Movies.class);

    @Override
    public List<Movies> getCorrelation1() {
        return find.query().where().select("genre, max(budget) as budget").findList();
//        return find.nativeSql("SELECT genre, max(budget) as budget FROM imdb group by genre").findList();
    }

    @Override
    public List<Movies> getCorrelation2() {
        return find.query().where().select("director, max(votes) as votes").findList();
//        return find.nativeSql("SELECT DISTINCT(director), MAX(votes) as votes FROM imdb group by director;").findList();

    }

    @Override
    public List<Movies> getCorrelation3() {
        return find.query().where().select("runtime, votes").orderBy("runtime").findList();
//        return find.nativeSql("select runtime, votes from imdb order by id;").findList();
    }

    @Override
    public List<Movies> getCorrelation4() {
        return find.nativeSql("SELECT name, max(score) as score from imdb group by year;").findList();
    }

    @Override
    public List<Movies> getCorrelation5() {
        return find.query().where().select("genre, max(gross) as gross").findList();
//        return find.nativeSql("SELECT genre, max(gross) as gross FROM imdb group by genre").findList();
    }

    @Override
    public List<Movies> getCorrelation6() {
        return find.query().where().select("company, max(gross) as gross").findList();
//        return find.nativeSql("select company, max(gross) as gross from imdb group by company").findList();

    }

    @Override
    public List<Movies> getCorrelation7() {
        return find.query().where().select("genre, max(score) as score").findList();
    }

    @Override
    public List<Movies> getCorrelation8() {
        return find.nativeSql("SELECT COUNT(name) as count , genre FROM imdb GROUP BY genre").findList();
    }

    @Override
    public List<Movies> getAllData() {
        return find.query().where().select("budget, company, country, director, genre, gross, name, rating, released, runtime, score, star, votes, writer, year").findList();
    }
}
