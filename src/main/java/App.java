

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (request, response) -> {
            ArrayList myHeroArrayList = Hero.getAll();
            Map<String, ArrayList<Hero>> model = new HashMap<>();
            model.put("myHero", myHeroArrayList);
            return new ModelAndView(model, "/index.hbs");
        }, new HandlebarsTemplateEngine());


        post("/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            String name=request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String superPower=request.queryParams("superPower");
            String weakness=request.queryParams("weakness");

            Hero myHero=new Hero(name,age,superPower,weakness);
            model.put("myHero", myHero);

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroSquad", (request, response) -> {
            Map<String, ArrayList<Hero>> model = new HashMap<>();
            return new ModelAndView(model, "/heroSquad.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String squadName=request.queryParams("squadName");
            String cause=request.queryParams("cause");

            Squad mySquad=new Squad(squadName,cause);
            model.put("heroSquad", mySquad);

            return new ModelAndView(model, "/squadSuccess.hbs");
        }, new HandlebarsTemplateEngine());
    }

}