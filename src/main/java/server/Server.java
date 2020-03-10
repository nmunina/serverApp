package server;

import engine.Engine;

import static spark.Spark.*;

public class Server {
    public static void main(String[] args) {
        //default port 4567
        staticFiles.location("/public"); // Static files
        get("/calculate", (request, response) ->{

            int length = request.queryMap().get("length").integerValue();
            System.out.println("length: " + length);

            String age = request.queryMap().get("age").value();
            System.out.println("Age: " + age);

            String style = request.queryMap().get("style").value();

            boolean competition = request.queryMap().get("competition").booleanValue();
            System.out.println("Is competing: " + competition);

            System.out.println("It's alive: ");

            response.status(200);
            return Engine.calculateSkiLength(length, age, style, competition);
        });
    }
}