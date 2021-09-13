package modules;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.sun.org.apache.xpath.internal.operations.Mod;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;

public class App {
        public static void main(String[] args){
            staticFileLocation("/public");

            // the root route
            get("/", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
//                ArrayList<modules.Warriors> warriors = modules.Warriors.getAll();
//                model.put("hero", warriors);
                return new ModelAndView(model,"index.hbs");
            }, new HandlebarsTemplateEngine());

            // the heroes form route
            get("/heroes/new", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("squads", Squad.getAllSquad());
                return new ModelAndView(model, "heroes.hbs");
            }, new HandlebarsTemplateEngine());

            //view heroes route
//            post("/viewhero/new", (request, response) -> {
//                Map<String,Object> model = new HashMap<String, Object>();
//                ArrayList<modules.Warriors> warriors =request.session().attribute("warriors");
//                String hero = request.queryParams("hero");
//                request.session().attribute("hero", hero);
//                model.put("hero", hero);
//
//                String heroAge = request.queryParams("heroAge");
//                request.session().attribute("heroAge", heroAge);
//                model.put("heroAge", heroAge);
//
//                String powers = request.queryParams("powers");
//                request.session().attribute("powers", powers);
//                model.put("powers", powers);
//
//                String weakness = request.queryParams("weakness");
//                request.session().attribute("weakness", weakness);
//                model.put("weakness", weakness);
//
//                return new ModelAndView(model, "viewhero.hbs");
//            }, new HandlebarsTemplateEngine());


            post("/viewhero/new", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                ArrayList<Warriors> warriors = request.session().attribute("warriors");
                if(warriors == null){
                    warriors = new ArrayList<Warriors>();
                    request.session().attribute("warriors", warriors);
                }

                Squad squad = Squad.search(Integer.parseInt(request.queryParams("memberId")));
                String hero = request.queryParams("hero");
                int heroAge = Integer.parseInt(request.queryParams("heroAge"));
                String power = request.queryParams("power");
                String weakness = request.queryParams("weakness");
                Warriors warrior = new Warriors(hero,heroAge,power,weakness,squad.getMemberId());
                warriors.add(warrior);
                return new ModelAndView(model, "viewhero.hbs");
            }, new HandlebarsTemplateEngine());

            //squads route
            get("/squad", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                return new ModelAndView(model, "squad.hbs");
            }, new HandlebarsTemplateEngine());

            //view squads route
            post("/viewSquad", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                ArrayList<Squad> squads = request.session().attribute("squads");
                if(squads == null){
                    squads = new ArrayList<Squad>();
                    request.session().attribute("squads", squads);
                }

                String squadName = request.queryParams("squadName");
                int squadSize = Integer.parseInt(request.queryParams("squadSize"));
                String cause = request.queryParams("cause");
                Squad nextSquad = new Squad(squadName,cause, squadSize);
                squads.add(nextSquad);
//                model.put("squadName", squadName);
//                model.put("cause", cause);
                return new ModelAndView(model,"viewSquad.hbs");
            }, new HandlebarsTemplateEngine());

            get("/squad",(request, response) -> {
                Map<String, Object> model = new HashMap<>();
                ArrayList<Squad> squads = Squad.getAllSquad();
                model.put("squads", squads);
                return new ModelAndView(model, "squad.hbs");
            }, new HandlebarsTemplateEngine());

            get("viewSquad/:id", (request, response) -> {
                Map<String, Object> model = new HashMap<>();
                Squad squad = Squad.search(Integer.parseInt(request.params(":id")));
                model.put("squad", squad);
                model.put("warriorOfWarriors", squad.getWarriors());
                return new ModelAndView(model, "viewSquad.hbs");
            }, new HandlebarsTemplateEngine());

            get("/heroes/new", (request, response) -> {
               Map<String, Object> model = new HashMap<>();
               model.put("squads", Squad.getAllSquad());
               return new ModelAndView(model, "heroes.hbs");
            }, new HandlebarsTemplateEngine());


            get("/heroes",(request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                ArrayList<Warriors> warriors = Warriors.getAll();
                model.put("warriors", warriors);
                return new ModelAndView(model, "heroes.hbs");
            }, new HandlebarsTemplateEngine());

            get("/heroes/:id",(request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                Warriors warriors = Warriors.searchWarrior(Integer.parseInt(request.params(":id")));
                Squad squad = Squad.search(warriors.getMemberId());
                model.put("warriors", warriors);
                model.put("squad",squad);
                return new ModelAndView(model, "hero.hbs");
            }, new HandlebarsTemplateEngine());

            get("/heroes/form", (request, response) -> {
                Map<String, Object> model = new HashMap<String, Object>();
                model.put("squads",Squad.getAllSquad());
                return new ModelAndView(model, "createhero.hbs");
            }, new HandlebarsTemplateEngine());

        }
}

