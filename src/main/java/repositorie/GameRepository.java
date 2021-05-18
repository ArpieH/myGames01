package repositorie;

import domain.Category;
import domain.Difficulty;
import domain.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    private String baseQ = "select * from game as g inner join category as c on g.category_id = c.id inner join difficulty as d on g.difficulty_id = d.id ";
    public Game findFifthGame() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement(baseQ +"where g.id = 5 ");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            // dit is wat we gaan oproepen via builder
            return creatGameObject(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    public Game findGameByPartName(String string) throws NotFoundException {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement(baseQ + "where LOWER(game_name) LIKE ? ");
            preparedStatement.setString(1,"%"+string+"%");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            // dit is wat we gaan oproepen via builder
            return creatGameObject(resultSet);
        } catch (Exception e) {
            throw new NotFoundException("no such game ");
        }
    }

    public List<Game> showAllGames() {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement(baseQ + " order by game_name ");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Game>gameList =new ArrayList<>();
            while (resultSet.next()){

                gameList.add(creatGameObject(resultSet));
            }
            // dit is wat we gaan oproepen via builder
            return gameList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Game> showAllGames2() {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement(baseQ);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Game>gameList =new ArrayList<>();
            while (resultSet.next()){

                gameList.add(creatGameObject(resultSet));
            }
            // dit is wat we gaan oproepen via builder
            return gameList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Game showAndChoose(String string) throws NotFoundException {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement(baseQ + "where game_name LIKE ?");
            preparedStatement.setString(1,"%"+string+"%");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            // dit is wat we gaan oproepen via builder
            resultSet.next();
            return creatGameObject(resultSet);


        } catch (Exception e) {
            throw new NotFoundException("There is no such game");
        }
    }

    public List<Game> searchByDifficulty(int id) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement(baseQ+" where d.id >=?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Game>gameList=new ArrayList<>();
            while(resultSet.next()){
                gameList.add(creatGameObject(resultSet));


            }
            return gameList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Game findByID(int id) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement(baseQ +"where g.id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            // dit is wat we gaan oproepen via builder
            return creatGameObject(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }



    }
    private Game creatGameObject (ResultSet resultSet) throws SQLException {
        return Game.builder().id(resultSet.getInt("g.id"))
                .gameName(resultSet.getString("game_name"))
                .editor(resultSet.getString("editor"))
                .author(resultSet.getString("author"))
                .age(resultSet.getString("age"))
                .yearEdition(resultSet.getInt("year_edition"))
                .minPlayers(resultSet.getInt("min_players"))
                .maxPlayers(resultSet.getInt("max_players"))
                .category(new Category(resultSet.getInt("c.id"),resultSet.getString("category_name")))
                .playDuration(resultSet.getString("play_duration"))
                .difficulty(new Difficulty(resultSet.getInt("d.id"), resultSet.getString("difficulty_name")))
                .price(resultSet.getDouble("price"))
                .image(resultSet.getString("image"))
                .build();

    }
}
