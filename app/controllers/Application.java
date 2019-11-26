package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import controllers.action.Secured;
import dao.DataFinder;
import models.Movies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Inject
    private DataFinder dataFinder;

    @Security.Authenticated(Secured.class)
    public Result index() {
        return ok(views.html.index.render());
    }

    @Security.Authenticated(Secured.class)
    public Result dashboardTable() {
        List<Movies> movies = dataFinder.getAllData();
        JsonNode json = Json.toJson(movies);
        return ok(json);
    }

    @Security.Authenticated(Secured.class)
    public Result dashboardTablePage() {
        return ok(views.html.table.render());
    }

    public Result defaultPage(String path) {
        return ok(views.html.notfound.render());
    }

    public Result getCorrelation1() {
        try {
            List<Movies> correlation = dataFinder.getCorrelation1();
            ObjectNode json = Json.newObject();

            List<String> genre = new ArrayList<>();
            List<Long> budget = new ArrayList<>();
//            List<Long> revenue = new ArrayList<>();
            for (Movies movie : correlation) {
                genre.add(movie.getGenre());
                budget.add(movie.getBudget() / 1000000);
//                revenue.add(movie.getGross()/1000000);
            }
            ArrayNode genreArr = json.putArray("genre");
            for (String g : genre) {
                genreArr.add(g);
            }
            ArrayNode budgetArr = json.putArray("maxBudget");
            for (Long b : budget) {
                budgetArr.add(b);
            }
//            ArrayNode revenueArr = json.putArray("revenue");
//            for(Long r: revenue){
//                revenueArr.add(r);
//            }
//            logger.info("result::{}", json);
            return ok(json);
        } catch (Exception e) {
            logger.error("Exception::", e);
            return internalServerError();
        }
    }

    public Result getCorrelation2() {
        try {
            List<Movies> correlation = dataFinder.getCorrelation2();
            ObjectNode json = Json.newObject();
            List<String> director = new ArrayList<>();
            List<Long> votes = new ArrayList<>();
            for (Movies movie : correlation) {
                director.add(movie.getDirector());
                votes.add(movie.getVotes() / 1000);
            }
            ArrayNode directorArr = json.putArray("director");
            for (String g : director) {
                directorArr.add(g);
            }
            ArrayNode votesArr = json.putArray("maxVotes");
            for (Long b : votes) {
                votesArr.add(b);
            }
//            logger.info("result::{}", json);
            return ok(json);
        } catch (Exception e) {
            logger.error("Exception::", e);
            return internalServerError();
        }
    }

    public Result getCorrelation3() {
        try {
            List<Movies> correlation = dataFinder.getCorrelation3();
            ObjectNode json = Json.newObject();
            List<Integer> runtime = new ArrayList<>();
            List<Long> votes = new ArrayList<>();
            for (Movies movie : correlation) {
                runtime.add(movie.getRuntime());
                votes.add(movie.getVotes() / 1000);
            }
            ArrayNode runtimeArr = json.putArray("runtime");
            for (Integer g : runtime) {
                runtimeArr.add(g);
            }
            ArrayNode votesArr = json.putArray("votes");
            for (Long b : votes) {
                votesArr.add(b);
            }
//            logger.info("result::{}", json);
            return ok(json);
        } catch (Exception e) {
            logger.error("Exception::", e);
            return internalServerError();
        }
    }

    public Result getCorrelation4() {
        try {
            List<Movies> correlation = dataFinder.getCorrelation4();
            ObjectNode json = Json.newObject();
            List<String> name = new ArrayList<>();
            List<Double> score = new ArrayList<>();
            for (Movies movie : correlation) {
                name.add(movie.getName());
                score.add(movie.getScore());
            }
            ArrayNode nameArr = json.putArray("name");
            for (String n : name) {
                nameArr.add(n);
            }
            ArrayNode scoreArr = json.putArray("score");
            for (Double s : score) {
                scoreArr.add(s);
            }
//            logger.info("result::{}", json);
            return ok(json);
        } catch (Exception e) {
            logger.error("Exception::", e);
            return internalServerError();
        }
    }

    public Result getCorrelation5() {
        try {
            List<Movies> correlation = dataFinder.getCorrelation5();
            ObjectNode json = Json.newObject();
            List<Long> gross = new ArrayList<>();
            List<String> genre = new ArrayList<>();
            for (Movies movie : correlation) {
                gross.add(movie.getGross() / 1000000);
                genre.add(movie.getGenre());
            }
            ArrayNode grossArr = json.putArray("gross");
            for (Long g : gross) {
                grossArr.add(g);
            }
            ArrayNode genreArr = json.putArray("genre");
            for (String b : genre) {
                genreArr.add(b);
            }
//            logger.info("result::{}", json);
            return ok(json);
        } catch (Exception e) {
            logger.error("Exception::", e);
            return internalServerError();
        }
    }

    public Result getCorrelation6() {
        try {
            List<Movies> correlation = dataFinder.getCorrelation6();
            ObjectNode json = Json.newObject();
            List<String> company = new ArrayList<>();
            List<Long> gross = new ArrayList<>();
            for (Movies movie : correlation) {
                company.add(movie.getCompany());
                gross.add(movie.getGross() / 1000000);
            }
            ArrayNode grossArr = json.putArray("gross");
            for (Long g : gross) {
                grossArr.add(g);
            }
            ArrayNode companyArr = json.putArray("company");
            for (String b : company) {
                companyArr.add(b);
            }
//            logger.info("result::{}", json);
            return ok(json);
        } catch (Exception e) {
            logger.error("Exception::", e);
            return internalServerError();
        }
    }

    public Result getCorrelation7() {
        try {
            List<Movies> correlation = dataFinder.getCorrelation7();
            ObjectNode json = Json.newObject();
            List<String> genre = new ArrayList<>();
            List<Double> score = new ArrayList<>();
            for (Movies movie : correlation) {
                genre.add(movie.getGenre());
                score.add(movie.getScore());
            }
            ArrayNode genreArr = json.putArray("genre");
            for (String g : genre) {
                genreArr.add(g);
            }
            ArrayNode scoreArr = json.putArray("score");
            for (Double b : score) {
                scoreArr.add(b);
            }
//            logger.info("result::{}", json);
            return ok(json);
        } catch (Exception e) {
            logger.error("Exception::", e);
            return internalServerError();
        }
    }

    public Result getCorrelation8() {
        try {
            List<Movies> correlation = dataFinder.getCorrelation8();
            ObjectNode json = Json.newObject();
            List<Integer> movieCnt = new ArrayList<>();
            List<String> genre = new ArrayList<>();
            for (Movies movie : correlation) {
                genre.add(movie.getGenre());
                movieCnt.add(movie.getCount());
            }
            ArrayNode genreArr = json.putArray("genre");
            for (String g : genre) {
                genreArr.add(g);
            }
            ArrayNode cntArr = json.putArray("movieCount");
            for (Integer m : movieCnt) {
                cntArr.add(m);
            }
//            logger.info("result::{}", json);
            return ok(json);
        } catch (Exception e) {
            logger.error("Exception::", e);
            return internalServerError();
        }
    }
}
