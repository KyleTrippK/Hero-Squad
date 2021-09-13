



import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (req, res) -> {
            ArrayList myHeroArrayList = Hero.getAll();
            Map<String, ArrayList<Hero>> model = new HashMap<>();
            model.put("myHero", myHeroArrayList);
            return new ModelAndView(model, "/index.hbs");
        }, new HandlebarsTemplateEngine());


        post("/heroes/new", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            String name=req.queryParams("name");
            int age = Integer.parseInt(req.queryParams("age"));
            String superPower=req.queryParams("superPower");
            String weakness=req.queryParams("weakness");

            Hero myHero=new Hero(name,age,superPower,weakness);
            model.put("myHero", myHero);

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroSquad", (req, res) -> {
            Map<String, ArrayList<Hero>> model = new HashMap<>();
            return new ModelAndView(model, "/heroSquad.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String squadName=req.queryParams("squadName");
            String cause=req.queryParams("cause");

            Squad mySquad=new Squad(squadName,cause);
            model.put("heroSquad", mySquad);

            return new ModelAndView(model, "/squadSuccess.hbs");
        }, new HandlebarsTemplateEngine());
    }

}