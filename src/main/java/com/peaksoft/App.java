package com.peaksoft;

import com.peaksoft.model.City;
import com.peaksoft.model.Country;
import com.peaksoft.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//DbConnection.connection();
//        createTablePerson();
//        insertTablePerson(1,"Владимир","Путин",70,"Президент");
//        insertTablePerson(2,"Сергей","Собянин",64,"Мэр");
//        insertTablePerson(3,"Садыр","Жапаров",53,"Президент");
//        insertTablePerson(4,"Айбек","Джунушалиев",47,"Мэр");
//        insertTablePerson(5,"Касым-Жомарт"," Токаев ",69,"Президент");
//        insertTablePerson(6,"Алтай ","Сейдирович",44,"Мэр");
        List<Person> allPerson = getAllPerson();
        System.out.println(allPerson);

        //createTableCountry();
        //insertTableCountry(1,"Россия",7,147182123,1);
        //insertTableCountry(2,"Кыргызтан",996,6700000,3);
        //insertTableCountry(3,"Казахстан",8,19000000,5);

        List<Country> allCountry = getAllCountry();
        System.out.println(allCountry);

        //createTableCity();
        //insertTableCity(1,"Москва",12635466,2,1);
        //insertTableCity(2,"Бишкек",1100000,4,2);
        //insertTableCity(3,"Нурсултан",1300000,6,3);
        List<City> allCity = getAllCity();
        System.out.println(allCity);


        System.out.println(getByIdCity(2));

    }

    public static void createTablePerson() {
        String sql = "CREATE TABLE IF NOT EXISTS person77 (" +
                "id SERIAL PRIMARY KEY ," +
                "name VARCHAR(30) NOT NULL," +
                "surName VARCHAR(30) NOT NULL," +
                "age INTEGER NOT NULL," +
                "position VARCHAR(50)" +
                ");";
        try (Connection conn = DbConnection.connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("table success");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void insertTablePerson(int id, String name, String surName, int age, String position) {
        String sql = "INSERT INTO person77(id,name,surName,age,position)" +
                "VALUES(?,?,?,?,?)";
        try (Connection connection = DbConnection.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surName);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, position);
            preparedStatement.executeUpdate();
            System.out.println("Succesfully added: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Person> getAllPerson() {
        String sql = "SELECT * FROM person77";
        List<Person> personList = new ArrayList<>();
        try (Connection connection = DbConnection.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Person person = new Person();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surName = resultSet.getString("surName");
                int age = resultSet.getInt("age");
                String position = resultSet.getString("position");
                System.out.println(id + " " + name + " " + surName + " " + age + " " + position);
                person.setId(id);
                person.setName(name);
                person.setSurName(surName);
                person.setAge(age);
                person.setPosition(position);
                personList.add(person);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return personList;
    }

    public static void createTableCountry() {
        String sql = "CREATE TABLE IF NOT  EXISTS country77(" +
                "id SERIAL PRIMARY KEY ," +
                "name VARCHAR(30) NOT NULL," +
                "number INTEGER UNIQUE  NOT NULL," +
                "population BIGINT NOT NULL," +
                "person_Id INTEGER REFERENCES person77(id)" +
                "); ";
        try (Connection connection = DbConnection.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("table success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertTableCountry(int id, String name, int number, long population, int person_Id) {
        String sql = "INSERT INTO country77(id,name,number,population,person_Id)" +
                "VALUES(?,?,?,?,?);";
        try (Connection connection = DbConnection.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, number);
            preparedStatement.setLong(4, population);
            preparedStatement.setInt(5, person_Id);
            preparedStatement.executeUpdate();
            System.out.println("Succesfully added: " + name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Country> getAllCountry() {
        String sql = "SELECT * FROM country77;";
        List<Country> countryList = new ArrayList<>();
        try (Connection connection = DbConnection.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Country country = new Country();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int number = resultSet.getInt("number");
                long population = resultSet.getLong("population");
                int person_Id = resultSet.getInt("person_Id");
                System.out.println(id + " " + name + " " + number + " " + population + " " + person_Id);
                country.setCountryId(id);
                country.setCountryName(name);
                country.setNumber(number);
                country.setPopulation(population);
                country.setPeople_id(person_Id);
                countryList.add(country);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return countryList;
    }

    public static void createTableCity() {
        String sql = "CREATE TABLE IF NOT EXISTS city(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(30) NOT NULL," +
                "population INTEGER NOT NULL," +
                "person_Id INTEGER REFERENCES person77(id)," +
                "country_Id INTEGER REFERENCES country77(id)" +
                ");";
        try (Connection connection = DbConnection.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("table success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertTableCity(int id, String name, int population, int person_Id, int country_Id) {
        String sql = "INSERT INTO city(id,name,population,person_Id,country_Id)" +
                "VALUES(?,?,?,?,?);";
        try (Connection connection = DbConnection.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, population);
            preparedStatement.setInt(4, person_Id);
            preparedStatement.setInt(5, country_Id);
            preparedStatement.executeUpdate();
            System.out.println("Succesfully added  " + name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<City> getAllCity() {
        String sql = "SELECT * FROM city;";
        List<City> cityList = new ArrayList<>();
        try (Connection connection = DbConnection.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                City city = new City();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int population = resultSet.getInt("population");
                int person_id = resultSet.getInt("person_Id");
                int country_Id = resultSet.getInt("country_Id");
                System.out.println(id + " " + name + " " + population + " " + person_id + " " + country_Id);
                city.setCityId(id);
                city.setCityName(name);
                city.setPopulation(population);
                city.setPerson_Id(person_id);
                city.setCountry_id(country_Id);
                cityList.add(city);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cityList;
    }

    public static City getByIdCity(int id) {
        City city = null;
        for (City c : getAllCity()) {
            if (c.getCityId() == id) {
                city = c;
            }
        }
        if (city == null) {
            throw new RuntimeException("Нет такого Id");
        } else {
            return city;
        }
    }

}
